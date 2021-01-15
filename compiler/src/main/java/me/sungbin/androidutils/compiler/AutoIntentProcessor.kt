package me.sungbin.androidutils.compiler

import com.google.auto.service.AutoService
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import me.sungbin.androidutils.annotation.Intentable
import java.util.*
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.Modifier
import javax.lang.model.element.PackageElement
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class AutoIntentProcessor : AbstractProcessor() {
    // todo: apply KotlinPoet (왜 KotlinPoet 쓰면 임폴트가 안될까?)
    private val intentClass = ClassName.get("android.content", "Intent")
    private val contextClass = ClassName.get("android.content", "Context")
    private var methodSpecsList = ArrayList<MethodSpec>()
    private lateinit var packageName: String

    override fun getSupportedAnnotationTypes() = mutableSetOf(Intentable::class.java.name)
    override fun getSupportedSourceVersion() = SourceVersion.latest()

    override fun process(
        set: MutableSet<out TypeElement>?,
        roundEnvironment: RoundEnvironment?
    ): Boolean {
        roundEnvironment?.getElementsAnnotatedWith(Intentable::class.java)
            ?.forEach {
                if (!::packageName.isInitialized) {
                    packageName = (it.enclosingElement as PackageElement).qualifiedName.toString()
                }
                methodSpecsList.add(generateMethod(it as TypeElement)!!)
            }

        if (roundEnvironment!!.processingOver()) {
            return try {
                generateJavaFile(methodSpecsList)
                true
            } catch (exception: Exception) {
                processingEnv.messager.printMessage(Diagnostic.Kind.ERROR, exception.toString())
                false
            }
        }
        return true
    }

    private fun generateMethod(element: TypeElement) = MethodSpec
        .methodBuilder(element.simpleName.toString())
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
        .addParameter(
            contextClass,
            "context"
        )
        .returns(intentClass)
        .addStatement(
            "return new \$T(\$L, \$L)",
            intentClass,
            "context",
            element.qualifiedName.toString() + ".class"
        )
        .build()

    private fun generateJavaFile(methodSpecList: List<MethodSpec>) {
        val builder = TypeSpec.classBuilder("AutoIntent")
        builder.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
        for (methodSpec in methodSpecList) {
            builder.addMethod(methodSpec)
        }
        val typeSpec = builder.build()
        JavaFile.builder(packageName, typeSpec)
            .build()
            .writeTo(processingEnv.filer)
    }

}