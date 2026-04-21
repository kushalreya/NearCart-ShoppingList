package sc.android.shoppinglistapp_room.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCartCheckout
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import sc.android.shoppinglistapp_room.navigation.Screens
import sc.android.shoppinglistapp_room.ui.theme.ShoppingListApp_RoomTheme
import sc.android.shoppinglistapp_room.ui.theme.ThemeMode
import sc.android.wishlistapp.ui.theme.GreenPrimaryContainerDark

@Composable
fun HomeScreen(
    themeMode: ThemeMode,
    isDark : Boolean,
    onThemeChange : (ThemeMode) -> Unit,
    navController: NavHostController
) {
    val snackBarHostState = remember{ SnackbarHostState() }
    val scope = rememberCoroutineScope()

    ShoppingListApp_RoomTheme (darkTheme = isDark) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                AppBar(
                    title = "Shopping List",
                    themeMode = themeMode,
                    onThemeChange = onThemeChange
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.navigate(Screens.AddEditScreen.route)
                    },
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(30.dp)
                        .size(70.dp)
                        .border(1.5.dp, GreenPrimaryContainerDark, CircleShape),
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCartCheckout,
                        contentDescription = "shopping item add",
                        modifier = Modifier.size(28.dp)
                    )
                }
            },
            snackbarHost = {SwipeableSnackBar(snackBarHostState)}
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                item{
                    Button(
                        onClick = {
                            scope.launch{
                                snackBarHostState.showSnackbar("Item has been deleted")
                            }
                        }
                    ){
                        Text(
                            "Item"
                        )
                    }
                }
            }
        }
    }

}