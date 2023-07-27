package dev.logickoder.jobfinder.jobdescription

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import dev.logickoder.jobfinder.app.widget.TopBar

@Composable
fun JobDescriptionScreen(
    job: Job,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                modifier = Modifier.padding(horizontal = padding() - 16.dp),
                title = job.company,
                onBack = onBack,
                trailingIcon = Icons.Outlined.BookmarkBorder,
            )
        },
        content = { scaffoldPadding ->
            Column(
                modifier = Modifier
                    .padding(padding())
                    .padding(scaffoldPadding),
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {
                            AsyncImage(
                                modifier = Modifier.size(70.dp),
//                                modifier = Modifier.fillMaxSize(0.16f),
                                model = job.imageUrl,
                                contentDescription = null,
                            )
                            Text(
                                text = job.title,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontWeight = FontWeight.W500,
                            )
                            JobDescriptionPostInfo(job = job)
                            JobDescriptionPostDetail(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = padding()),
                                job = job
                            )
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {},
                        content = {
                            Text(
                                text = stringResource(R.string.apply_now),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.W700,
                            )
                        }
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun JobDescriptionScreenPreview() = JobFinderTheme {
    JobDescriptionScreen(
        job = TestJobs[0],
        onBack = {},
    )
}