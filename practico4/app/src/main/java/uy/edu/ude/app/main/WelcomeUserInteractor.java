package uy.edu.ude.app.main;

/**
 * Created by juan on 26/06/17.
 */

public interface WelcomeUserInteractor {

  interface OnLoadHomeUserListener {
    public void showWelcomeMessage(String message);

    public void setWelcomeMessage(String message);
  }

  public void showWelcomeMessage(String message, OnLoadHomeUserListener listener);

  public void setWelcomeMessage(String message, OnLoadHomeUserListener listener);
}
