package us.buddman.insideseoul.utils

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import us.buddman.insideseoul.models.User

/**
 * Created by Junseok Oh on 2017-07-18.
 */

interface NetworkAPI {

    @GET("/facebook/app")
    fun loginByFacebook(@Query("access_token") token : String) : Call<ResponseBody>
}