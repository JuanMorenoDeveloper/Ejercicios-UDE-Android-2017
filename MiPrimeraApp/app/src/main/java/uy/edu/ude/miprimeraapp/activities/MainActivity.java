package uy.edu.ude.miprimeraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uy.edu.ude.miprimeraapp.R;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  private TextView txtHelloWorld;
  private EditText editNombre;
  private Button btnAceptar;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //DownCasting
    this.txtHelloWorld = (TextView) findViewById(R.id.txtHello);
    this.txtHelloWorld.setText("Hola Mundo");
    this.btnAceptar = (Button) findViewById(R.id.btnAceptar);
    this.editNombre = (EditText) findViewById(R.id.editNombre);
    this.btnAceptar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(final View view) {
        final String nombre = MainActivity.this.editNombre.getText().toString();
        Log.d(TAG, nombre);
        Toast.makeText(
            MainActivity.this, nombre,
            Toast.LENGTH_LONG).show();
        final Intent intent = new Intent(MainActivity.this, SaludoActivity.class);
        final Bundle bundle = new Bundle();
        bundle.putString("nombre", nombre);
        intent.putExtras(bundle);
        startActivity(intent);
      }
    });
    View view = new View(this);
    //Upcasting
    view = this.editNombre;
  }
}
