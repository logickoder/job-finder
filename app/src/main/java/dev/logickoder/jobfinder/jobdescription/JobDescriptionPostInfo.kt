package dev.logickoder.jobfinder.jobdescription

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.logickoder.jobfinder.R
import dev.logickoder.jobfinder.app.model.Job
import dev.logickoder.jobfinder.app.model.TestJobs
import dev.logickoder.jobfinder.app.model.daysSincePosted
import dev.logickoder.jobfinder.app.theme.JobFinderTheme

@Composable
fun JobDescriptionPostInfo(
    job: Job,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val texts = remember {
        val days = job.daysSincePosted()
        listOf(
            job.company,
            job.location,
            context.resources.getQuantityString(
                R.plurals.job_posted_date,
                days,
                days,
            ),
        )
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            texts.forEachIndexed { index, text ->
                Text(
                    text = text,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                if (index != texts.lastIndex) {
                    Icon(
                        imageVector = Icons.Default.FiberManualRecord,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .size(5.dp),
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun JobDescriptionPostInfoPreview() = JobFinderTheme {
    JobDescriptionPostInfo(
        job = TestJobs.first(),
    )
}