package com.project.retrofit_kotlin_mvp.view

import android.provider.ContactsContract.CommonDataKinds.Nickname

interface ILoginView {

    fun OnClear()
    fun OnShowProgress()
    fun OnHideProgress()
    fun OnUpdateLoginResult(nickname: String,age:String)
}