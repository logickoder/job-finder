package dev.logickoder.jobfinder.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.HourglassFull
import androidx.compose.material.icons.outlined.Timelapse
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.logickoder.jobfinder.R
import dev.logickoder.jobfinder.app.model.Job
import dev.logickoder.jobfinder.app.model.TestJobs
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.padding
import dev.logickoder.jobfinder.app.theme.paddingSmall
import dev.logickoder.jobfinder.app.widget.Rating
import kotlinx.collections.immutable.ImmutableList
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Composable
fun JobList(
    jobs: ImmutableList<Job>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(
        start = padding(),
        end = padding(),
    ),
    onApplyToJobClicked: (String) -> Unit,
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
                    ),
                    onApplyClicked = onApplyToJobClicked,
                )
            }
        },
    )
}

@Composable
private fun JobItem(
    job: Job,
    modifier: Modifier = Modifier,
    onApplyClicked: (String) -> Unit,
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
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.W500,
                    )
                    Text(
                        text = job.location,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.W500,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        content = {
                            val days = ChronoUnit.DAYS.between(
                                job.datePosted,
                                LocalDate.now()
                            ).toInt()
                            JobInfoItem(
                                icon = Icons.Outlined.Timelapse,
                                text = pluralStringResource(
                                    id = R.plurals.job_posted_date,
                                    count = days,
                                    days
                                ),
                            )
                            JobInfoItem(
                                icon = Icons.Outlined.HourglassFull,
                                text = "Full Time",
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(paddingSmall()))
                    Row(
                        modifier = Modifier.width(IntrinsicSize.Max),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Button(
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    onApplyClicked(job.id)
                                },
                                content = {
                                    Text(
                                        text = stringResource(R.string.apply_now),
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.W700,
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.width(paddingSmall()))
                            IconButton(
                                onClick = {},
                                content = {
                                    Icon(
                                        imageVector = Icons.Outlined.Bookmark,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                    )
                                }
                            )
                        }
                    )
                },
            )
        }
    )
}

@Composable
private fun JobInfoItem(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            Icon(
                modifier = Modifier.size(10.dp),
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun JobItemPreview() = JobFinderTheme {
    JobItem(job = TestJobs[0]) {}
}

@Preview(showBackground = true)
@Composable
private fun JobListPreview() = JobFinderTheme {
    JobList(jobs = TestJobs) {}
}

