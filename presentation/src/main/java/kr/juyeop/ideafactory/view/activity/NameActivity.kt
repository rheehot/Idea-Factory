package kr.juyeop.ideafactory.view.activity

import android.widget.Toast
import androidx.lifecycle.Observer
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityNameBinding
import kr.juyeop.ideafactory.viewmodel.activity.NameViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class NameActivity : BaseActivity<ActivityNameBinding, NameViewModel>() {

    override val viewModel: NameViewModel
        get() = getViewModel(NameViewModel::class)

    override fun init() {}
    override fun observerViewModel() {
        with(viewModel){
            onFailEvent.observe(this@NameActivity, Observer {
                Toast.makeText(applicationContext, "내용을 다시 한번 확인 부탁드립니다.", Toast.LENGTH_SHORT).show()
            })
            onSuccessEvent.observe(this@NameActivity, Observer {
                Toast.makeText(applicationContext, "정상적으로 서류가 제출되었습니다.", Toast.LENGTH_SHORT).show()
                startActivityWithFinish(applicationContext, MainActivity::class.java)
            })
        }
    }
}
