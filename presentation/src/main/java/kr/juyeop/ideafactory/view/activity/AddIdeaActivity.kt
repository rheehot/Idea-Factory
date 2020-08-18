package kr.juyeop.ideafactory.view.activity

import android.widget.Toast
import androidx.lifecycle.Observer
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityAddIdeaBinding
import kr.juyeop.ideafactory.viewmodel.activity.AddIdeaViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class AddIdeaActivity : BaseActivity<ActivityAddIdeaBinding, AddIdeaViewModel>() {

    override val viewModel: AddIdeaViewModel
        get() = getViewModel(AddIdeaViewModel::class)

    override fun init() {}
    override fun observerViewModel() {
        with(viewModel){
            onFailEvent.observe(this@AddIdeaActivity, Observer {
                Toast.makeText(applicationContext, "내용을 다시 한번 확인 부탁드립니다.", Toast.LENGTH_SHORT).show()
            })
            onCompleteEvent.observe(this@AddIdeaActivity, Observer {
                Toast.makeText(applicationContext, "정상적으로 아이디어를 추가하였습니다.", Toast.LENGTH_SHORT).show()
                startActivityWithFinish(applicationContext, MainActivity::class.java)
            })
            onErrorEvent.observe(this@AddIdeaActivity, Observer {
                Toast.makeText(applicationContext, "내부 DB 처리 과정에서 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })
            onBackEvent.observe(this@AddIdeaActivity, Observer {
                onBackPressed()
            })
        }
    }
}