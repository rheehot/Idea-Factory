package kr.juyeop.ideafactory.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseFragment
import kr.juyeop.ideafactory.databinding.FragmentProductBinding
import kr.juyeop.ideafactory.viewmodel.fragment.InventoryViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ProductFragment : BaseFragment<FragmentProductBinding, ProductViewModel>() {

    override val viewModel: ProductViewModel
        get() = getViewModel(ProductViewModel::class)

    override fun init() {}
    override fun observerViewModel() {}
}