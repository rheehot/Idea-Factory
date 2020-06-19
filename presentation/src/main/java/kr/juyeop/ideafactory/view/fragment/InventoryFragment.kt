package kr.juyeop.ideafactory.view.fragment

import kr.juyeop.ideafactory.base.BaseFragment
import kr.juyeop.ideafactory.databinding.FragmentInventoryBinding
import kr.juyeop.ideafactory.viewmodel.fragment.InventoryViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class InventoryFragment : BaseFragment<FragmentInventoryBinding, InventoryViewModel>() {

    override val viewModel: InventoryViewModel
        get() = getViewModel(InventoryViewModel::class)

    override fun init() {}
    override fun observerViewModel() {}
}