package me.sungbin.androidutils.annotation

/**
 * Created by SungBin on 2021-01-15.
 */

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation class ContextChecker(val contextType: Int)