package minh.demo.login.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import minh.demo.login.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user ORDER BY username ASC")
    fun getAllUsers(): Flow<List<User>>

    @Insert(User::class, onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    suspend fun getUsersByName(username: String): List<User>

    @Query("SELECT EXISTS (SELECT username FROM user WHERE username = :username)")
    suspend fun isExistUserByUsername(username: String): Boolean


}