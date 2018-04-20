package com.my.pro.mvvm.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.my.pro.models.GitRepo
import com.my.pro.models.GitRepository
import com.my.pro.util.NetworkManager
import com.my.pro.util.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gitRepository: GitRepository = GitRepository(NetworkManager(getApplication()))
    val text = ObservableField("Old Data")
    val isLoading = ObservableField(false)

    val repositories = MutableLiveData<ArrayList<GitRepo>>()

    var compositeDisposable = CompositeDisposable()

    fun loadRepositories() {

        isLoading.set(true)
        compositeDisposable += gitRepository
                .getGitRepositories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ArrayList<GitRepo>>() {
                    override fun onComplete() {
                        isLoading.set(false)
                    }

                    override fun onNext(t: ArrayList<GitRepo>) {
                        repositories.value = t
                    }

                    override fun onError(e: Throwable) {

                    }

                })
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }

    }
}
