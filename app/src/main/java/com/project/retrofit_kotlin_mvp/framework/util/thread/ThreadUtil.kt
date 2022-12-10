package com.project.retrofit_kotlin_mvp.framework.util.thread

import android.os.Looper
import java.util.concurrent.Executors
import java.util.logging.Handler


class ThreadUtil {
    companion object{
        private val excutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        private val handler = android.os.Handler(Looper.getMainLooper())

        fun startThread(runnable: Runnable){
            excutorService.submit(runnable)
        }
        fun startUIThread(delaMillis:Int,runnable:Runnable){
            handler.postDelayed(runnable,delaMillis.toLong())
        }

        protected fun finalize(){
            if(!excutorService.isShutdown){
                excutorService.shutdown()
            }
        }
    }
}