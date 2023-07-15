package dev.logickoder.jobfinder.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.padding
import dev.logickoder.jobfinder.app.theme.paddingSmall

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier,
        topBar = {
            HomeTopBar(
                modifier = Modifier.padding(
                    horizontal = padding() - 16.dp,
                )
            )
        },
        content = { scaffoldPadding ->
            Column(
                modifier = Modifier.padding(scaffoldPadding),
                content = {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = padding(),
                            vertical = paddingSmall(),
                        ),
                        text = "Your skill is required for many jobs",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.W600,
                        ),
                    )
                    JobSearch(
                        modifier = Modifier.padding(
                            horizontal = padding(),
                        )
                    )
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