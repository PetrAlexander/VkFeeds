package com.example.vkfeeds.domain

data class Post(
    val id: Int = 0,
    val groupName: String = "Name",
    val time: String = "17:03",
    val description: String = "Description",
    val options: List<Option> = listOf(
        Option(OptionType.VIEWS, 86),
        Option(OptionType.REPLIES, 20),
        Option(OptionType.COMMENTS, 25),
        Option(OptionType.LIKES, 49),
    )
)