package engine

import model.GradeScale

class GradeConverter(
    private val gradingScale: List<GradeScale>
) {

    init {
        require(gradingScale.isNotEmpty()) {
            "Grading scale cannot be empty"
        }
    }

    fun convertScore(score: Double): String {

        if (score !in 0.0..100.0) {
            return "INVALID"
        }

        for (scale in gradingScale) {
            if (score in scale.min..scale.max) {
                return scale.grade
            }
        }

        return "N/A"
    }

    fun convertMultiple(scores: Map<String, Double>): Map<String, String> {

        val results = mutableMapOf<String, String>()

        for ((subject, score) in scores) {
            results[subject] = convertScore(score)
        }

        return results
    }
}
