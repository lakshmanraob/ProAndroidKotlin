package com.my.pro.models

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.my.pro.BR

class GitRepo(repName: String, repOwner: String?, var numOfStats: Int?
              , var hasIssues: Boolean = false) : BaseObservable() {

    @get:Bindable
    var repName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.repName)
        }

    @get:Bindable
    var repOwner: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.repOwner)
    }

}