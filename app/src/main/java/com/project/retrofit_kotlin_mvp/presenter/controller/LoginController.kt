package com.project.retrofit_kotlin_mvp.presenter.controller

import com.project.retrofit_kotlin_mvp.framework.util.thread.ThreadUtil

object LoginController {
    interface LoginControllerDelegate{
        fun onSuccess(response:String)
        fun onFailed()
    }

    fun requestLogin(id:String,passwrd:String,delegate: LoginControllerDelegate){
        ThreadUtil.startThread{
            Thread.sleep(3000)
            delegate.onSuccess("response from server, user info is jsonObject,you need parsing it")
        }
    }
}