

package uy.edu.ude.app.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import uy.edu.ude.app.R;

public class MainActivity extends AppCompatActivity implements MainView {

  private MainPresenter presenter;
  private TextView txtWelcomeUser;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    List<String> list=new LinkedList<>();
    txtWelcomeUser = (TextView) findViewById(R.id.txtWelcomeUser);
    presenter = new MainPresenterImpl(this, new WelcomeUserInteractorImpl());
    presenter.onCreate();
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override
  protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }

  @Override
  public void showWelcomeMessage(String username) {
    Toast.makeText(this, username, Toast.LENGTH_LONG).show();
  }

  @Override
  public void setWelcomeMessage(String message) {
    txtWelcomeUser.setText(message);
  }

  @Override
  public String getUsername() {
    return getIntent().getExtras().getString("username");
  }
}