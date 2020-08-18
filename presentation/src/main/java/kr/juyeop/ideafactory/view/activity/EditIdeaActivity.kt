package kr.juyeop.ideafactory.view.activity

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityEditIdeaBinding
import kr.juyeop.ideafactory.viewmodel.activity.EditIdeaViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithExtra
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
            onErrorEvent.observe(this@EditIdeaActivity, Observer {
                Toast.makeText(applicationContext, "내부 DB 처리 과정에서 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })
            onFailEvent.observe(this@EditIdeaActivity, Observer {
                Toast.makeText(applicationContext, "내용을 다시 한번 확인 부탁드립니다.", Toast.LENGTH_SHORT).show()
            })
            onCompleteEvent.observe(this@EditIdeaActivity, Observer {
                Toast.makeText(applicationContext, "정상적으로 아이디어를 수정했습니다.", Toast.LENGTH_SHORT).show()
                startActivityWithExtra(Intent(applicationContext, DetailIdeaActivity::class.java).putExtra("date", viewModel.ideaDate.value!!).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            })
            onBackEvent.observe(this@EditIdeaActivity, Observer {
                onBackPressed()
            })
        }
    }
}