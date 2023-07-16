package dev.logickoder.jobfinder.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.logickoder.jobfinder.app.model.TestJobs
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
            HomeTopBar()
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
                    Row(
                        modifier = Modifier
                            .padding(horizontal = padding())
                            .padding(top = padding(), bottom = paddingSmall()),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Text(
                                text = "Based on your skills",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontWeight = FontWeight.W600,
                                    fontSize = 20.sp,
                                ),
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            TextButton(
                                onClick = {},
                                content = {
                                    Text(
                                        text = "View all",
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.W500,
                                        ),
                                    )
                                }
                            )
                        }
                    )
                    JobList(jobs = TestJobs)
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