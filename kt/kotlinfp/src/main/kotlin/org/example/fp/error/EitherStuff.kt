package org.example.org.example.fp.error

fun main() {

}


fun <E, A, B> Either<E, A>.map(f: (A) -> B): Either<E, B> =
    when(this)
    {
        is Left -> this
        is Right -> Right(f(this.value))
    }

fun <E, A, B> Either<E, A>.flatMap(f: (A) -> Either<E, B>): Either<E, B> =
    when(this)
    {
        is Left -> this
        is Right -> f(this.value)
    }
fun <E, A> Either<E, A>.orElse(f: () -> Either<E, A>): Either<E, A> =
    when(this)
    {
        is Left -> f()
        is Right -> this
    }
fun <E, A, B, C> map2(
    ae: Either<E, A>,
    be: Either<E, B>,
    f: (A, B) -> C
): Either<E, C> =
    when(ae)
    {
        is Left -> ae
        is Right ->
            when(be)
            {
                is Left -> be
                is Right -> Right(f(ae.value,be.value))
            }
    }


sealed class Either<out E, out A>
data class Left<out E>(val value: E) : Either<E, Nothing>()
data class Right<out A>(val value: A) : Either<Nothing, A>()