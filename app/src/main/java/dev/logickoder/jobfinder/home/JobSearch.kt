package dev.logickoder.jobfinder.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.R
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.paddingSmall

@Composable
fun JobSearch(
    modifier: Modifier = Modifier,
) {
    Layout(
        modifier = modifier,
        content = {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.img_job_search),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Button(
                onClick = {},
                content = {
                    Row(
                        content = {
                            Icon(
                                modifier = Modifier.padding(end = paddingSmall() / 3),
                                imageVector = Icons.Filled.Search,
                                contentDescription = null,
                            )
                            Text(
                                text = stringResource(id = R.string.home_job_search_title),
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.W600,
                                color = MaterialTheme.colorScheme.onPrimary,
                            )
                        }
                    )
                },
            )
        },
        measurePolicy = { measurables, constraints ->
            // Don't constrain child views further, measure them with given constraints
            // Measure each child
            val image = measurables[0].measure(constraints)
            val button = measurables[1].measure(constraints)
            // Set the size of the layout as big as it can
            layout(image.width, image.height + button.height / 2) {
                // place the image first on the screen
                image.placeRelative(0, 0)
                // place the button over the bottom center of the image
                button.placeRelative(
                    x = (image.width / 2) - (button.width / 2),
                    y = image.height - button.height / 2,
                )
            }
        },
    )
}


@Preview(showBackground = true)
@Composable
private fun JobSearchPreview() = JobFinderTheme {
    JobSearch()
}