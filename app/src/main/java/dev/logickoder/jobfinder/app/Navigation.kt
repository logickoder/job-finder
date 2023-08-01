package dev.logickoder.jobfinder.app

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.operation.push
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import dev.logickoder.jobfinder.home.HomeRoute
import dev.logickoder.jobfinder.jobdetails.JobDetailsRoute
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
                navigateToJobDescription = {
                    backStack.push(Route.JobDetails(it))
                }
            )

            is Route.JobDetails -> JobDetailsRoute(
                buildContext = buildContext,
                jobId = navTarget.jobId,
            )
        }
    }

    sealed interface Route : Parcelable {

        @Parcelize
        data object Home : Route

        @Parcelize
        data class JobDetails(val jobId: String) : Route
    }
}