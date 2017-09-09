package ude.edu.uy.ejemploasynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity implements UpdatableProgress {

    private Button btnActivityPrincipal;
    private Button btnStartAsyncTask;
    private Button btnStopAsyncTask;
    private ProgressBar pgbProgress;
    private static final String TAG = "ProgressBarActivity";
    private TimerAsyncTask progressBarAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Inicializando componentes");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        btnActivityPrincipal = (Button) findViewById(R.id.btn_principal);
        btnStartAsyncTask = (Button) findViewById(R.id.btn_start);
        btnStopAsyncTask = (Button) findViewById(R.id.btn_stop);
        pgbProgress = (ProgressBar) findViewById(R.id.pgb_progress);
        pgbProgress.setMax(100);
        btnStartAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarAsyncTask = new TimerAsyncTask(ProgressBarActivity.this);
                progressBarAsyncTask.execute();
            }
        });
        btnStopAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarAsyncTask.cancel(false);
            }
        });

        btnActivityPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void update(int count) {
        Log.i(TAG, "Progreso asynctask: " + count);
        pgbProgress.setProgress(count);
    }

    @Override
    public void cancel() {
        Toast.makeText(this,"Tarea cancelada",Toast.LENGTH_SHORT).show();
    }
}
