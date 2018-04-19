package com.my.pro.models

import com.my.pro.util.NetworkManager


class GitRepository(private val networkManager: NetworkManager) {

    val gitRepoLocalDataSource = GitRepoLocalDataSource()
    val gitRepoRemoteDataSource = GitRepoRemoteDataSource()

    fun getGitRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {

        networkManager.isConnectedToInternet?.let {
            if (it) {
                gitRepoRemoteDataSource.getRepositories(object : OnRepoRemoteReadyCallback {
                    override fun onLocalDataReady(data: ArrayList<GitRepo>) {
                        gitRepoLocalDataSource.saveRepositories(data)
                        onRepositoryReadyCallback.onDataReady(data)
                    }

                })
            } else {
                gitRepoLocalDataSource.getRepositories(object : OnRepoLocalReadyCallback {
                    override fun onLocalDataReady(data: ArrayList<GitRepo>) {
                        onRepositoryReadyCallback.onDataReady(data)
                    }

                })
            }
        }

    }

}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<GitRepo>)
}