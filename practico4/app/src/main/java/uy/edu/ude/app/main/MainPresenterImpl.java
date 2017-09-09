

package uy.edu.ude.app.main;

public class MainPresenterImpl implements MainPresenter, WelcomeUserInteractor.OnLoadHomeUserListener {

  private MainView mainView;
  private WelcomeUserInteractor welcomeUserInteractor;
  private String username;

  public MainPresenterImpl(MainView mainView, WelcomeUserInteractor welcomeUserInteractor) {
    this.mainView = mainView;
    this.welcomeUserInteractor = welcomeUserInteractor;
  }

  @Override
  public void onCreate() {
    this.username = mainView.getUsername();
    welcomeUserInteractor.setWelcomeMessage(username, this);
  }

  @Override
  public void onResume() {
    if (mainView != null) {
      welcomeUserInteractor.showWelcomeMessage(username, this);
    }
  }

  @Override
  public void onDestroy() {
    mainView = null;
  }

  @Override
  public void showWelcomeMessage(String message) {
    mainView.showWelcomeMessage(message);
  }

  @Override
  public void setWelcomeMessage(String message) {
    mainView.setWelcomeMessage(message);
  }

}