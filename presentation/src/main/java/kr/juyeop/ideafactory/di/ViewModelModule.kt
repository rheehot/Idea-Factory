package kr.juyeop.ideafactory.di

import kr.juyeop.ideafactory.viewmodel.fragment.InventoryViewModel
import kr.juyeop.ideafactory.viewmodel.activity.MainViewModel
import kr.juyeop.ideafactory.viewmodel.activity.NameViewModel
import kr.juyeop.ideafactory.viewmodel.activity.SplashViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.MeetingViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.ProductViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.TradingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { NameViewModel() }
    viewModel { MainViewModel() }

    viewModel { InventoryViewModel(get()) }
    viewModel { ProductViewModel() }
    viewModel { TradingViewModel() }
    viewModel { MeetingViewModel() }
}