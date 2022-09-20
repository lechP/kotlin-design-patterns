package com.lpi.kdp.chapter2.singleton

/**
 * dummy implementation of EmptyList object just to have notion how it really works in Kotlin
 */
object EmptyListOfString : List<String> {
    override val size: Int = 0
    override fun get(index: Int): String = throw IndexOutOfBoundsException()

    override fun isEmpty() = true

    override fun iterator(): Iterator<String> = EmptyStringIterator

    override fun listIterator(): ListIterator<String> = EmptyStringIterator

    override fun listIterator(index: Int): ListIterator<String> = EmptyStringIterator

    override fun subList(fromIndex: Int, toIndex: Int): List<String> = listOf()

    override fun lastIndexOf(element: String): Int = -1

    override fun indexOf(element: String): Int = -1

    override fun containsAll(elements: Collection<String>): Boolean = false

    override fun contains(element: String): Boolean = false
}

object EmptyStringIterator : ListIterator<String> {
    override fun hasNext(): Boolean = false
    override fun hasPrevious(): Boolean = false

    override fun next(): String = throw NoSuchElementException()

    override fun nextIndex(): Int = throw IndexOutOfBoundsException()

    override fun previous(): String = throw NoSuchElementException()

    override fun previousIndex(): Int = throw IndexOutOfBoundsException()

}

fun main() {
    val myEmptyList1 = EmptyListOfString
    val myEmptyList2 = EmptyListOfString
    println(myEmptyList1 === myEmptyList2) // the same reference, compiler warns that they're the same

    val defaultEmptyList1 = emptyList<String>()
    val defaultEmptyList2 = emptyList<String>()
    println(defaultEmptyList1 === defaultEmptyList2) // the same reference, compiler doesn't complain

    val listOf1 = listOf<String>()
    val listOf2 = listOf<String>()
    println(listOf1 === listOf2) // also true - listOf() without arguments is alias for emptyList()

}