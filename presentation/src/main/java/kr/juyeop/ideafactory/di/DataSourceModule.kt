package kr.juyeop.ideafactory.di

import kr.juyeop.data.datasource.IdeaDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { IdeaDataSource(Any(), get()) }
}
