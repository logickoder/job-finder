package dev.logickoder.jobfinder.uploadresume

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.logickoder.jobfinder.R
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.padding
import dev.logickoder.jobfinder.app.theme.paddingSecondary
import dev.logickoder.jobfinder.app.widget.TopBar

@Composable
fun UploadResumeScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                modifier = Modifier.padding(horizontal = padding() - paddingSecondary()),
                title = stringResource(id = R.string.upload_resume),
                onBack = onBack
            )
        },
        content = { scaffoldPadding ->
            Column(
                modifier = Modifier
                    .padding(padding())
                    .padding(scaffoldPadding),
                content = {
                    Image(
                        modifier = Modifier
                            .weight(1.5f)
                            .fillMaxWidth(),
                        painter = painterResource(id = R.drawable.img_upload_resume),
                        contentDescription = stringResource(id = R.string.upload_resume),
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(modifier = Modifier.height(padding()))
                    Text(
                        text = stringResource(id = R.string.upload_resume_title),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.W500,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Spacer(modifier = Modifier.height(paddingSecondary() / 2))
                    Text(
                        text = stringResource(id = R.string.upload_resume_subtitle),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(padding()))
                    UploadResumeFileDrop(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    UploadResumeActions(
                        modifier = Modifier
                            .padding(vertical = paddingSecondary())
                            .fillMaxWidth(),
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { },
                        content = {
                            Text(
                                text = stringResource(R.string.upload_resume),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.W700,
                            )
                        }
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun UploadResumeScreenPreview() = JobFinderTheme {
    UploadResumeScreen {}
}