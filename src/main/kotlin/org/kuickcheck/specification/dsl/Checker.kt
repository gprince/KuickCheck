package org.kuickcheck.specification.dsl

import org.junit.Assert

class Checker(val theory: Theory) {

    companion object {

        fun check(theory: Theory) {
            val checker = Checker(theory)
            checker.fail()
        }
    }

    fun fail() {
        Assert.fail()
    }
}