package com.my.pro.models

import com.my.pro.util.NetworkManager
import io.reactivex.Observable


class GitRepository(private val networkManager: NetworkManager) {

    val gitRepoLocalDataSource = GitRepoLocalDataSource()
    val gitRepoRemoteDataSource = GitRepoRemoteDataSource()

    fun getGitRepositories(): Observable<ArrayList<GitRepo>> {
        networkManager.isConnectedToInternet?.let {
            if (it) {
                return gitRepoRemoteDataSource.getRepositories()
            }
        }
        return gitRepoLocalDataSource.getRepositories()
    }

}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<GitRepo>)
}