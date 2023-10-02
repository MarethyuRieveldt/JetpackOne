package minh.demo.login.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import minh.demo.login.data.local.UserState
import minh.demo.login.data.model.User
import minh.demo.login.domain.GetAllUseCase
import minh.demo.login.domain.LoginUseCase
import minh.demo.login.domain.RegisterUseCase
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
    private val getAllUseCase: GetAllUseCase
): ViewModel() {

    private val _users = MutableStateFlow<List<User>>(listOf())
    val user = _users.asStateFlow()

    private var _userState = MutableStateFlow<UserState<User>?>(null)
    val userState= _userState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllUseCase().collect(){
                _users.value
            }
        }
    }

    fun register(username: String, password: String) {

    }

}