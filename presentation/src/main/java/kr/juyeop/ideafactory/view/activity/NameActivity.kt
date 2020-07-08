package kr.juyeop.ideafactory.view.activity

import androidx.lifecycle.Observer
import kr.juyeop.data.sharedpreferences.SharedPreferencesManager
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

    @Override
    override fun init() {}

    @Override
    override fun observerViewModel() {
        with(viewModel){
            onFailEvent.observe(this@NameActivity, Observer {
                toast(R.string.onFailEvent)
            })
            onSuccessEvent.observe(this@NameActivity, Observer {
                toast(R.string.onSuccessEvent)
                SharedPreferencesManager.setFactoryUser(this@NameActivity, viewModel.factoryUser.value.toString())
                SharedPreferencesManager.setFactoryName(this@NameActivity, viewModel.factoryName.value.toString())
                startActivityWithFinish(applicationContext, MainActivity::class.java)
            })
        }
    }
}
