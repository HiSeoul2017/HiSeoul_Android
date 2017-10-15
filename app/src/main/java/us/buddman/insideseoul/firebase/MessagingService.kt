package us.buddman.insideseoul.firebase

import android.util.Log

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by Junseok Oh on 2017-07-17.
 */

class MessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.e("asdf", remoteMessage!!.data["Title"])
    }
}
