package ude.edu.uy.ejemplourlconnectionrestclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class AsyncRestClient extends AsyncTask<String, Void, RestDataDto> {
    private SimpleUpdatableActivity simpleUpdatableActivity;
    private static final String TAG = "AsyncRestClient";

    public AsyncRestClient(SimpleUpdatableActivity simpleUpdatableActivity) {
        this.simpleUpdatableActivity = simpleUpdatableActivity;
    }

    @Override
    protected RestDataDto doInBackground(String... params) {
        Log.i(TAG, "Iniciando llamada al servidor");
        HttpUrlConnectionClient httpUrlConnectionClient = new HttpUrlConnectionClient();
        //return httpUrlConnectionClient.sendGet(params[0]);
        return httpUrlConnectionClient.sendGetOkHttp(params[0]);
    }

    @Override
    protected void onPostExecute(RestDataDto result) {
        if (null != result) {
            simpleUpdatableActivity.update(result);
        }
    }
}
