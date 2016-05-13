package org.kuickcheck.specification.dsl

class Property<T> {

    fun property(property: (T) -> Boolean) {

    }

    fun describedAs(description: () -> String) {

    }

    fun message(message: () -> String) {

    }
}