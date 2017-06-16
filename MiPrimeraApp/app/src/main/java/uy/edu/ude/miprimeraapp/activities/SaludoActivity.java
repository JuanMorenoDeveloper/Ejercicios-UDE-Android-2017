package uy.edu.ude.miprimeraapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uy.edu.ude.miprimeraapp.R;

public class SaludoActivity extends AppCompatActivity {

  private static final String TAG = "SaludoActivity ";
  @BindView(R.id.txtSaludo)
  TextView txtSaludo;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_saludo);
    ButterKnife.setDebug(true);
    ButterKnife.bind(this);
    final Bundle bundle = this.getIntent().getExtras();
    final String nombre = bundle.getString("nombre");
    Log.d(TAG, String.format("Llego %s", nombre));
    this.txtSaludo.setText(String.format("Hola %s", nombre));
  }
}
