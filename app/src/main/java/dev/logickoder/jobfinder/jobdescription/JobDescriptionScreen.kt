package dev.logickoder.jobfinder.jobdescription

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.app.model.Job
import dev.logickoder.jobfinder.app.model.TestJobs
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
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
                title = job.company,
                onBack = onBack,
                trailingIcon = Icons.Outlined.BookmarkBorder,
            )
        },
        content = { scaffoldPadding ->

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