package uy.edu.ude.app.login;

import android.text.TextUtils;

import uy.edu.ude.app.data.UserCredentialDb;

public class LoginInteractorImpl implements LoginInteractor {

  @Override
  public void login(final String username, final String password, final OnLoginFinishedListener listener) {
    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      listener.onUsernameError();
      error = true;
      return;
    }
    if (TextUtils.isEmpty(password)) {
      listener.onPasswordError();
      error = true;
      return;
    }
    if (!error) {
      listener.onSuccess(username);
    }
  }

  @Override
  public void login(String username, String password, OnLoginFinishedListener listener, UserCredentialDb db) throws Exception {
    boolean error = false;
    if(db.exists(username)){
      if(db.getPasswordFrom(username).equals(password)){
        error=true;
      }
    }else{
      listener.onUsernameError();
    }
    if (!error) {
      listener.onSuccess(username);
    }
  }
}
