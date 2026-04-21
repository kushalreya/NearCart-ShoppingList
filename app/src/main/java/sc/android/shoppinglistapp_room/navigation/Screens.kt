package sc.android.shoppinglistapp_room.navigation

sealed class Screens(val route : String) {
    object HomeScreen : Screens("homeScreen")   //home screen
    object AddEditScreen : Screens("addEditScreen")     //add-edit screen
    object LocationSelector : Screens("locationSelector")       //location selection screen
}