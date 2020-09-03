package com.sungbin.sungbintool.util


/**
 * Created by SungBin on 2020-09-03.
 */

sealed class ReadMoreType {
    object LINE : ReadMoreType()
    object LENGTH : ReadMoreType()
}