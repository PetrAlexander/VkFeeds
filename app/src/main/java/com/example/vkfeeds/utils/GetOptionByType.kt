package com.example.vkfeeds.utils

import com.example.vkfeeds.domain.Option
import com.example.vkfeeds.domain.OptionType

fun List<Option>.getOptionByType(type: OptionType): Option {
    return this.find { it.type == type } ?: throw RuntimeException("Unexpected type")
}