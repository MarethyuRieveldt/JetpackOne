package minh.demo.login.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import minh.demo.login.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
