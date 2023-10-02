package minh.demo.login.data.local

sealed class UserState<out T>(
    val data: T? = null,
    val msg: String? = null
) {

    class Registered<out T>(data: T, msg: String? = null) : UserState<T>(data = data, msg = msg)
    class LoggedIn<out T>(data: T, msg: String? = null) : UserState<T>(data = data, msg = msg)
    class Error<out T>(data: T? = null, msg: String) : UserState<T>(data = data, msg = msg)
    class LoggedOut<T>() : UserState<T>()
    class Loading<T>() : UserState<T>()

}
