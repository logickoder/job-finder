package dev.logickoder.jobfinder.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.logickoder.jobfinder.app.model.Job
import dev.logickoder.jobfinder.app.model.TestJobs
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.padding
import dev.logickoder.jobfinder.app.theme.paddingSmall
import dev.logickoder.jobfinder.app.widget.Rating
import kotlinx.collections.immutable.ImmutableList

@Composable
fun JobList(
    jobs: ImmutableList<Job>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(
        start = padding(),
        end = padding(),
    ),
) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        content = {
            items(jobs.size) { index ->
                JobItem(
                    job = jobs[index],
                    modifier = Modifier.padding(
                        start = if (index != 0) paddingSmall() else 0.dp,
                    )
                )
            }
        },
    )
}

@Composable
private fun JobItem(
    job: Job,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.large,
            )
            .padding(vertical = 16.dp, horizontal = paddingSmall()),
        content = {
            Rating(
                modifier = Modifier.align(Alignment.TopEnd),
                rating = job.rating,
            )
            Column(
                content = {
                    AsyncImage(
                        modifier = Modifier.size(60.dp),
                        model = job.imageUrl,
                        contentDescription = null,
                    )
                    Text(
                        modifier = Modifier.padding(top = paddingSmall()),
                        text = job.title,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.W500,
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Text(
                        text = job.location,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.W500,
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun JobItemPreview() = JobFinderTheme {
    JobItem(job = TestJobs[0])
}

@Preview(showBackground = true)
@Composable
private fun JobListPreview() = JobFinderTheme {
    JobList(jobs = TestJobs)
}

