

package uy.edu.ude.app.login;

public interface LoginPresenter {
  void validateCredentials(String username, String password);

  void onDestroy();
}
