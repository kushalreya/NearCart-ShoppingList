package sc.android.shoppinglistapp_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import sc.android.shoppinglistapp_room.ui.theme.ShoppingListApp_RoomTheme
import sc.android.shoppinglistapp_room.ui.theme.ThemeMode
import sc.android.shoppinglistapp_room.view.AppBarView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var themeMode by rememberSaveable {
                mutableStateOf(ThemeMode.SYSTEM)
            }

            val isDark = when (themeMode) {
                ThemeMode.LIGHT -> false
                ThemeMode.DARK -> true
                ThemeMode.SYSTEM -> isSystemInDarkTheme()
            }

            ShoppingListApp_RoomTheme (darkTheme = isDark) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppBarView(
                        modifier = Modifier.padding(innerPadding),
                        "Shopping List",
                        {},
                        themeMode = themeMode,
                        onThemeChange = { themeMode = it }
                    )
                }
            }
        }
    }
}