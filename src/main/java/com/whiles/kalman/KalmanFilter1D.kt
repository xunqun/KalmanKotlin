package com.whiles.kalman

class KalmanFilter1D(guess: Double, estimateUncertainty: Double, val measureUncertainty: Double) {

    /**
     * error variance
     */
    private var p = estimateUncertainty * estimateUncertainty + measureUncertainty
    private var r = measureUncertainty * measureUncertainty

    /**
     * Prediction
     */
    private var prediction = guess

    private var K: Double = 0.0

    fun measure(z: Double): Double {
        K = p / (p + r)
        prediction = prediction + K * (z - prediction)
        p = (1 - K) * p + measureUncertainty
        return prediction
    }
}