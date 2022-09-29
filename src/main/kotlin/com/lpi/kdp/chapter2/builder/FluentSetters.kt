package com.lpi.kdp.chapter2.builder

// builder pattern with `apply` extension function
data class MailV2(
    val to: List<String>,
    private var _cc: List<String>? = null,
    private var _title: String? = null,
    private var _message: String? = null,
    private var _important: Boolean? = null,
) {
    fun message(message: String) = apply {
        _message = message
    }

    fun title(title: String) = apply {
        _title = title
    }

    fun cc(cc: List<String>) = apply {
        _cc = cc
    }

    fun important(important: Boolean) = apply {
        _important = important
    }

}

val mailV2 = MailV2(listOf("manager@company.com")).message("Ping").important(true)

//alternatively
val mailV2_2 = MailV2(listOf("manager@company.com")).apply {
    message("Something")
    title("Apply")
}