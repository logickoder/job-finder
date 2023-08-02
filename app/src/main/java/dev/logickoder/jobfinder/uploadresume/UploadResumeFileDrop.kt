package dev.logickoder.jobfinder.uploadresume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CloudUpload
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.paddingSecondary

@Composable
fun UploadResumeFileDrop(
    modifier: Modifier = Modifier,
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Row(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.extraLarge
            )
            .drawBehind {
                drawIntoCanvas { canvas ->
                    val dashLength = 10.dp.toPx()
                    val radius = 30.dp.toPx()

                    canvas.drawRoundRect(
                        0f,
                        0f,
                        size.width,
                        size.height,
                        radius,
                        radius,
                        paint = Paint().apply {
                            strokeWidth = 3.dp.toPx()
                            color = primaryColor
                            style = PaintingStyle.Stroke
                            pathEffect = PathEffect.dashPathEffect(
                                floatArrayOf(dashLength, dashLength),
                                0f
                            )
                        }
                    )
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        content = {
            Icon(
                imageVector = Icons.Outlined.CloudUpload,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.width(paddingSecondary() / 2))
            Text(
                text = "Drop a file",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.W500,
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun UploadResumeFileDropPreview() = JobFinderTheme {
    UploadResumeFileDrop(
        modifier = Modifier.size(300.dp, 100.dp),
    )
}
