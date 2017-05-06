package uy.edu.ude.validator;

import uy.edu.ude.core.PitagorasService;
import uy.edu.ude.dto.Triangulo;

public class TrianguloValidator {
    private PitagorasService pitagorasService;

    public TrianguloValidator() {
        pitagorasService = new PitagorasService();
    }

    public boolean isValidTrianguloRectangulo(Triangulo triangulo) {
        double hipotenusaCalculada = pitagorasService.getHipotenusaByCatetos(triangulo.getCateto1(), triangulo
                .getCateto2());
        if (Math.abs(hipotenusaCalculada - triangulo.getHipotenusa()) <= 0.1) {
            return true;
        }
        return false;
    }
}
