package com.whiles.kalman

import org.junit.Assert.*
import org.junit.Test

/**
 * In this class, we are going to estimate the state of the static system.
 * The static system is a system that doesn't change its state over a reasonable
 * period of time.
 *
 * Refer to the link: https://www.kalmanfilter.net/alphabeta.html for more detail.
 */
class StaticEstimationTest {

    @Test
    fun test() {
        val e = StaticEstimation(1000.0)

        // 1st iteration
        var last = e.measure(1030.0)
        assert(last == 1030.0)

        // 2nd iteration
        last = e.measure(989.0)
        assert(last == 1009.5)

        // 3nd iteration
        last = e.measure(1017.0)
        assert(last == 1012.0)
    }
}