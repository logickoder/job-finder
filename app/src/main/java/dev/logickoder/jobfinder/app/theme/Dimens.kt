package dev.logickoder.jobfinder.app.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import dev.logickoder.jobfinder.R

@ReadOnlyComposable
@Composable
fun padding() = dimensionResource(id = R.dimen.padding)

@ReadOnlyComposable
@Composable
fun paddingSmall() = dimensionResource(id = R.dimen.padding_small)