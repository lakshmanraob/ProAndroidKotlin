package com.my.pro.models

import android.os.Handler

class GitRepoLocalDataSource {

    fun getRepositories(onRepositoryReadyCallback: OnRepoLocalReadyCallback) {
        var arrayList = ArrayList<GitRepo>()
        arrayList.add(GitRepo("First From Local", "Owner 1", 100, false))
        arrayList.add(GitRepo("Second From Local", "Owner 2", 30, true))
        arrayList.add(GitRepo("Third From Local", "Owner 3", 430, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onLocalDataReady(arrayList) }, 2000)
    }

    fun saveRepositories(arrayList: ArrayList<GitRepo>) {
        //todo save repositories in DB
    }

}

interface OnRepoLocalReadyCallback {
    fun onLocalDataReady(data: ArrayList<GitRepo>)
}