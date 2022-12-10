package com.project.retrofit_kotlin_mvp.presenter

interface ILoginPresenter {
    fun clear()
    fun showProgressBar()
    fun hideProgressBar()
    fun login(id:String,pswd:String)
}