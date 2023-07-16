package dev.logickoder.jobfinder.app.widget

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.app.theme.JobFinderTheme

@Composable
fun Rating(
    @FloatRange(from = 0.0, to = 5.0) rating: Float,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = Color(0xFFF8D048),
            )
            Text(
                modifier = modifier,
                text = String.format("%.1f", rating),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.W500,
                ),
                color = textColor,
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun RatingPreview() = JobFinderTheme {
    Rating(rating = 4.5f)
}
