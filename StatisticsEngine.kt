package engine

class StatisticsEngine {

    fun average(scores: List<Double>): Double {
        return if (scores.isEmpty()) 0.0 else scores.sum() / scores.size
    }

    fun highest(scores: List<Double>): Double {
        return scores.maxOrNull() ?: 0.0
    }

    fun lowest(scores: List<Double>): Double {
        return scores.minOrNull() ?: 0.0
    }

    fun passRate(grades: List<String>): Double {

        val passed = grades.count { it != "F" }

        return (passed.toDouble() / grades.size) * 100
    }
}
