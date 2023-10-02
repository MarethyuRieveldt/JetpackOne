package minh.demo.login.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import minh.demo.login.R

abstract class BaseActivity<VB : ViewBinding>(
) : AppCompatActivity() {

    lateinit var binding: VB
    lateinit var navController: NavController

    protected abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        navController = (supportFragmentManager.findFragmentById(R.id.fcv_activity_main_container) as NavHostFragment).navController
        bindView()
    }

    open fun bindView() {}

}
