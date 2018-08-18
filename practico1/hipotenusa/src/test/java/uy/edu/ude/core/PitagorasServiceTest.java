package uy.edu.ude.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PitagorasServiceTest {

    private PitagorasService pitagorasService;

    @Before
    public void init() {
        pitagorasService = new PitagorasService();
    }

    @Test
    public void shouldGetHipotenusaEqualsToSqrt2() {
        double h = pitagorasService.getHipotenusaByCatetos(1, 1);
        Assert.assertEquals(1.41, h, 0.01);
    }
    @Test
    public void givenAdulto_whenValidoEdad_thenGetTrue(){
        Assert.assertEquals(true,isAdulto(20));
        Assert.assertEquals(true,isAdulto(20));
    }
    @Test
    public void givenMenor_whenValidoEdad_thenGetFalse(){
        Assert.assertEquals(false,isAdulto(15));
    }
    boolean isAdulto(int edad){
        return edad>18;
    }
}
