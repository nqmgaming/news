package com.nqmgaming.news_mvvm.ui.activities

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.nqmgaming.news_mvvm.R
import com.nqmgaming.news_mvvm.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityNewsBinding.inflate(layoutInflater) }
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Set up navigation
        setUpNavigation()

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        setSupportActionBar(binding.toolbar)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(binding.navMenu)
        }
        binding.navMenu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.github_repo -> {
                    startActivity(
                        Intent(
                            ACTION_VIEW, Uri.parse(
                                "https://github.com/nqmgaming"
                            )
                        )
                    )
                    true
                }

                R.id.developer -> {
                    startActivity(
                        Intent(
                            ACTION_VIEW,
                            Uri.parse(
                                "https://www.linkedin.com/in/nqmgaming/"
                            )
                        )
                    )
                    true
                }

                R.id.rate_app -> {
                    binding.drawerLayout.closeDrawers()
                    true
                }

                else -> false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

}