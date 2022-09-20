package com.lpi.kdp.chapter2.singleton

object InitBlock {
    init {
        println("I'm initialized!")
    }
}

/**
 * init block is evaluated only once at first initialization of object
 */
fun main() {
    println("started")
    val a = InitBlock // prints what is in init block
    println("a was initialized")
    val b = InitBlock // nothing is printed
    println("b was initialized")
}