package me.sungbin.androidutils.util.licensediaog

sealed class License(val name: String) {
    object MIT : License("MIT")
    object BSD : License("BSD")
    object Apache2 : License("Apache2")
    object GPL3 : License("GPL3")
    object LGPL3 : License("LGPL3")
    class CUSTOM(name: String) : License(name)
}
