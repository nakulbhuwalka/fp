package org.example

fun main() {
    println("Hello World!")


}

fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
    { a ->
        { b -> f(a, b) }
    }

fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C =
    {a,b -> f(a)(b)}

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C =
    {a -> f(g(a))

    }