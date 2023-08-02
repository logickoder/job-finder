package dev.logickoder.jobfinder.uploadresume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BrowseGallery
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.padding

@Composable
fun UploadResumeActions(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            padding(),
            Alignment.CenterHorizontally,
        ),
        verticalAlignment = Alignment.CenterVertically,
        content = {
            UploadResumeAction(
                icon = Icons.Outlined.CameraAlt,
            )
            UploadResumeAction(
                icon = Icons.Outlined.BrowseGallery,
            )
        }
    )
}

@Composable
private fun UploadResumeAction(
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    IconButton(
        modifier = modifier
            .clip(CircleShape)
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        onClick = {},
        content = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun UploadResumeActionsPreview() = JobFinderTheme {
    UploadResumeActions()
}