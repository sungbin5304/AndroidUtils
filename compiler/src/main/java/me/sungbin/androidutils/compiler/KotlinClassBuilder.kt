package me.sungbin.androidutils.compiler

class KotlinClassBuilder(
    className: String,
    packageName: String,
    greeting: String = "Merry Christmas!!"
) {

    private val contentTemplate = """
        package $packageName
        class $className {
             fun greeting() = "$greeting"
        }
    """.trimIndent()

    fun getContent(): String {

        return contentTemplate

    }

}