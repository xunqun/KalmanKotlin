package com.whiles.kalman

class StaticEstimation(initialGuess: Double) {
    private var count = 0
    private var lastEstimation: Double = initialGuess
    fun measure(z: Double): Double{
        count += 1
        lastEstimation = lastEstimation + (z - lastEstimation) / count
        return lastEstimation
    }
}