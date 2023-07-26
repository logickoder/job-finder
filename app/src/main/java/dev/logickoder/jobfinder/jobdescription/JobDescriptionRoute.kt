package dev.logickoder.jobfinder.jobdescription

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node

class JobDescriptionRoute(
    buildContext: BuildContext,
    private val jobId: String,
) : Node(buildContext) {

    @Composable
    override fun View(modifier: Modifier) {

    }
}