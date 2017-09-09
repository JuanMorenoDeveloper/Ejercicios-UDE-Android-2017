

package uy.edu.ude.app.login;

import uy.edu.ude.app.data.UserCredentialDb;

public interface LoginInteractor {

  interface OnLoginFinishedListener {
    void onUsernameError();

    void onPasswordError();

    void onSuccess(String username);
  }

  void login(String username, String password, OnLoginFinishedListener listener);

  void login(String username, String password,
             OnLoginFinishedListener listener,
             UserCredentialDb db) throws Exception;

}
