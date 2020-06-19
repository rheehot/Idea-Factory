package kr.juyeop.ideafactory.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseFragment
import kr.juyeop.ideafactory.databinding.FragmentTradingBinding
import kr.juyeop.ideafactory.viewmodel.fragment.ProductViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.TradingViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class TradingFragment : BaseFragment<FragmentTradingBinding, TradingViewModel>() {

    override val viewModel: TradingViewModel
        get() = getViewModel(TradingViewModel::class)

    override fun init() {}
    override fun observerViewModel() {}
}