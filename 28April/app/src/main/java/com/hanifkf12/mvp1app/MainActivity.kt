package com.hanifkf12.mvp1app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hanifkf12.mvp1app.view.favorite.FavoriteFragment
import com.hanifkf12.mvp1app.view.home.HomeFragment
import com.hanifkf12.mvp1app.view.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateFragment(HomeFragment())
        supportActionBar?.title = "Home"
        bottom_navigation.itemIconTintList = null

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home ->{
                    navigateFragment(HomeFragment())
                    supportActionBar?.title = "Home"
                }
                R.id.menu_fav ->{
                    navigateFragment(FavoriteFragment())
                    supportActionBar?.title = "Favorite"
                }
                R.id.menu_profile->{
                    navigateFragment(ProfileFragment())
                    supportActionBar?.title = "Profile"
                }
            }
            true
        }
    }

    private fun navigateFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }


}
