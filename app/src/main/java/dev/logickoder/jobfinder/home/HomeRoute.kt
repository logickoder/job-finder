package dev.logickoder.jobfinder.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node

class HomeRoute(
    buildContext: BuildContext,
) : Node(buildContext) {

    @Composable
    override fun View(modifier: Modifier) {
        HomeScreen(
            modifier = modifier,
        )
    }
}