package kr.juyeop.ideafactory.view.fragment

import androidx.lifecycle.Observer
import kr.juyeop.ideafactory.base.BaseFragment
import kr.juyeop.ideafactory.databinding.FragmentInventoryBinding
import kr.juyeop.ideafactory.view.activity.AddIdeaActivity
import kr.juyeop.ideafactory.view.activity.EditIdeaActivity
import kr.juyeop.ideafactory.view.activity.NameActivity
import kr.juyeop.ideafactory.viewmodel.fragment.InventoryViewModel
import kr.juyeop.ideafactory.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class InventoryFragment : BaseFragment<FragmentInventoryBinding, InventoryViewModel>() {

    override val viewModel: InventoryViewModel
        get() = getViewModel(InventoryViewModel::class)

    override fun init() { viewModel.getAll() }
    override fun observerViewModel() {
        with(viewModel){
            addIdeaEvent.observe(this@InventoryFragment, Observer {
                startActivity(binding.root.context, AddIdeaActivity::class.java)
            })
            ideaAdapter.clickPosition.observe(this@InventoryFragment, Observer {
                saveIdea()
                startActivity(binding.root.context, EditIdeaActivity::class.java)
            })
        }
    }
}