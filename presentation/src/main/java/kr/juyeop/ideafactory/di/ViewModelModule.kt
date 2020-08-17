package kr.juyeop.ideafactory.di

import kr.juyeop.ideafactory.view.activity.DetailIdeaActivity
import kr.juyeop.ideafactory.viewmodel.activity.*
import kr.juyeop.ideafactory.viewmodel.fragment.InventoryViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.MeetingViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.ProductViewModel
import kr.juyeop.ideafactory.viewmodel.fragment.TradingViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(androidApplication()) }
    viewModel { NameViewModel(androidApplication()) }
    viewModel { MainViewModel() }

    viewModel { InventoryViewModel(get(), get()) }
    viewModel { DetailIdeaViewModel(get(), get()) }
    viewModel { AddIdeaViewModel(get(), androidApplication()) }

    viewModel { ProductViewModel() }
    viewModel { TradingViewModel() }
    viewModel { MeetingViewModel() }
}