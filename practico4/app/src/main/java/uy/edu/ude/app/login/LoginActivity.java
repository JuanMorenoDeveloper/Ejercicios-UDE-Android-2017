package uy.edu.ude.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import uy.edu.ude.app.R;
import uy.edu.ude.app.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

  private EditText username;
  private EditText password;
  private LoginPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    username = (EditText) findViewById(R.id.username);
    password = (EditText) findViewById(R.id.password);
    findViewById(R.id.button).setOnClickListener(this);
    presenter = new LoginPresenterImpl(this);
  }

  @Override
  protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }

  @Override
  public void setUsernameError() {
    username.setError(getString(R.string.username_error));
  }

  @Override
  public void setPasswordError() {
    password.setError(getString(R.string.password_error));
  }

  @Override
  public void navigateToHome(Bundle bundle) {
    final Intent intent = new Intent(this, MainActivity.class);
    intent.putExtras(bundle);
    startActivity(intent);
    //finish();
  }

  @Override
  public void onClick(View v) {
    presenter.validateCredentials(username.getText().toString(), password.getText().toString());
  }
}
