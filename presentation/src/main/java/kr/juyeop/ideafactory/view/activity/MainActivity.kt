package kr.juyeop.ideafactory.view.activity

import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityMainBinding
import kr.juyeop.ideafactory.view.fragment.InventoryFragment
import kr.juyeop.ideafactory.view.fragment.MeetingFragment
import kr.juyeop.ideafactory.view.fragment.ProductFragment
import kr.juyeop.ideafactory.view.fragment.TradingFragment
import kr.juyeop.ideafactory.viewmodel.activity.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel
        get() = getViewModel(MainViewModel::class)

    val inventoryFragment = InventoryFragment()
    val productFragment = ProductFragment()
    val tradingFragment = TradingFragment()
    val meetingFragment = MeetingFragment()

    @Override
    override fun observerViewModel() {}

    @Override
    override fun init() {
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss()
//        selectedEvent()
    }
}
