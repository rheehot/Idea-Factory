package kr.juyeop.ideafactory.view.activity

import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kr.juyeop.data.sharedpreferences.SharedPreferencesManager
import kr.juyeop.ideafactory.R
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
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, inventoryFragment).commitAllowingStateLoss()
        selectedEvent()
        setFactoryName()
    }

    fun setFactoryName(){
        factoryName_textView.text = SharedPreferencesManager.getFactoryName(applicationContext)
    }

    fun selectedEvent(){
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                when(tab.position){
                    0-> fragmentTransaction.replace(R.id.frameLayout, inventoryFragment).commitAllowingStateLoss()
                    1-> fragmentTransaction.replace(R.id.frameLayout, productFragment).commitAllowingStateLoss()
                    2-> fragmentTransaction.replace(R.id.frameLayout, tradingFragment).commitAllowingStateLoss()
                    3-> fragmentTransaction.replace(R.id.frameLayout, meetingFragment).commitAllowingStateLoss()
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
        })
    }
}
