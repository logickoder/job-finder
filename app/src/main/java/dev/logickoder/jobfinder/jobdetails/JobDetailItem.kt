package dev.logickoder.jobfinder.jobdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.paddingSecondary
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

@Composable
fun JobDetailItem(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier,
        content = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.W500,
            )
            CompositionLocalProvider(
                value = LocalTextStyle provides MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface,
                ),
                content = content,
            )
        }
    )
}

@Composable
fun JobDetailBulletText(
    texts: ImmutableList<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(paddingSecondary()),
        content = {
            texts.forEach { text ->
                Row(
                    content = {
                        Text("\u2022\t\t")
                        Text(text)
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun JobDetailItemPreview() = JobFinderTheme {
    JobDetailItem(title = "About Us") {
        Text(text = "Hello World!! ".repeat(10))
    }
}

@Preview(showBackground = true)
@Composable
private fun JobDetailBulletTextPreview() = JobFinderTheme {
    JobDetailBulletText(
        texts = (1..10).map {
            "We are looking for a C# developer to build software using languages, technologies of the .NET framework."
        }.toPersistentList(),
    )
}