package kr.juyeop.ideafactory.view.activity

import android.content.Intent
import android.os.Handler
import kr.juyeop.data.SharedPreferencesManager
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivitySplashBinding
import kr.juyeop.ideafactory.viewmodel.SplashViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val viewModel: SplashViewModel
        get() = getViewModel(SplashViewModel::class)

    @Override
    override fun observerViewModel() {}

    @Override
    override fun init(){
        val handler = Handler()
        val runnable : Runnable

        if(SharedPreferencesManager.getFactoryName(applicationContext).isNullOrEmpty()){
            runnable = Runnable { startActivityWithFinish(Intent(this, NameActivity::class.java)) }
            handler.postDelayed(runnable, 2000)
        }else{
            runnable = Runnable { startActivityWithFinish(Intent(this, MainActivity::class.java)) }
            handler.postDelayed(runnable, 2000)
        }
    }
}
