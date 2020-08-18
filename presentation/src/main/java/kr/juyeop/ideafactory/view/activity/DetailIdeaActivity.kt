package kr.juyeop.ideafactory.view.activity

import android.app.AlertDialog
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_detail_idea.*
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityDetailIdeaBinding
import kr.juyeop.ideafactory.viewmodel.activity.DetailIdeaViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class DetailIdeaActivity : BaseActivity<ActivityDetailIdeaBinding, DetailIdeaViewModel>() {

    override val viewModel: DetailIdeaViewModel
        get() = getViewModel(DetailIdeaViewModel::class)

    override fun init() {
        setSupportActionBar(toolbar)

        viewModel.ideaDate.value = intent.getStringExtra("date")
        viewModel.getIdea()
    }

    override fun observerViewModel() {
        with(viewModel) {
            onErrorEvent.observe(this@DetailIdeaActivity, Observer {
                Toast.makeText(applicationContext, "내부 DB 처리 과정에서 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })
            onCompleteEvent.observe(this@DetailIdeaActivity, Observer {
                Toast.makeText(applicationContext, "정상적으로 아이디어를 삭제하였습니다.", Toast.LENGTH_SHORT).show()
                startActivityWithFinish(applicationContext, MainActivity::class.java)
            })
            onBackEvent.observe(this@DetailIdeaActivity, Observer {
                onBackPressed()
            })
        }
    }

    fun showDeleteDialog() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("아이디어 삭제")
        builder.setMessage("정말로 아이디어를 삭제하시겠습니까?")

        builder.setPositiveButton("삭제"){ _, _ -> viewModel.deleteIdea() }
        builder.setNegativeButton("취소"){ _, _ -> }

        builder.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_content, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.editIdea -> startActivity(Intent(applicationContext, EditIdeaActivity::class.java).putExtra("date", viewModel.ideaDate.value))
            R.id.deleteIdea -> showDeleteDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        startActivityWithFinish(applicationContext, MainActivity::class.java)
    }
}