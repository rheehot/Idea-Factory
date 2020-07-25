package kr.juyeop.ideafactory.di

import kr.juyeop.ideafactory.viewmodel.activity.AddIdeaViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.InventoryViewModel
import kr.juyeop.ideafactory.viewmodel.activity.MainViewModel
import kr.juyeop.ideafactory.viewmodel.activity.NameViewModel
import kr.juyeop.ideafactory.viewmodel.activity.SplashViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.MeetingViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.ProductViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.TradingViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { NameViewModel(androidApplication()) }
    viewModel { MainViewModel() }

    viewModel { InventoryViewModel(get(), get()) }
    viewModel { AddIdeaViewModel(get(), androidApplication()) }

    viewModel { ProductViewModel() }
    viewModel { TradingViewModel() }
    viewModel { MeetingViewModel() }
}