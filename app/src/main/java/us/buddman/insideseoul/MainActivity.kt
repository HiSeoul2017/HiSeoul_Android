package us.buddman.insideseoul

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import us.buddman.insideseoul.models.User
import us.buddman.insideseoul.utils.CredentialsManager
import us.buddman.insideseoul.utils.NetworkHelper

class MainActivity : AppCompatActivity() {

    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callbackManager = CallbackManager.Factory.create()
        loginButton.setReadPermissions("email")
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                // Login with Facebook
                NetworkHelper.instance.loginByFacebook(loginResult.accessToken.token).enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        when (response.code()) {
                            200 -> {
                                resultText.text = response.body()!!.string()
                            }
                            else -> resultText.text = response.message()
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "로그인에 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
                        Log.e("asdf", t.localizedMessage)
                        resultText.text = t.localizedMessage
                    }
                })
            }

            override fun onCancel() {
                Log.e("asdf", "Canceled")

            }

            override fun onError(error: FacebookException) {
                Log.e("asdf", error.localizedMessage)

            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}
