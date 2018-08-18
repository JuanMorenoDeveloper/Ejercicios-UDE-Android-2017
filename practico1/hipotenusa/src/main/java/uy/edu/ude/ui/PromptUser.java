package uy.edu.ude.ui;

public interface PromptUser {
    public void showMessage(String message);

    public void showMessageWithParam(String message, double... params);
}
