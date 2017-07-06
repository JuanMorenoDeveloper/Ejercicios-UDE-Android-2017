package uy.edu.ude.miprimeraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import uy.edu.ude.miprimeraapp.R;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  private EditText inUser;
  private EditText inPassword;
  private Button btnSingIn;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    this.btnSingIn = (Button) findViewById(R.id.btnSignIn);
    this.inUser = (EditText) findViewById(R.id.inUsername);
    this.inPassword = (EditText) findViewById(R.id.inPassword);
    this.btnSingIn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(final View view) {
        final String user = MainActivity.this.inUser.getText().toString();
        final String password = MainActivity.this.inPassword.getText().toString();
        final Intent intent = new Intent(MainActivity.this, SaludoActivity.class);
        final Bundle bundle = new Bundle();
        bundle.putString("username", user);
        bundle.putString("password", password);
        intent.putExtras(bundle);
        startActivity(intent);
      }
    });
  }
}
