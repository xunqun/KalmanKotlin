package com.whiles.kalman

/**
 * This is used to examine a dynamic system that changes its state over the time.
 * For example, we are going to track the constant velocity aircraft in one dimension
 * using the α-β filter.
 *
 * https://www.kalmanfilter.net/alphabeta.html
 *
 * @param alpha will be between 0 to 1
 * @param beta will be between 0 to 1
 */
class AlphaBetaFilter(valueGuess: Double, velocityGuess: Double, val alpha: Float, val beta: Float) {
    var range = valueGuess
    var velocity  = velocityGuess

    fun measure(z: Double, interval: Float): Double{
        val prediction = range + velocity * interval
        range = prediction + alpha * (z - prediction)
        velocity += beta * (z - prediction) / interval

        return range
    }
}