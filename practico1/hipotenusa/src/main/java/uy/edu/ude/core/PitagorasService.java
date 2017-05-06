package uy.edu.ude.core;

import uy.edu.ude.dto.Triangulo;

public class PitagorasService {
    public double getHipotenusaByCatetos(double c1, double c2) {
        return Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
    }

    private double getCatetoFaltanteByHipotenusaAndCateto(double h, double c) {
        return Math.sqrt(Math.pow(h, 2) - Math.pow(c, 2));
    }

    public void computeLadoFaltanteOf(Triangulo triangulo) {
        if (triangulo.getCateto1() == null) {
            triangulo.setCateto1(getCatetoFaltanteByHipotenusaAndCateto(triangulo.getHipotenusa(), triangulo
                    .getCateto2()));
        }
        if (triangulo.getCateto2() == null) {
            triangulo.setCateto2(getCatetoFaltanteByHipotenusaAndCateto(triangulo.getHipotenusa(), triangulo
                    .getCateto1()));
        }
        if (triangulo.getHipotenusa() == null) {
            triangulo.setHipotenusa(getHipotenusaByCatetos(triangulo.getCateto1(), triangulo
                    .getCateto2()));
        }
    }
}
