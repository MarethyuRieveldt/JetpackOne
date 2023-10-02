package minh.demo.login.data.local

sealed class UserState<T>(
    val data: T? = null,
    val msg: String? = null
) {

    class Registered<T>(data: T, msg: String? = null) : UserState<T>(data = data, msg = msg)
    class LoggedIn<T>(data: T, msg: String? = null) : UserState<T>(data = data, msg = msg)
    class Error<T>(data: T? = null, msg: String) : UserState<T>(data = data, msg = msg)
    class LoggedOut<T>() : UserState<T>()
    class Loading<T>() : UserState<T>()

}
