package dev.logickoder.jobfinder.jobdescription

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.R
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.paddingSecondary
import kotlinx.collections.immutable.persistentListOf

@Composable
fun JobDescriptionInfoToggle(
    modifier: Modifier = Modifier,
) {
    var selected by remember { mutableIntStateOf(R.string.job_description) }
    val titles = remember { persistentListOf(R.string.about_company, R.string.job_description) }

    Row(
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.large,
        ),
        content = {
            titles.forEach {
                ToggleItem(
                    modifier = Modifier.weight(1f),
                    title = stringResource(id = it),
                    isSelected = it == selected,
                    onClick = {
                        selected = it
                    }
                )
            }
        }
    )
}

@Composable
private fun ToggleItem(
    title: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else Color.Transparent

    Text(
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .clickable(onClick = onClick)
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.large,
            )
            .padding(vertical = paddingSecondary()),
        text = title,
        style = MaterialTheme.typography.bodySmall,
        color = contentColorFor(backgroundColor),
        fontWeight = FontWeight.W500,
        textAlign = TextAlign.Center,
    )
}

@Preview(showBackground = true)
@Composable
private fun JobDescriptionInfoTogglePreview() = JobFinderTheme {
    JobDescriptionInfoToggle()
}

