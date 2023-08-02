package dev.logickoder.jobfinder.jobdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import dev.logickoder.jobfinder.app.model.TestJobs

class JobDetailsRoute(
    buildContext: BuildContext,
    private val jobId: String,
    private val navigateToUploadResume: () -> Unit,
) : Node(buildContext) {

    @Composable
    override fun View(modifier: Modifier) {
        val job = remember {
            TestJobs.first { it.id == jobId }
        }

        JobDetailsScreen(
            job = job,
            modifier = modifier,
            onBack = ::navigateUp,
            onApplyClicked = navigateToUploadResume,
        )
    }
}