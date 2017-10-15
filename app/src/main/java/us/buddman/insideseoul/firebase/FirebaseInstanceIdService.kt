package us.buddman.insideseoul.firebase

import com.google.firebase.iid.FirebaseInstanceId

import us.buddman.insideseoul.utils.CredentialsManager


/**
 * Created by Junseok Oh on 2017-07-17.
 */

class FirebaseInstanceIdService : com.google.firebase.iid.FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        val refreshedToken = FirebaseInstanceId.getInstance().token
        if (CredentialsManager.instance.activeUser.first) {
            //            NetworkHelper.getInstance().updateFirebaseToken(
            //                    CredentialsManager.getInstance().getActiveUser().second.getToken(),
            //                    refreshedToken
            //            ).enqueue(new Callback<ResponseBody>() {
            //                @Override
            //                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            //                    switch (response.code()) {
            //                        case 200:
            //                            Log.e("asdf", "firebase token updated");
            //                            break;
            //                        case 403:
            //                            Log.e("asdf", "Update Error");
            //                            break;
            //                    }
            //                }
            //
            //                @Override
            //                public void onFailure(Call<ResponseBody> call, Throwable t) {
            //                    Log.e("asdf", t.getLocalizedMessage());
            //                }
            //            });
        }
    }
}
