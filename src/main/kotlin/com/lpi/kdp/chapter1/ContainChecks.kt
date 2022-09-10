package com.lpi.kdp.chapter1

fun main() {
    /**
     * Two methods of checking whether two lists have at least one common element
     * I'm used to `contains` but just discovered `in` keyword
     *
     * `in` seems a bit more concise and readable
     */
    val moviesWithFavoriteActors = movies.filter { movie ->
        favoriteActors.any { movie.cast.contains(it) }
    }
    val moviesWithFavoriteActors2 = movies.filter { movie ->
        favoriteActors.any { it in movie.cast }
    }

    println(moviesWithFavoriteActors.map { it.title })
    println(moviesWithFavoriteActors2.map { it.title })
}


//model
data class Movie(
    val title: String,
    val cast: List<Actor>
)

data class Actor(
    val name: String
)

//data
val leonardoDiCaprio = Actor("Leonardo di Caprio")
val morganFreeman = Actor("Morgan Freeman")
val jonahHeel = Actor("Jonah Heel")
val margotRobbie = Actor("Margot Robbie")
val kateWinslet = Actor("Margot Robbie")
val scarlettJohansson = Actor("Scarlett Johansson")
val johnTravolta = Actor("John Travolta")
val umaThurman = Actor("Uma Thurman")
val samuelLJackson = Actor("Samuel L. Jackson")
val arnoldSchwarzenegger = Actor("Arnold Schwarzenegger")

val favoriteActors = listOf(
    leonardoDiCaprio,
    morganFreeman,
    margotRobbie,
)

val movies = listOf(
    Movie("Titanic", listOf(leonardoDiCaprio, kateWinslet)),
    Movie("Wolf of Wall Street", listOf(leonardoDiCaprio, margotRobbie, jonahHeel)),
    Movie("Pulp Fiction", listOf(johnTravolta, umaThurman, samuelLJackson)),
    Movie("Lucy", listOf(scarlettJohansson, morganFreeman)),
    Movie("The Shawshank Redemption", listOf(morganFreeman)),
    Movie("Terminator", listOf(arnoldSchwarzenegger))
)
