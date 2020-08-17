package kr.juyeop.ideafactory.view.activity

import android.app.AlertDialog
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_detail_idea.*
import kotlinx.android.synthetic.main.activity_main.*
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityDetailIdeaBinding
import kr.juyeop.ideafactory.viewmodel.activity.DetailIdeaViewModel
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
            onBackEvent.observe(this@DetailIdeaActivity, Observer {
                onBackPressed()
            })
        }
    }

    fun showDeleteDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("아이디어 삭제")
        alertDialog.setMessage("아이디어를 정말 삭제하시겠습니까?")

        alertDialog.setPositiveButton("삭제") { dialog, which ->
            Log.e("test", "삭제 버튼 클릭")
        }

        alertDialog.setNegativeButton("취소") { dialog, which ->
            Log.e("test", "취소 버튼 클릭")
        }

        alertDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_content, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.deleteIdea -> showDeleteDialog()
        }
        return super.onOptionsItemSelected(item)
    }
}