package kr.juyeop.ideafactory.widget

import android.app.Application
import kr.juyeop.ideafactory.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            val modules = listOf(viewModelModule, useCaseModule, repositoryImplModule, dataSourceModule, cacheModule)
            modules(modules)
        }
    }
}