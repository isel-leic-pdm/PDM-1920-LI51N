package isel.leic.i1920.pdm.li51n.workmanagerandnotifications

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        sendNotification(this.applicationContext,"Glorioso result", "Benfica 3 x Zenit 0")
        // Indicate whether the task finished successfully with the Result
        return Result.success()
    }
}