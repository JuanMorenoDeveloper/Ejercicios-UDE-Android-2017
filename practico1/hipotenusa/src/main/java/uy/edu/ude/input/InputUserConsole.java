package uy.edu.ude.input;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputUserConsole implements InputUser {

    private Scanner scanner;

    public InputUserConsole() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
    }

    @Override
    public double getDoubleValue() {
        return scanner.nextDouble();
    }

    @Override
    public String getStringValue() {
        return scanner.next();
    }
}
