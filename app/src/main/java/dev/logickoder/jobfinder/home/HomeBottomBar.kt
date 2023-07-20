package dev.logickoder.jobfinder.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.logickoder.jobfinder.app.theme.JobFinderTheme
import dev.logickoder.jobfinder.app.theme.paddingSmall

val BottomBarItems = arrayOf(
    Icons.Outlined.Home,
    Icons.Outlined.BookmarkBorder,
    Icons.Outlined.Message,
    Icons.Outlined.Person,
)

@Composable
fun HomeBottomBar(
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    onItemSelected: (Int) -> Unit,
) {
    BottomAppBar(
        modifier = modifier,
        tonalElevation = 0.dp,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    BottomBarItems.forEachIndexed { index, item ->
                        BottomBarItem(
                            icon = item,
                            isSelected = selectedIndex == index,
                            onClick = {
                                onItemSelected(index)
                            }
                        )
                    }
                }
            )
        }
    )
}

@Composable
private fun BottomBarItem(
    icon: ImageVector,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        shape = RectangleShape,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Divider(
                        modifier = Modifier.width(40.dp),
                        thickness = 4.dp,
                        color = if (isSelected) {
                            MaterialTheme.colorScheme.primary
                        } else MaterialTheme.colorScheme.background,
                    )
                    Spacer(
                        modifier = Modifier.height(paddingSmall())
                    )
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (isSelected) {
                            MaterialTheme.colorScheme.primary
                        } else MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeBottomBarPreview() = JobFinderTheme {
    var selectedIndex by remember { mutableIntStateOf(0) }

    HomeBottomBar(
        selectedIndex = selectedIndex,
        onItemSelected = {
            selectedIndex = it
        }
    )
}