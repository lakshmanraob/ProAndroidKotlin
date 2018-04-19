package com.my.pro.mvvm.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.my.pro.models.GitRepo
import com.my.pro.models.GitRepository
import com.my.pro.models.OnRepositoryReadyCallback
import com.my.pro.util.NetworkManager

class MainViewModel : AndroidViewModel {

    constructor(application: Application) : super(application)

    var gitRepository: GitRepository = GitRepository(NetworkManager(getApplication()))
    val text = ObservableField("Old Data")
    val isLoading = ObservableField(false)

    val repositories = MutableLiveData<ArrayList<GitRepo>>()

    fun loadRepositories() {
        isLoading.set(true)
        gitRepository.getGitRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<GitRepo>) {
                isLoading.set(false)
                repositories.value = data
            }

        })
    }
}
