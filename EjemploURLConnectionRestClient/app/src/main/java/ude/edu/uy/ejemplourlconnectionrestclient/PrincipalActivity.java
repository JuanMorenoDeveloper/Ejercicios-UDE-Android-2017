package ude.edu.uy.ejemplourlconnectionrestclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PrincipalActivity extends AppCompatActivity implements SimpleUpdatableActivity {

    private AsyncRestClient asyncRestClient;
    private static final String TAG = "PrincipalActivity";
    private final String urlServer = "http://gturnquist-quoters.cfapps.io/api/random";
    private TextView tvId;
    private TextView tvQuote;
    private TextView tvType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initComponents();
    }

    private void initComponents() {
        tvId = (TextView) findViewById(R.id.tv_id);
        tvQuote = (TextView) findViewById(R.id.tv_quote);
        tvType = (TextView) findViewById(R.id.tv_type);
    }

    public void enviarPeticion(View v) {
        Log.i(TAG, "Enviando peticion");
        asyncRestClient = new AsyncRestClient(this);
        asyncRestClient.execute(urlServer);
    }

    @Override
    public void update(RestDataDto... results) {
        Log.i(TAG, "Actualizando componentes");
        if (null != results[0]) {
            Log.i(TAG, "Objeto recibido " + results[0]);
            tvType.setText(results[0].getType());
            tvId.setText(String.valueOf(results[0].getId()));
            tvQuote.setText(results[0].getQuote());
        }
    }
}
