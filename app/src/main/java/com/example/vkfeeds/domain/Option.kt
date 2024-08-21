package com.example.vkfeeds.domain

data class Option(
    val type: OptionType,
    val value: Int
)

enum class OptionType {
    VIEWS, REPLIES, LIKES, COMMENTS;
}