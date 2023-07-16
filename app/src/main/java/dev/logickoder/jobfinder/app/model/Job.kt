package dev.logickoder.jobfinder.app.model

import androidx.annotation.FloatRange
import kotlinx.collections.immutable.toPersistentList
import java.time.LocalDate
import kotlin.random.Random

data class Job(
    val id: String,
    val title: String,
    val company: String,
    val location: String,
    val salary: Double,
    @FloatRange(from = 0.0, to = 5.0) val rating: Float,
    val imageUrl: String,
    val datePosted: LocalDate,
)

val TestJobs = run {
    val images = mapOf(
        "Swift" to "https://developer.apple.com/swift/images/swift-og.png",
        "Kotlin" to "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Kotlin_Icon.svg/1200px-Kotlin_Icon.svg.png",
        "Java" to "https://www.oracle.com/a/ocom/img/cb71-java-logo.png",
        "Python" to "https://www.python.org/static/community_logos/python-logo-master-v3-TM.png",
        "JavaScript" to "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/2048px-Unofficial_JavaScript_logo_2.svg.png",
        "C++" to "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/ISO_C%2B%2B_Logo.svg/2048px-ISO_C%2B%2B_Logo.svg.png",
        "C#" to "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/C_Sharp_wordmark.svg/2048px-C_Sharp_wordmark.svg.png",
        "Go" to "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Go_Logo_Blue.svg/2048px-Go_Logo_Blue.svg.png",
        "PHP" to "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/PHP-logo.svg/2048px-PHP-logo.svg.png",
        "Ruby" to "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Ruby_logo.svg/2048px-Ruby_logo.svg.png",
        "Rust" to "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Rust_programming_language_black_logo.svg/2048px-Rust_programming_language_black_logo.svg.png",
        "Dart" to "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Dart_programming_language_logo.svg/2048px-Dart_programming_language_logo.svg.png",
    )
    val random = Random(0)
    images.map { (title, imageUrl) ->
        Job(
            id = title,
            title = "$title Developer",
            company = "Google",
            location = "Mountain View, CA",
            salary = random.nextDouble(100_000.0, 200_000.0),
            rating = random.nextDouble(3.0, 5.0).toFloat(),
            imageUrl = imageUrl,
            datePosted = LocalDate.now().minusDays(random.nextLong(0, 30)),
        )
    }.toPersistentList()
}