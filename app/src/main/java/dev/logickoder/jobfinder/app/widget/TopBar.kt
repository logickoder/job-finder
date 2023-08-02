package dev.logickoder.jobfinder.app.widget

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.app.theme.JobFinderTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
    trailingIcon: ImageVector? = null,
    onBack: () -> Unit,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBack,
                content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                },
            )
        },
        actions = {
            if (trailingIcon != null)
                IconButton(
                    onClick = {},
                    content = {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun TopBarPreview() = JobFinderTheme {
    TopBar(
        title = "InfoSys",
        trailingIcon = Icons.Default.Bookmark,
        onBack = {},
    )
}