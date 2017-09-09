

package uy.edu.ude.app.login;

import android.os.Bundle;

public interface LoginView {
  void setUsernameError();

  void setPasswordError();

  void navigateToHome(Bundle bundle);
}
