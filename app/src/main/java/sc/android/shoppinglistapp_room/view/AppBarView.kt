@file:OptIn(ExperimentalMaterial3Api::class)

package sc.android.shoppinglistapp_room.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sc.android.shoppinglistapp_room.ui.theme.ThemeMode
import sc.android.shoppinglistapp_room.ui.theme.ThemeSelectorDropdown

@Composable
fun AppBarView (
    modifier: Modifier,
    title : String,
    onBackNavClicked : () -> Unit = {},
    themeMode: ThemeMode,
    onThemeChange: (ThemeMode) -> Unit,
) {
    val actionIcons : @Composable (RowScope.() -> Unit) = {
        if (title.contains("Shopping List")){
            Row(
                modifier = Modifier
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "location",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(28.dp)
                    )
                }

                ThemeSelectorDropdown(
                    current = themeMode,
                    onChange = onThemeChange
                )
            }
        }
    }

    val navigationIcon : (@Composable () -> Unit) = {
        if (!title.contains("Shopping List")){
            IconButton(
                onClick = { onBackNavClicked() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 4.dp),
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(30.dp),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 30.sp
            )
        },
        windowInsets = WindowInsets(top = 35.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        navigationIcon = navigationIcon,
        actions = actionIcons
    )

}