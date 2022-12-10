package com.project.retrofit_kotlin_mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import com.project.retrofit_kotlin_mvp.R
import com.project.retrofit_kotlin_mvp.presenter.ILoginPresenter
import com.project.retrofit_kotlin_mvp.presenter.LoginPresenter

class MainActivity : AppCompatActivity(),ILoginView {
    private lateinit var textViewLoginResult: TextView
    private lateinit var button: Button
    private lateinit var editTextID: EditText
    private lateinit var editTextPswd: EditText
    private lateinit var frameLayout: FrameLayout
    lateinit var iLoginPresenter: ILoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findView()
        initPresenter()
    }
    private fun initPresenter(){
        iLoginPresenter = LoginPresenter(this)
    }
    private fun findView(){
        textViewLoginResult= findViewById(R.id.textviewResult) as TextView
        button= findViewById(R.id.buttonLogin) as Button
        editTextID= findViewById(R.id.edittextId) as EditText
        editTextPswd= findViewById(R.id.edittextPswd) as EditText
        frameLayout= findViewById(R.id.frameLayout) as FrameLayout
        button.setOnClickListener{
            Log.d("Logger>>",editTextID.text.toString()+"--"+editTextPswd.text)
        iLoginPresenter.login(id = editTextID.text.toString().trim(), pswd = editTextPswd.text.toString().trim())
        }
    }

    override fun OnClear() {
        editTextID.setText("")
        editTextPswd.setText("")
    }

    override fun OnShowProgress() {
       frameLayout.visibility = View.VISIBLE
    }

    override fun OnHideProgress() {
        frameLayout.visibility = View.GONE
    }

    override fun OnUpdateLoginResult(nickname: String, age: String) {
       textViewLoginResult.text = "Nickname is $nickname and age is $age"
    }
}