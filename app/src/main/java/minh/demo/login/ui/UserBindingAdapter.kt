package minh.demo.login.ui

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import minh.demo.login.R
import minh.demo.login.data.local.UserState

@BindingAdapter("uiState")
fun View.uiState(userState: UserState<*>?) {
    when (userState) {
        is UserState.Registered -> Navigation.findNavController(this).popBackStack()
        is UserState.LoggedIn -> Navigation.findNavController(this).navigate(R.id.action_global_mainFragment)
        is UserState.LoggedOut -> Navigation.findNavController(this).navigate(R.id.action_global_loginFragment)
        is UserState.Error -> Toast.makeText(this.context, userState.msg, Toast.LENGTH_SHORT).show()
        else -> Log.d("TESTING", "uiState: loading")
    }
}

@BindingAdapter("adapter")
fun RecyclerView.adapter(userAdapter: UserAdapter) {
    layoutManager = LinearLayoutManager(this.context)
    adapter = userAdapter
}