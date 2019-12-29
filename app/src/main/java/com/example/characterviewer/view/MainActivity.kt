package com.example.characterviewer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.characterviewer.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.item_character -> {
                characterTv.text="Simpson Character List"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container,  CharacterListFragment.newInstance())
                    .commit()
                return true;
            }
            R.id.item_favorite ->{
                characterTv.text="My Favorite"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.detailContainer, FavoriteFragment.newInstance())
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initToolBar()
        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun initToolBar(){
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(false)
            actionBar.setDisplayShowTitleEnabled(false)
        }
    }
}
