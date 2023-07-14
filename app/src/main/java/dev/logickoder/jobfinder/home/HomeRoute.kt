package dev.logickoder.jobfinder.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.navmodel.backstack.BackStack
import dev.logickoder.jobfinder.app.Navigation

class HomeRoute(
    buildContext: BuildContext,
    private val backStack: BackStack<Navigation.Route>,
) : Node(buildContext) {

    @Composable
    override fun View(modifier: Modifier) {


    }
}