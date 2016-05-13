package org.kuickcheck.specification.dsl

class TheorySpecification<T>(val source: Source<T>) {

    fun check(build: Property<T>.() -> Unit): Property<T> {
        val property = Property<T>()
        property.build()
        return property
    }

}