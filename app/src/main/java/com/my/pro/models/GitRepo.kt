package com.my.pro.models

data class GitRepo(var repName: String, var repOwner: String? = "", var numOfStats: Int?
                   , var hasIssues: Boolean = false)