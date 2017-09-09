package ude.edu.uy.ejemplosharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PrincipalActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private final static String PUNTAJE = "PUNTAJE";
    private Button btnGenerarPuntaje;
    private TextView tvPuntaje;
    private TextView tvPuntajeMaximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getPreferences(MODE_PRIVATE);
        setContentView(R.layout.activity_principal);
        tvPuntaje = (TextView) findViewById(R.id.tv_puntaje);
        tvPuntajeMaximo = (TextView) findViewById(R.id.tv_puntaje_max);
        btnGenerarPuntaje = (Button) findViewById(R.id.btn_puntaje);
        tvPuntajeMaximo.setText(String.valueOf(sharedPreferences.getInt(PUNTAJE, 0)));
        btnGenerarPuntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int val = random.nextInt(1000);
                int valMax = sharedPreferences.getInt(PUNTAJE, 0);
                tvPuntaje.setText(String.valueOf(val));
                if (val > valMax) {
                    tvPuntajeMaximo.setText(String.valueOf(val));
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(PUNTAJE, val);
                    editor.commit();
                }
            }
        });
    }
}
