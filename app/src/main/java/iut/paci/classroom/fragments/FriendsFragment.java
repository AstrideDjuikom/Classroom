package iut.paci.classroom.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import iut.paci.classroom.R;

public class FriendsFragment extends Fragment {
    //déclaration des variables
    public static final String TAG = FriendsFragment.class.getSimpleName();
    private ProgressDialog pDialog;
    private String urlString = "http://localhost/getFriends.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_amis, container, false);
    }


    public static boolean checkConnection(Context ctx) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected() ||
                (networkInfo.getType() != ConnectivityManager.TYPE_WIFI &&
                        networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
// No internet connection
            return false;
        } else
            return true;
    }


    public void getFriends() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Getting list of friends...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();


        Ion.with(this)
                .load(urlString)
                .asString()
                .withResponse()
                .setCallback(new FutureCallback<Response<String>>() {
                    @Override
                    public void onCompleted(Exception e, Response<String> response) {
                        pDialog.dismiss();
                        if (response == null)
                            Log.d(TAG, "No response from the server!!!");

                        else {
                            // Traitement de result       ...
                            if (response != null) {
                                Log.d(TAG, "Http code: " + response.getHeaders().code());
                                Log.d(TAG, "Result: " + response.getResult());
                            }

                        }
                    }
                });


    }


}
