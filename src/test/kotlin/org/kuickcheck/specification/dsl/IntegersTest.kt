package org.kuickcheck.specification.dsl

import org.hamcrest.Matchers.*
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test

class IntegersTest {

    @Test
    fun `Default lower bound for Integers is MIN_VALUE `() {

        // given
        val integers = Integers()

        // check
        assertThat(integers.lowerBound, `is`(equalTo(Int.MIN_VALUE)));
    }

    @Test
    fun `Default upper bound for Integers is MAX_VALUE `() {

        // given
        val integers = Integers()

        // check
        assertThat(integers.upperBound, `is`(equalTo(Int.MAX_VALUE)));

    }

    @Test
    fun `I can create positive Integers domain, from 1 to MAX_VALUE `() {

        // given
        val integers = Integers().allPositive()

        // check
        assertThat(integers.lowerBound, `is`(equalTo(1)));
        assertThat(integers.upperBound, `is`(equalTo(Int.MAX_VALUE)));
    }


    @Test
    fun `I can specify the lower bound `() {

        // given
        val lowerBound = -42

        // when
        val integers = Integers().from { lowerBound }

        // then
        assertThat(integers.lowerBound, `is`(equalTo(lowerBound)));
    }

    @Test
    fun `I can specify the upper bound `() {

        // given
        val upperBound = 1942

        // when
        val integers = Integers().to { upperBound }

        // then
        assertThat(integers.upperBound, `is`(equalTo(upperBound)));
    }

    @Test
    fun `first() return lower bound `() {

        // given
        val lowerBound = -42
        val integers = Integers().from { lowerBound }

        // when
        val first = integers.first()

        // then
        assertThat(first, `is`(equalTo(lowerBound)));
    }

    @Test
    fun `last() return upper bound `() {

        // given
        val upperBound = 1942
        val integers = Integers().to { upperBound }

        // when
        val first = integers.last()

        // then
        assertThat(first, `is`(equalTo(upperBound)));
    }

    @Test
    fun `I can iterate over Integers domain `() {

        // given
        val integers = Integers()

        // when
        val iterator = integers.iterator()

        // then
        assertThat(iterator, `is`(notNullValue()));
        assertTrue(iterator.hasNext())
    }

}