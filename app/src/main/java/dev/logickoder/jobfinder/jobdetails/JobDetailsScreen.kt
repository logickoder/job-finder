package dev.logickoder.jobfinder.jobdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
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
import dev.logickoder.jobfinder.app.theme.paddingSecondary
import dev.logickoder.jobfinder.app.theme.paddingSmall
import dev.logickoder.jobfinder.app.widget.TopBar
import kotlinx.collections.immutable.persistentListOf

@Composable
fun JobDetailsScreen(
    job: Job,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                modifier = Modifier.padding(horizontal = padding() - paddingSecondary()),
                title = job.company,
                onBack = onBack,
                trailingIcon = Icons.Outlined.BookmarkBorder,
            )
        },
        content = { scaffoldPadding ->
            val scrollState = rememberScrollState()
            Box(
                modifier = Modifier.padding(scaffoldPadding),
                content = {
                    Column(
                        modifier = Modifier
                            .padding(bottom = padding() + paddingSecondary())
                            .verticalScroll(scrollState)
                            .padding(padding()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {
                            Spacer(modifier = Modifier.height(padding()))
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
                            JobDetailsPostInfo(job = job)
                            JobDetailsPostDetail(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = padding()),
                                job = job
                            )
                            JobDetailsInfoToggle(modifier = Modifier.fillMaxWidth())
                            Spacer(modifier = Modifier.height(padding()))
                            JobDetailItem(
                                title = stringResource(id = R.string.about_job),
                                content = {
                                    Text(
                                        text = "Infosys Limited is an Indian multinational information technology company that provides business consulting, information technology and outsource services."
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.height(paddingSmall()))
                            JobDetailItem(
                                title = stringResource(id = R.string.job_description),
                                content = {
                                    JobDetailBulletText(
                                        texts = persistentListOf(
                                            "We are looking for a C# developer to build software using languages, technologies of the .NET framework.",
                                            "You will create applications from scratch, configure existing systems and provide user support.Must have Potential to design, develop program independently."
                                        )
                                    )
                                }
                            )
                        }
                    )
                    Button(
                        modifier = Modifier
                            .padding(start = padding(), end = padding(), bottom = padding())
                            .drawBehind {
                                // adds a small shadow on top the text to show content is still available
                                // and removes the shadow when the scroll has reached the last position
                                if (scrollState.canScrollForward) translate(top = -20.dp.toPx()) {
                                    drawRect(
                                        Color.White.copy(alpha = 0.5f),
                                    )
                                }
                            }
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth(),
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
private fun JobDetailsScreenPreview() = JobFinderTheme {
    JobDetailsScreen(
        job = TestJobs[0],
        onBack = {},
    )
}