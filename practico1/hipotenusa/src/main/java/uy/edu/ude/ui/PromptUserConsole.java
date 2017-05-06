package uy.edu.ude.ui;

public class PromptUserConsole implements PromptUser {

    @Override
    public void showMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void showMessageWithParam(String message, double... params) {
        StringBuilder sb = new StringBuilder(message);
        for (double param : params) {
            sb.append(param).append(" ");
        }
        System.out.println(sb.toString());
    }
}
