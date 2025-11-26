package com.example.jsonworkmanagerdemo.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.jsonworkmanagerdemo.notification.NotificationHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MyWorker(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {

    override fun doWork(): Result {

        runBlocking {
            delay(2000L)
        }

        NotificationHelper.showNotification(
            applicationContext,
            "Background Task Finished",
            "Your background task completed successfully."
        )

        return Result.success()
    }
}
