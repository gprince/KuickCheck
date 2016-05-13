package org.kuickcheck.specification.dsl

class Theory {

    companion object {

        fun theory(build: Theory.() -> Unit = {}): Theory {
            val theory = Theory();
            theory.build()
            return theory
        }
    }

    fun <T> forAll(source: Source<T>, build: TheorySpecification<T>.() -> Unit): TheorySpecification<T> {
        val theorySpecification = TheorySpecification(source)
        theorySpecification.build()
        return theorySpecification
    }
}