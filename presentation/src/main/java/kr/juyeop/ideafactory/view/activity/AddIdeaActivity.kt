package kr.juyeop.ideafactory.view.activity

import androidx.lifecycle.Observer
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityAddIdeaBinding
import kr.juyeop.ideafactory.viewmodel.activity.AddIdeaViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import kr.juyeop.ideafactory.widget.extension.toast
import org.koin.androidx.viewmodel.ext.android.getViewModel

class AddIdeaActivity : BaseActivity<ActivityAddIdeaBinding, AddIdeaViewModel>() {

    override val viewModel: AddIdeaViewModel
        get() = getViewModel(AddIdeaViewModel::class)

    override fun init() {}
    override fun observerViewModel() {
        with(viewModel){
            onFailEvent.observe(this@AddIdeaActivity, Observer {
                toast(R.string.toast_fail)
            })
            onCompleteEvent.observe(this@AddIdeaActivity, Observer {
                toast(R.string.toast_complete)
                startActivityWithFinish(applicationContext, MainActivity::class.java)
            })
            onErrorEvent.observe(this@AddIdeaActivity, Observer {
                toast(R.string.toast_error)
            })
            onBackEvent.observe(this@AddIdeaActivity, Observer {
                onBackPressed()
            })
        }
    }
}