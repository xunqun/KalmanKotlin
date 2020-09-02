package com.whiles.kalman

/**
 * This is used to examine a dynamic system that changes its state over the time.
 * For example, we are going to track the constant velocity aircraft in one dimension
 * using the α-β filter.
 *
 * https://www.kalmanfilter.net/alphabeta.html
 */
class AlphaBetaFilter(valueGuess: Double, velocityGuess: Double, val alpha: Float, val beta: Float) {
    var value = valueGuess
    var velocity  = velocityGuess

    fun measure(z: Double, interval: Float): Double{
        val shouldBe = value + velocity * interval
        value = shouldBe + alpha * (z - shouldBe)
        velocity = velocity + beta * (z - shouldBe) / interval

        return value
    }
}