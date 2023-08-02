package dev.logickoder.jobfinder.uploadresume

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node

class UploadResumeRoute(
    buildContext: BuildContext,
) : Node(buildContext) {

    @Composable
    override fun View(modifier: Modifier) {

        UploadResumeScreen(
            modifier = modifier,
        )
    }
}