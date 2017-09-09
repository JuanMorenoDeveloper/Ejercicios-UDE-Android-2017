package ude.edu.uy.ejemploasynctask;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;
import java.util.Random;

public class BdAsyncTask extends AsyncTask<Integer/*doInBackground arg*/,
        Integer/*onProgressUpdate*/, Void /*doInBackground return*/> {
    private UpdatableProgress updateableProgress;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private final static String TAG = "BdAsyncTask";
    private final static int MAX_LENGTH = 5;
    private UsuarioDao usuarioDao = UsuarioDao.getInstance();

    public BdAsyncTask(UpdatableProgress updateableProgress) {
        this.updateableProgress = updateableProgress;
    }

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        //mostrar.show
    }

    @Override
    protected Void doInBackground(Integer... values) {
        int max = values[0];
        Log.i(TAG, "Insertando registros en base de datos");
        int i=0;
        for (i = 0; i < max&&!isCancelled(); i++) {
            Usuario usuario = new Usuario(random());
            usuarioDao.insertUser(usuario);
            publishProgress(i);
        }
        Log.i(TAG, "Total insertados "+i);
        return null;
    }

    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(MAX_LENGTH);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);//Caracteres imprimibles
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        updateableProgress.update(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        List<Usuario> usuarios = usuarioDao.findAllUsers();
        Log.i(TAG, "El total de datos en la tabla son: " + usuarios.size());
        //for (Usuario usuario : usuarios) {
        //    Log.i(TAG, "El total de datos en la tabla son: " + usuario);
        //}
    }
    @Override
    protected void onCancelled(){
        Log.i(TAG, "Tarea cancelada");
    }
}
