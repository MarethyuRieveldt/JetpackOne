package minh.demo.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import minh.demo.login.domain.GetAllUseCase
import minh.demo.login.domain.LoginUseCase
import minh.demo.login.domain.RegisterUseCase
import minh.demo.login.ui.viewmodel.UserViewModel
import javax.inject.Inject

class UserViewModelFactory @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val loginUseCase: LoginUseCase,
    private val getAllUseCase: GetAllUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(loginUseCase, registerUseCase, getAllUseCase) as T
    }
}
