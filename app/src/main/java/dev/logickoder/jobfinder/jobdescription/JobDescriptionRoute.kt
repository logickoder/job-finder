package dev.logickoder.jobfinder.jobdescription

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import dev.logickoder.jobfinder.home.HomeScreen

class JobDescriptionRoute(
    buildContext: BuildContext,
) : Node(buildContext) {

    @Composable
    override fun View(modifier: Modifier) {
        HomeScreen(
            modifier = modifier,
        )
    }
}