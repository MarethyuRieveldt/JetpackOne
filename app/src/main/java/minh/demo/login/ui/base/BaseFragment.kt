package minh.demo.login.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding
import minh.demo.login.ui.activity.MainActivity

abstract class BaseFragment<VB : ViewBinding>(
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    protected abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        observeViewModels()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView()
    }

    open fun observeViewModels() {}

    open fun bindView() {}

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
