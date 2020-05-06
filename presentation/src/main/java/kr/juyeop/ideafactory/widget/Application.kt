package kr.juyeop.ideafactory.widget

import android.app.Application
import kr.juyeop.ideafactory.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            val modules = listOf(viewModelModule)
            modules(modules)
        }
    }
}