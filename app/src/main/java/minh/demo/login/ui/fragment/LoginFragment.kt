package minh.demo.login.ui.fragment

import androidx.fragment.app.activityViewModels
import minh.demo.login.R
import minh.demo.login.databinding.FragmentLoginBinding
import minh.demo.login.ui.base.BaseFragment
import minh.demo.login.ui.viewmodel.UserViewModel


class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val userViewModel: UserViewModel by activityViewModels()
    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun observeViewModels() {
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            viewModel = userViewModel
        }
    }
}
