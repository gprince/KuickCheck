package org.kuickcheck.specification.dsl

import org.apache.commons.math3.random.RandomDataGenerator

fun Integers.first(): Int = this.lowerBound
fun Integers.last(): Int = this.upperBound

class Integers : Source<Int> {

    class PseudoRandomIterator(val integers: Integers) : AbstractIterator<Int>() {

        val prng = RandomDataGenerator()

        override fun computeNext() {
            setNext(prng.nextInt(integers.lowerBound, integers.upperBound))
        }
    }

    override operator fun iterator(): Iterator<Int> = PseudoRandomIterator(this)

    private var _lowerBound = Int.MIN_VALUE
    val lowerBound: Int
        get() = _lowerBound

    private var _upperBound = Int.MAX_VALUE
    val upperBound: Int
        get() = _upperBound

    companion object {
        fun integers(build: Integers.() -> Unit): Integers {
            val integers = Integers()
            integers.build()
            return integers
        }
    }

    fun allPositive(): Integers {
        this._lowerBound = 1
        return this
    }

    fun from(lowerBound: () -> Int): Integers {
        this._lowerBound = lowerBound()
        return this
    }

    fun to(upperBound: () -> Int): Integers {
        this._upperBound = upperBound()
        return this
    }
}


//fun main(args: Array<String>) {
//    val source = Integers.integers { allPositive() }
//    val seq = source.asSequence()
//    val values = seq.filter { it % 2 == 0 }.filter { it >= 100 }.filter { it < 3000 }.take(100).toList()
//    println(values.partition { it * 0 == 0 })
//    println(values.partition { it * 1 == it })
//    println(values.partition { it < 1500 })
//}