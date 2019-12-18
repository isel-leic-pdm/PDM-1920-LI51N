package isel.leic.i1920.pdm.li51n.workmanagerandnotifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Duration
import java.time.temporal.TemporalUnit
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //txtTitle.text. = "Glorioso Result"



        startWorkManager()
        btnNotification.setOnClickListener {
            var title = txtTitle.text.toString().trim()
            var text = txtText.text.toString().trim()
            if(text != "" && title != "") {
                sendNotification(this, title, text)

            }
        }
    }

    private fun startWorkManager() {
        val notificationWorker = PeriodicWorkRequest.Builder(NotificationWorker::class.java, Duration.ofSeconds(5))
            .build()

        WorkManager.getInstance(this).enqueue(notificationWorker)
    }
}
