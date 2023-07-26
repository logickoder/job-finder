package dev.logickoder.jobfinder.app

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import dev.logickoder.jobfinder.home.HomeRoute
import dev.logickoder.jobfinder.jobdescription.JobDescriptionRoute
import kotlinx.parcelize.Parcelize

class Navigation(
    buildContext: BuildContext,
    startingRoute: Route,
    private val backStack: BackStack<Route> = BackStack(
        initialElement = startingRoute,
        savedStateMap = buildContext.savedStateMap,
    ),
) : ParentNode<Navigation.Route>(
    buildContext = buildContext,
    navModel = backStack,
) {

    @Composable
    override fun View(modifier: Modifier) {
        Children(
            modifier = modifier,
            navModel = backStack,
            transitionHandler = rememberBackstackSlider(),
        )
    }

    override fun resolve(navTarget: Route, buildContext: BuildContext): Node {
        return when (navTarget) {
            Route.Home -> HomeRoute(
                buildContext = buildContext,
            )

            Route.JobDescription -> JobDescriptionRoute(
                buildContext = buildContext,
            )
        }
    }

    sealed interface Route : Parcelable {

        @Parcelize
        object Home : Route

        @Parcelize
        object JobDescription : Route
    }
}