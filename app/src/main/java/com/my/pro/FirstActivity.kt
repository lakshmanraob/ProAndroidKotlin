package com.my.pro

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.my.pro.databinding.ActivityFirstBinding
import com.my.pro.models.GitRepo

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    private var repo = GitRepo("Kotlin Repo", "king", 100, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first)

        binding.repository = repo
        binding.executePendingBindings()

        Handler().postDelayed({
            repo.repName = "New rep"
            repo.repOwner = "lakshman"
        }, 2000)
    }
}
