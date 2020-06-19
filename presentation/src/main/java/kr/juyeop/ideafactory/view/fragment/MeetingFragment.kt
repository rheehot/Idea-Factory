package kr.juyeop.ideafactory.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseFragment
import kr.juyeop.ideafactory.databinding.FragmentMeetingBinding
import kr.juyeop.ideafactory.viewmodel.fragment.MeetingViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.TradingViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MeetingFragment : BaseFragment<FragmentMeetingBinding, MeetingViewModel>() {

    override val viewModel: MeetingViewModel
        get() = getViewModel(MeetingViewModel::class)

    override fun init() {}
    override fun observerViewModel() {}
}