package kr.juyeop.ideafactory.di

import kr.juyeop.data.database.cache.IdeaCache
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cacheModule = module {
    single { IdeaCache(androidApplication()) }
}