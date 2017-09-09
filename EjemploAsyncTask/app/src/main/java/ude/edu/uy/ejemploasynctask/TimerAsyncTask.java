package ude.edu.uy.ejemploasynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class TimerAsyncTask extends AsyncTask<Integer/*doInBackground arg*/,
        Integer/*onProgressUpdate*/, Void /*doInBackground return*/> {
    private UpdatableProgress updateableProgress;
    private final static String TAG = "TimerAsyncTask";

    public TimerAsyncTask(UpdatableProgress updateableProgress) {
        this.updateableProgress = updateableProgress;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Integer... values) {
        Log.i(TAG, "Ejecutando asynctask");
        for (int i = 1; i <= 100; i++) {
            publishProgress(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        updateableProgress.update(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onCancelled() {
        updateableProgress.cancel();
    }
}
