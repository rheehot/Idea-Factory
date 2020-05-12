package kr.juyeop.ideafactory.view.activity

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.base.BaseActivity
import kr.juyeop.ideafactory.databinding.ActivityMainBinding
import kr.juyeop.ideafactory.view.fragment.ChatFragment
import kr.juyeop.ideafactory.view.fragment.HomeFragment
import kr.juyeop.ideafactory.view.fragment.SearchFragment
import kr.juyeop.ideafactory.view.fragment.ShopFragment
import kr.juyeop.ideafactory.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel
        get() = getViewModel(MainViewModel::class)

    val homeFragment = HomeFragment()
    val searchFragment = SearchFragment()
    val shopFragment = ShopFragment()
    val chatFragment = ChatFragment()

    @Override
    override fun observerViewModel() {}

    @Override
    override fun init() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss()
        selectedEvent()
    }

    fun selectedEvent(){
        bottom_navigation.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                when(item.itemId){
                    R.id.home -> {
                        fragmentTransaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss()
                        return true
                    }
                    R.id.search -> {
                        fragmentTransaction.replace(R.id.frameLayout, searchFragment).commitAllowingStateLoss()
                        return true
                    }
                    R.id.shop -> {
                        fragmentTransaction.replace(R.id.frameLayout, shopFragment).commitAllowingStateLoss()
                        return true
                    }
                    R.id.chat -> {
                        fragmentTransaction.replace(R.id.frameLayout, chatFragment).commitAllowingStateLoss()
                        return true
                    }
                }
                return false
            }
        })
    }
}
