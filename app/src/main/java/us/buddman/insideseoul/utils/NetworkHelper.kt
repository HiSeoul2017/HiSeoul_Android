package us.buddman.insideseoul.utils

import android.content.Context
import android.net.ConnectivityManager

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Junseok on 2017-09-02.
 */

object NetworkHelper {
    private val url = "http://soylatte.kr:3000/"


    private var retrofit: Retrofit? = null
    val instance: NetworkAPI
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!.create(NetworkAPI::class.java)
        }

    fun returnNetworkState(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
    }
}
