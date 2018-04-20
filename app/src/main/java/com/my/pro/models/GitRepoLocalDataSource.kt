package com.my.pro.models

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GitRepoLocalDataSource {

    fun getRepositories(): Observable<ArrayList<GitRepo>> {
        var arrayList = ArrayList<GitRepo>()
        arrayList.add(GitRepo("First From Local", "Owner 1", 100, false))
        arrayList.add(GitRepo("Second From Local", "Owner 2", 30, true))
        arrayList.add(GitRepo("Third From Local", "Owner 3", 430, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(arrayList: ArrayList<GitRepo>) {
        //todo save repositories in DB
    }

}
