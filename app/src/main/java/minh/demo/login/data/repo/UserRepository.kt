package minh.demo.login.data.repo

import kotlinx.coroutines.flow.Flow
import minh.demo.login.data.local.UserState
import minh.demo.login.data.model.User

interface UserRepository {
    fun getAllUsers() : Flow<List<User>>
    suspend fun insertUser(user: User): UserState<User>
    suspend fun getUserByName(username: String): UserState<User>
}