package com.whiles.kalman

import org.junit.Assert.*
import org.junit.Test

class KalmanFilter1DTest {
    @Test
    fun test() {
        val array = listOf<Double>(
            10.0,
            11.0,
            14.0,
            15.0,
            16.0,
            15.0,
            17.0,
            20.0,
            20.0,
            21.0,
            23.0,
            27.0,
            40.0,
            28.0,
            30.0
        )
        val result = arrayListOf<Double>()
        val filter = KalmanFilter1D(11.0, 100.0, 1.0)
        array.forEach{
            print(String.format("%.1f", it) + ",")
            result.add(filter.measure(it))
        }

        println()
        result.forEach{
            print(String.format("%.1f", it) + ",")
        }

    }
}