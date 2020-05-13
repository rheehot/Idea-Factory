package kr.juyeop.ideafactory.view.fragment

import kr.juyeop.ideafactory.base.BaseFragment
import kr.juyeop.ideafactory.databinding.FragmentHomeBinding
import kr.juyeop.ideafactory.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel
        get() = getViewModel(HomeViewModel::class)

    override fun init() {}
    override fun observerViewModel() {}
}
