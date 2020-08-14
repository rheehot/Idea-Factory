package kr.juyeop.ideafactory.view.activity

import androidx.lifecycle.Observer
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityNameBinding
import kr.juyeop.ideafactory.viewmodel.activity.NameViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import kr.juyeop.ideafactory.widget.extension.toast
import org.koin.androidx.viewmodel.ext.android.getViewModel

class NameActivity : BaseActivity<ActivityNameBinding, NameViewModel>() {

    override val viewModel: NameViewModel
        get() = getViewModel(NameViewModel::class)

    override fun init() {}
    override fun observerViewModel() {
        with(viewModel){
            onFailEvent.observe(this@NameActivity, Observer {
                toast(R.string.toast_fail)
            })
            onSuccessEvent.observe(this@NameActivity, Observer {
                toast(R.string.toast_success)
                startActivityWithFinish(applicationContext, MainActivity::class.java)
            })
        }
    }
}
