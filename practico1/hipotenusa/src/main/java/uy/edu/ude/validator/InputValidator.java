package uy.edu.ude.validator;

import uy.edu.ude.exception.TooManyLadosDesconocidosException;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public void validateMininumInputs(Double c1, Double c2, Double h) throws TooManyLadosDesconocidosException {
        List<Double> inputs = Arrays.asList(c1, c2, h);
        int invalidCounter = 0;
        for (Double input : inputs) {
            if (input == null) {
                invalidCounter++;
            }
        }
        if (invalidCounter >= 2) {
            throw new TooManyLadosDesconocidosException("Hay más de un lado desconocido");
        }
    }
}
