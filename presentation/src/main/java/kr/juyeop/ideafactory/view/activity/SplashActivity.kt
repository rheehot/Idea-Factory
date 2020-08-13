package kr.juyeop.ideafactory.view.activity

import android.os.Handler
import androidx.lifecycle.Observer
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivitySplashBinding
import kr.juyeop.ideafactory.viewmodel.activity.SplashViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val viewModel: SplashViewModel
        get() = getViewModel(SplashViewModel::class)

    override fun init(){ viewModel.checkData() }
    override fun observerViewModel() {
        val handler = Handler()
        var runnable : Runnable

        with(viewModel){
            onFailEvent.observe(this@SplashActivity, Observer {
                runnable = Runnable { startActivityWithFinish(applicationContext, NameActivity::class.java) }
                handler.postDelayed(runnable, 2000)
            })
            onSuccessEvent.observe(this@SplashActivity, Observer {
                runnable = Runnable { startActivityWithFinish(applicationContext, MainActivity::class.java) }
                handler.postDelayed(runnable, 2000)
            })
        }
    }
}
