package com.lpi.kdp.chapter2.factorymethod

/**
 * Example of factory method used to create Chess Pieces from strings.
 */

interface ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(
    override val file: Char,
    override val rank: Char
) : ChessPiece

data class Rook(
    override val file: Char,
    override val rank: Char
) : ChessPiece

data class Knight(
    override val file: Char,
    override val rank: Char
) : ChessPiece

data class Bishop(
    override val file: Char,
    override val rank: Char
) : ChessPiece

data class King(
    override val file: Char,
    override val rank: Char
) : ChessPiece

data class Queen(
    override val file: Char,
    override val rank: Char
) : ChessPiece


fun createPiece(notation: String): ChessPiece {
    val (type, file, rank) = notation.toCharArray() // destructuring
    return when (type) {
        'p' -> Pawn(file, rank)
        'r' -> Rook(file, rank)
        'n' -> Knight(file, rank)
        'b' -> Bishop(file, rank)
        'q' -> Queen(file, rank)
        'k' -> King(file, rank)
        else -> throw RuntimeException("Unknown piece: $type")
    }
}

fun main() {
    val notations = listOf("pa2", "pb2", "ke1", "qd1", "ra1", "rh1")
    val pieces = notations.map { createPiece(it)}
    println(pieces)
}