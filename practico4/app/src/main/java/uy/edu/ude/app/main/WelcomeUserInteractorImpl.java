package uy.edu.ude.app.main;

/**
 * Created by juan on 26/06/17.
 */

public class WelcomeUserInteractorImpl implements WelcomeUserInteractor {
  public void showWelcomeMessage(String username, OnLoadHomeUserListener listener) {
    listener.showWelcomeMessage(String.format("Hola %s", username));
  }

  @Override
  public void setWelcomeMessage(String username, OnLoadHomeUserListener listener) {
    listener.setWelcomeMessage(String.format("Bienvenido %s", username));
  }
}
