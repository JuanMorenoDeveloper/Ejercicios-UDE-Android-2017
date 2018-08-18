

package uy.edu.ude.app.main;

public interface MainPresenter {

  void onCreate();

  void onResume();

  void onDestroy();

  void showWelcomeMessage(String message);

  void setWelcomeMessage(String message);
}
