package minh.demo.login.ui.activity


import androidx.lifecycle.ViewModelProvider
import minh.demo.login.R
import minh.demo.login.databinding.ActivityMainBinding
import minh.demo.login.di.UserManagerApp
import minh.demo.login.ui.UserViewModelFactory
import minh.demo.login.ui.base.BaseActivity
import minh.demo.login.ui.viewmodel.UserViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var factory: UserViewModelFactory
    private lateinit var userViewModel: UserViewModel
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun bindView() {
        (applicationContext as UserManagerApp).components.inject(this)
        userViewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]

        binding.run {
            lifecycleOwner = this@MainActivity
            viewModel = userViewModel
        }
    }
}
