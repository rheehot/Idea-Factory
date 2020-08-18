package kr.juyeop.ideafactory.view.fragment

import android.content.Intent
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_inventory.*
import kr.juyeop.ideafactory.base.BaseFragment
import kr.juyeop.ideafactory.databinding.FragmentInventoryBinding
import kr.juyeop.ideafactory.view.activity.AddIdeaActivity
import kr.juyeop.ideafactory.view.activity.DetailIdeaActivity
import kr.juyeop.ideafactory.viewmodel.fragment.InventoryViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithExtra
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class InventoryFragment : BaseFragment<FragmentInventoryBinding, InventoryViewModel>() {

    override val viewModel: InventoryViewModel
        get() = getViewModel(InventoryViewModel::class)

    override fun init() { viewModel.getAllIdea() }
    override fun observerViewModel() {
        with(viewModel){
            addIdeaEvent.observe(this@InventoryFragment, Observer {
                startActivityWithFinish(binding.root.context, AddIdeaActivity::class.java)
            })
            ideaAdapter.clickPosition.observe(this@InventoryFragment, Observer {
                startActivityWithExtra(Intent(activity!!.applicationContext, DetailIdeaActivity::class.java).putExtra("date", ideaAdapter.ideaList[it].date))
            })
            onSuccessEvent.observe(this@InventoryFragment, Observer {
                bootstrapProgressBar.progress = dataLabModel.results[0].data[0].ratio.toDouble().toInt()
                bootstrapProgressBar2.progress = dataLabModel.results[1].data[0].ratio.toDouble().toInt()
                bootstrapProgressBar3.progress = dataLabModel.results[2].data[0].ratio.toDouble().toInt()
                bootstrapProgressBar4.progress = dataLabModel.results[3].data[0].ratio.toDouble().toInt()
                setDataLab()
            })
        }
    }
}