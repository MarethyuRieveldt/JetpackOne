package minh.demo.login.domain

import kotlinx.coroutines.flow.Flow
import minh.demo.login.data.model.User
import minh.demo.login.data.repo.UserRepository
import javax.inject.Inject

class GetAllUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): Flow<List<User>> = userRepository.getAllUsers()
}
