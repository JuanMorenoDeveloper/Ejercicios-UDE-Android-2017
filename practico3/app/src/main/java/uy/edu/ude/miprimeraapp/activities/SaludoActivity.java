package uy.edu.ude.miprimeraapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

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
    final String user = bundle.getString("username");
    final String password = bundle.getString("password");
    validarUsuario(user, password);
    txtSaludo.setText(String.format("Hola %s",user));
  }

  protected void validarUsuario(final String user, final String password) {
    if ((user.equals("user") && password.equals("pass"))) {
      Toast.makeText(this, String.format("Bienvenido %s", user), Toast.LENGTH_LONG).show();
    } else {
      Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
      finish();
    }
  }
}
