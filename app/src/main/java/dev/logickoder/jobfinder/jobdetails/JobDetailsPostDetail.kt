package dev.logickoder.jobfinder.jobdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.logickoder.jobfinder.app.model.Job
import dev.logickoder.jobfinder.app.model.TestJobs
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.paddingSecondary
import dev.logickoder.jobfinder.app.widget.Rating
import kotlin.math.roundToInt

@Composable
fun JobDetailsPostDetail(
    job: Job,
    modifier: Modifier = Modifier,
) {
    val salary = remember {
        "$${(job.salary / 1000).roundToInt()}k"
    }
    val dotSize = paddingSecondary()
    Layout(
        modifier = modifier,
        content = {
            Box(
                Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = MaterialTheme.shapes.large
                    )
                    .height(6.dp),
            )
            DotDecoration(modifier = Modifier.fillMaxWidth())
            TextItem(
                text = "Salary",
                content = {
                    Text(salary)
                }
            )
            TextItem(
                text = "Type",
                content = {
                    Text("Full Time")
                }
            )
            TextItem(
                text = "Ratings",
                content = {
                    Rating(rating = job.rating)
                }
            )
        },
        measurePolicy = { measurables, constraints ->
            // Measure the divider
            val divider = measurables.first().measure(constraints)
            // Measure each text items
            val texts = measurables.subList(2, measurables.size).map {
                it.measure(constraints.copy(minWidth = 0))
            }
            // Get the width of the first and last text items
            val startTextWidth = texts.first().width
            val endTextWidth = texts.last().width
            // Measure the dot decoration to start from the middle of the first text item and
            // end at the middle of the last text item
            val dotDecorationSize =
                constraints.maxWidth - ((startTextWidth / 2) + (endTextWidth / 2)) + dotSize.roundToPx()
            val dotDecoration = measurables[1].measure(
                constraints.copy(
                    minWidth = dotDecorationSize,
                    maxWidth = dotDecorationSize,
                )
            )
            val height = texts.maxOf { it.height } + dotDecoration.height
            // Set the size of the layout as big as it can
            layout(constraints.maxWidth, height) {
                // place the divider first on the screen
                divider.placeRelative(
                    x = 0,
                    y = ((dotDecoration.height - divider.height) / 2),
                )
                // place the dot decoration on top the divider
                dotDecoration.placeRelative(
                    x = (startTextWidth / 2) - (dotSize.roundToPx() / 2),
                    y = 0,
                )
                // place the text items below the divider with equal spacing in between
                val spaceBetweenItems =
                    (constraints.maxWidth - texts.sumOf { it.width }) / (texts.size - 1)
                texts.forEachIndexed { index, text ->
                    text.placeRelative(
                        x = texts.subList(0, index).sumOf { it.width } + index * spaceBetweenItems,
                        y = dotDecoration.height,
                    )
                }
            }
        }
    )
}

@Composable
private fun TextItem(
    text: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(horizontal = paddingSecondary())
            .padding(top = paddingSecondary() / 2),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.W500,
            )
            CompositionLocalProvider(
                LocalTextStyle provides MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.W500,
                ),
                content = content,
            )
        },
    )
}

@Composable
private fun DotDecoration(
    modifier: Modifier = Modifier,
) {
    val dot = @Composable {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape,
                )
                .size(paddingSecondary()),
        )
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
        content = {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 1.dp),
                thickness = 6.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    dot()
                    dot()
                    dot()
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun JobDetailsPostDetailPreview() = JobFinderTheme {
    JobDetailsPostDetail(
        modifier = Modifier.fillMaxWidth(),
        job = TestJobs.first(),
    )
}