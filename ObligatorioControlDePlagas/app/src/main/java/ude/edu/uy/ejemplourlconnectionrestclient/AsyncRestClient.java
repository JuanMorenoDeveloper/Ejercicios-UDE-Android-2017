package ude.edu.uy.ejemplourlconnectionrestclient;

import android.os.AsyncTask;
import android.util.Log;

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
        return httpUrlConnectionClient.sendGet(params[0]);
    }

    @Override
    protected void onPostExecute(RestDataDto result) {
        if (null != result) {
            simpleUpdatableActivity.update(result);
        }
    }
}
