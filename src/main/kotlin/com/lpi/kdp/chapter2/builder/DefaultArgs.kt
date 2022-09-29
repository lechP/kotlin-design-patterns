package com.lpi.kdp.chapter2.builder

// default arguments
data class MailV3(
    val to: List<String>,
    val cc: List<String> = listOf(),
    val title: String = "",
    val message: String = "",
    val important: Boolean = false,
)

// looks very familiar to builder pattern, but is built in Kotlin feature
val mailV3 = MailV3(
    to = listOf("mr.kenobi@jedi.com"),
    title = "Hello",
    message = "There"
)