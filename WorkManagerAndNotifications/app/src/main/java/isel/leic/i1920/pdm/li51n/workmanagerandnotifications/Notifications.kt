package isel.leic.i1920.pdm.li51n.workmanagerandnotifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

val CHANNEL_ID = "Glorioso"

private var notificationId = 0

fun sendNotification(ctx: Context, title: String, text: String) {

    val intent = Intent(ctx, NotificationDetailsActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    }

    val pendingIntent = PendingIntent.getActivity(ctx, 0, intent, 0)

    var notification = NotificationCompat.Builder(ctx, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(title)
        .setContentText(text)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    val notificationManager: NotificationManager =
        ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    notificationManager.notify(notificationId++, notification)
}