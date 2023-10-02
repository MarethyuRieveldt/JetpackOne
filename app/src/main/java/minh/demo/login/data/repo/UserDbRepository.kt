package minh.demo.login.data.repo

import kotlinx.coroutines.flow.Flow
import minh.demo.login.data.local.UserDao
import minh.demo.login.data.local.UserState
import minh.demo.login.data.model.User
import javax.inject.Inject

class UserdbRepository @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override suspend fun insertUser(user: User): UserState<User> {
        return if (userDao.isExistUserByUsername(user.username)) {
            UserState.Error(msg = "Username already existed")
        } else {
            userDao.insertUser(user)
            UserState.Registered(user, "Register successful")
        }
    }
    override suspend fun getUserByName(username: String): UserState<User> {
        val user = userDao.getUsersByName(username)
        return if (user.isEmpty()) {
            UserState.Error(msg = "Wrong Username or Password")
        } else {
            UserState.LoggedIn(user[0])
        }
    }
}
