package uy.edu.ude.dto;

public class Triangulo {
    private Double cateto1;
    private Double cateto2;
    private Double hipotenusa;

    public Triangulo(Double cateto1, Double cateto2, Double hipotenusa) {
        this.cateto1 = cateto1;
        this.cateto2 = cateto2;
        this.hipotenusa = hipotenusa;
    }

    public Double getCateto1() {
        return cateto1;
    }

    public void setCateto1(Double cateto1) {
        this.cateto1 = cateto1;
    }

    public Double getCateto2() {
        return cateto2;
    }

    public void setCateto2(Double cateto2) {
        this.cateto2 = cateto2;
    }

    public Double getHipotenusa() {
        return hipotenusa;
    }

    public void setHipotenusa(Double hipotenusa) {
        this.hipotenusa = hipotenusa;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "cateto1=" + cateto1 +
                ", cateto2=" + cateto2 +
                ", hipotenusa=" + hipotenusa +
                '}';
    }
}
