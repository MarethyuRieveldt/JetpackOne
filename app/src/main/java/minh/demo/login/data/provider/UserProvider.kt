package minh.demo.login.data.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import minh.demo.login.data.model.User
import minh.demo.login.data.repo.UserRepository
import minh.demo.login.di.UserManagerApp
import javax.inject.Inject

class UserProvider : ContentProvider() {

    @Inject
    lateinit var userRepository: UserRepository
    override fun onCreate(): Boolean {
        (context as UserManagerApp).components.inject(this)
        return true
    }


    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? = runBlocking {
        var localSortOrder = sortOrder ?: ""
        var localSelection = selection ?: ""

        return@runBlocking when (uriMatcher.match(uri)) {
            1 -> {
                getCursorFromList(userRepository.getAllUsers().take(1).toList()[0])
            }
            else -> throw IllegalArgumentException("Unsupported URI: $uri")
        }
    }

    override fun getType(uri: Uri): String {
        return when (uriMatcher.match(uri)) {
            1 -> "vnd.android.cursor.dir/vnd.$AUTHORITY.user"
            else -> throw IllegalArgumentException("Unsupported URI: $uri")
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int = 0

    private fun getCursorFromList(users: List<User>): Cursor {
        val cursor = MatrixCursor(arrayOf("_ID", "fullName", "username", "password"))
        for (user in users) {
            cursor.newRow().apply {
                add("_ID", user.id)
                add("username", user.username)
                add("password", user.password)
            }
        }
        return cursor
    }

    companion object {
        private const val AUTHORITY =
            "com.fpt.ducna40.ducna40_assignment_clean_architecture.user_provider"

        val USER_URI = Uri.parse("content://$AUTHORITY/user")

        val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, "user", 1)
        }
    }

}