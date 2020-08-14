package kr.juyeop.ideafactory.view.activity

import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityDetailIdeaBinding
import kr.juyeop.ideafactory.viewmodel.activity.DetailIdeaViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class DetailIdeaActivity : BaseActivity<ActivityDetailIdeaBinding, DetailIdeaViewModel>() {

    override val viewModel: DetailIdeaViewModel
        get() = getViewModel(DetailIdeaViewModel::class)

    override fun init() {}
    override fun observerViewModel() {}
}