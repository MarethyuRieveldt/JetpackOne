package minh.demo.login.ui.fragment

import androidx.fragment.app.activityViewModels
import minh.demo.login.R
import minh.demo.login.databinding.FragmentRegisterBinding
import minh.demo.login.ui.base.BaseFragment
import minh.demo.login.ui.viewmodel.UserViewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val userViewModel: UserViewModel by activityViewModels()
    override fun getLayoutId(): Int = R.layout.fragment_register
    override fun observeViewModels() {
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            viewModel = userViewModel
        }
    }
}
