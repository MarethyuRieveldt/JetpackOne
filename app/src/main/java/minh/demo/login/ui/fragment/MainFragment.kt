package minh.demo.login.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import minh.demo.login.R
import minh.demo.login.databinding.FragmentMainBinding
import minh.demo.login.ui.UserAdapter
import minh.demo.login.ui.base.BaseFragment
import minh.demo.login.ui.viewmodel.UserViewModel

class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val userViewModel: UserViewModel by activityViewModels()
    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun bindView() {
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            viewModel = userViewModel
            adapter = UserAdapter(userViewModel.user.value)
        }
    }
}
