package kr.juyeop.ideafactory.di

import kr.juyeop.data.network.remote.DataLabRemote
import org.koin.dsl.module

val remoteModule = module {
    single { DataLabRemote(get()) }
}