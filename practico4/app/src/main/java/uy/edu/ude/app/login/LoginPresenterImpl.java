

package uy.edu.ude.app.login;

import android.os.Bundle;

import uy.edu.ude.app.data.UserCredentialDb;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

  private LoginView loginView;
  private LoginInteractor loginInteractor;

  public LoginPresenterImpl(LoginView loginView) {
    this.loginView = loginView;
    this.loginInteractor = new LoginInteractorImpl();
  }

  @Override
  public void validateCredentials(String username, String password) {
    try {
      loginInteractor.login(username, password, this, new UserCredentialDb());
    }catch (Exception e){
      onUsernameError();
    }
  }

  @Override
  public void onDestroy() {
    loginView = null;
  }

  @Override
  public void onUsernameError() {
    if (loginView != null) {
      loginView.setUsernameError();
    }
  }

  @Override
  public void onPasswordError() {
    if (loginView != null) {
      loginView.setPasswordError();
    }
  }

  @Override
  public void onSuccess(String username) {
    if (loginView != null) {
      final Bundle bundle = new Bundle();
      bundle.putString("username", username);
      loginView.navigateToHome(bundle);
    }
  }
}
