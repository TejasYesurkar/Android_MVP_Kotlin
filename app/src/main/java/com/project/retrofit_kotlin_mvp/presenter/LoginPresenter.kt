package com.project.retrofit_kotlin_mvp.presenter

import android.util.Log
import android.widget.Toast
import com.project.retrofit_kotlin_mvp.framework.util.thread.ThreadUtil
import com.project.retrofit_kotlin_mvp.model.UserInfoModel
import com.project.retrofit_kotlin_mvp.presenter.controller.LoginController
import com.project.retrofit_kotlin_mvp.view.ILoginView

class LoginPresenter(var loginView: ILoginView) : ILoginPresenter {
    override fun clear() {
        loginView.OnClear()
    }

    override fun showProgressBar() {
        loginView.OnShowProgress()
    }

    override fun hideProgressBar() {
        loginView.OnHideProgress()
    }

    override fun login(id: String, pswd: String) {
        showProgressBar()
        LoginController.requestLogin(
            id = id,
            passwrd = pswd,
            object : LoginController.LoginControllerDelegate {
                override fun onSuccess(response: String) {
                    Log.d("Logger>>", "OnSucess $response")

                    val userInfoModel = UserInfoModel()
                    userInfoModel.nickname = id
                    userInfoModel.age = pswd

                    ThreadUtil.startUIThread(0){
                        hideProgressBar()
                    }
                    Log.d("Logger>>", "Nick name $pswd Age : $id")
                    loginView.OnUpdateLoginResult(nickname = userInfoModel.nickname,age = userInfoModel.age)
                }

                override fun onFailed() {
                    Log.d("Logger>>", "OnFailure")
                    hideProgressBar()
                }

            })
    }
}