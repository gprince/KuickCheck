package org.kuickcheck.specification.dsl

import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.kuickcheck.specification.dsl.Integers.Companion.integers

class IntegersShould {

    @Test
    fun `Create Integers domain form -42 to 1942 using the DSL `() {

        // given
        val lowerBound = -42
        val upperBound = 1942

        // when
        val integers = integers {
            from { lowerBound }
            to { upperBound }
        }
        // then
        assertThat(integers.lowerBound, `is`(equalTo(lowerBound)))
        assertThat(integers.upperBound, `is`(equalTo(upperBound)))
    }
}