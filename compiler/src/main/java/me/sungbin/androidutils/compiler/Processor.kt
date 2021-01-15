package me.sungbin.androidutils.compiler

import com.google.auto.service.AutoService
import me.sungbin.androidutils.annotation.ContextChecker
import me.sungbin.androidutils.annotation.Logging
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class Processor : AbstractProcessor() {
    override fun getSupportedAnnotationTypes() =
        mutableSetOf(ContextChecker::class.java.name, Logging::class.java.name)

    override fun getSupportedSourceVersion() = SourceVersion.latest()

    override fun process(
        set: MutableSet<out TypeElement>?,
        roundEnvironment: RoundEnvironment?
    ): Boolean {
        /*roundEnvironment?.getElementsAnnotatedWith(GreetingGenerator::class.java)
            ?.forEach {
                val className = it.simpleName.toString()
                val pack = processingEnv.elementUtils.getPackageOf(it).toString()
                generateClass(className, pack)
            }*/
        return true
    }
}