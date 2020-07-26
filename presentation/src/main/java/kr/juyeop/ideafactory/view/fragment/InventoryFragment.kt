package kr.juyeop.ideafactory.view.fragment

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_inventory.*
import kr.juyeop.ideafactory.base.BaseFragment
import kr.juyeop.ideafactory.databinding.FragmentInventoryBinding
import kr.juyeop.ideafactory.view.activity.AddIdeaActivity
import kr.juyeop.ideafactory.view.activity.EditIdeaActivity
import kr.juyeop.ideafactory.viewmodel.fragment.InventoryViewModel
import kr.juyeop.ideafactory.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.math.roundToInt

class InventoryFragment : BaseFragment<FragmentInventoryBinding, InventoryViewModel>() {

    override val viewModel: InventoryViewModel
        get() = getViewModel(InventoryViewModel::class)

    override fun init() { viewModel.getAll() }
    override fun observerViewModel() {
        with(viewModel){
            addIdeaEvent.observe(this@InventoryFragment, Observer {
                startActivityWithFinish(binding.root.context, AddIdeaActivity::class.java)
            })
            ideaAdapter.clickPosition.observe(this@InventoryFragment, Observer {
                saveIdea()
                startActivityWithFinish(binding.root.context, EditIdeaActivity::class.java)
            })
            dataLabEvent.observe(this@InventoryFragment, Observer {
                bootstrapProgressBar.progress = dataLabModel.results.get(0).data.get(0).ratio.toDouble().toInt()
                bootstrapProgressBar2.progress = dataLabModel.results.get(1).data.get(0).ratio.toDouble().toInt()
                bootstrapProgressBar3.progress = dataLabModel.results.get(2).data.get(0).ratio.toDouble().toInt()
                bootstrapProgressBar4.progress = dataLabModel.results.get(3).data.get(0).ratio.toDouble().toInt()
                setDataLab()
            })
        }
    }
}