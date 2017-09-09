package ude.edu.uy.ejemploasynctask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static ude.edu.uy.ejemploasynctask.MyDatabaseHelper.DB_NAME;

public class PrincipalActivity extends AppCompatActivity {

    private Button btnProgressBarActivity;
    private Button btnProgressDialogActivity;
    private static final String TAG = "PrincipalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Inicializando componentes");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Inicializando DAO, se puede usar una factory, o un framework de inyección de dependencias
        UsuarioDao.getInstance().setMyDatabaseHelper(new MyDatabaseHelper(this, DB_NAME, null, 1));
        btnProgressBarActivity = (Button) findViewById(R.id.btn_progressbar);
        btnProgressBarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProgressBar = new Intent(PrincipalActivity.this, ProgressBarActivity.class);
                startActivity(intentProgressBar);
            }
        });
        btnProgressDialogActivity = (Button) findViewById(R.id.btn_progressdialog);
        btnProgressDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, ProgressDialogActivity.class);
                startActivity(intent);
            }
        });
    }
}
