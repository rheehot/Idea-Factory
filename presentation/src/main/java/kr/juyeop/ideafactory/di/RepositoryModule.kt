package kr.juyeop.ideafactory.di

import kr.juyeop.data.database.cache.IdeaCache
import kr.juyeop.data.datasource.IdeaDataSource
import kr.juyeop.data.repository.IdeaRepositoryImpl
import kr.juyeop.domain.repository.IdeaRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val repositoryModule = module {
    single { IdeaCache(androidApplication()) }
    single { IdeaDataSource(get()) }
    single<IdeaRepository> { IdeaRepositoryImpl(get()) }
}