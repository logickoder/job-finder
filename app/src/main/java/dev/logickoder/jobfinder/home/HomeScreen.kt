package dev.logickoder.jobfinder.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.app.theme.JobFinderTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier,
        topBar = {
            HomeTopBar()
        },
        content = { scaffoldPadding ->
            Column(
                modifier = Modifier.padding(scaffoldPadding),
                content = {

                }
            )
        },
        bottomBar = {
            HomeBottomBar(
                selectedIndex = selectedIndex,
                onItemSelected = {
                    selectedIndex = it
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() = JobFinderTheme {
    HomeScreen()
}