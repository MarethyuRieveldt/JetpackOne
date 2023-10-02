package minh.demo.login.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "username")
    var username: String = "",

    @ColumnInfo(name = "password")
    var password: String = ""
)
