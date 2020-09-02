package com.whiles.kalman

import org.junit.Assert.*
import org.junit.Test

class AlphaBetaFilterTest {
    @Test
    fun test() {
        val filter = AlphaBetaFilter(30000.0, 40.0, 0.2f, 0.1f)
        var last = filter.measure(30110.0, 5.0f)
        println("last=${last}")
        assert(Math.abs(last - 30182) < 1)

        last = filter.measure(30265.0, 5.0f)
        println("last=${last}")
        assert(Math.abs(last - 30351.4) < 1)

        last = filter.measure(30740.0, 5.0f)
        println("last=${last}")
        assert(Math.abs(last - 30573.3) < 1)
    }
}