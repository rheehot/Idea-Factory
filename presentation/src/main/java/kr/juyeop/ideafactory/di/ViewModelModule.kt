package kr.juyeop.ideafactory.di

import kr.juyeop.ideafactory.viewmodel.MainViewModel
import kr.juyeop.ideafactory.viewmodel.NameViewModel
import kr.juyeop.ideafactory.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { NameViewModel() }
    viewModel { MainViewModel() }
}