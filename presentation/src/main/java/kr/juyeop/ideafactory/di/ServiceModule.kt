package kr.juyeop.ideafactory.di

import kr.juyeop.data.network.service.DataLabService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { (get() as Retrofit).create(DataLabService::class.java) }
}