package minh.demo.jetpackcomposerecipe

sealed class Screen(val route: String){
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
    object LoginScreen : Screen("login_screen")
    object SplashScreen : Screen("splash_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$args")
            }
        }
    }

}
