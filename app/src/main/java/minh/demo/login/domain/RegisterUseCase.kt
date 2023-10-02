package minh.demo.login.domain

import minh.demo.login.data.local.UserState
import minh.demo.login.data.model.User
import minh.demo.login.data.repo.UserRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(
        fullName: String,
        username: String,
        password: String,
        confirmPassword: String
    ): UserState<User> {
        return when {
            fullName.isEmpty() -> UserState.Error(msg = "Full name can't be empty")
            username.isEmpty() -> UserState.Error(msg = "Username can't be empty")
            password.isEmpty() -> UserState.Error(msg = "Password can't be empty")
            confirmPassword != password -> UserState.Error(msg = "Password is not match")
            else -> userRepository.insertUser(User(username = username, password = password))
        }
    }
}
