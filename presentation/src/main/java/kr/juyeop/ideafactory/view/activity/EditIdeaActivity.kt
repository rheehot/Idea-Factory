package kr.juyeop.ideafactory.view.activity

import android.content.Intent
import androidx.lifecycle.Observer
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityEditIdeaBinding
import kr.juyeop.ideafactory.viewmodel.activity.EditIdeaViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import kr.juyeop.ideafactory.widget.extension.toast
import org.koin.androidx.viewmodel.ext.android.getViewModel

class EditIdeaActivity : BaseActivity<ActivityEditIdeaBinding, EditIdeaViewModel>() {

    override val viewModel: EditIdeaViewModel
        get() = getViewModel(EditIdeaViewModel::class)

    override fun init() {
        viewModel.ideaDate.value = intent.getStringExtra("date")
        viewModel.getIdea()
    }
    override fun observerViewModel() {
        with(viewModel) {
            onFailEvent.observe(this@EditIdeaActivity, Observer {
                toast(R.string.toast_fail)
            })
            onCompleteEvent.observe(this@EditIdeaActivity, Observer {
                toast(R.string.toast_complete)
                startActivity(Intent(applicationContext, DetailIdeaActivity::class.java).putExtra("date", viewModel.ideaDate.value!!).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            })
            onErrorEvent.observe(this@EditIdeaActivity, Observer {
                toast(R.string.toast_error)
            })
            onBackEvent.observe(this@EditIdeaActivity, Observer {
                onBackPressed()
            })
        }
    }
}