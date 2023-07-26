package dev.logickoder.jobfinder.jobdescription

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import dev.logickoder.jobfinder.app.model.TestJobs

class JobDescriptionRoute(
    buildContext: BuildContext,
    private val jobId: String,
) : Node(buildContext) {

    @Composable
    override fun View(modifier: Modifier) {
        val job = remember {
            TestJobs.first { it.id == jobId }
        }

        JobDescriptionScreen(
            job = job,
            modifier = modifier,
            onBack = ::navigateUp,
        )
    }
}