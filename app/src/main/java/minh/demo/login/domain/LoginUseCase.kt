package minh.demo.login.domain

import minh.demo.login.data.local.UserState
import minh.demo.login.data.model.User
import minh.demo.login.data.repo.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(username: String, password: String): UserState<User> {
        return when {
            username.isEmpty() -> UserState.Error(msg = "Username can't be empty")
            password.isEmpty() -> UserState.Error(msg = "Password can't be empty")
            else -> userRepository.getUserByName(username, password)
        }
    }
}
