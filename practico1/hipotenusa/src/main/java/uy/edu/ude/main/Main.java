package uy.edu.ude.main;

import uy.edu.ude.core.PitagorasService;
import uy.edu.ude.dto.Triangulo;
import uy.edu.ude.input.InputUser;
import uy.edu.ude.input.InputUserConsole;
import uy.edu.ude.ui.PromptUser;
import uy.edu.ude.ui.PromptUserConsole;
import uy.edu.ude.validator.InputValidator;
import uy.edu.ude.validator.TrianguloValidator;

public class Main {
    public static void main(String[] args) throws Exception {
        PromptUser promptUser = new PromptUserConsole();
        InputUser inputUser = new InputUserConsole();
        PitagorasService pitagorasService = new PitagorasService();
        Main main = new Main();
        //main.calcHipotenusa(promptUser, inputUser, pitagorasService);
        main.calcHipotenusaByTriangulo(promptUser, inputUser, pitagorasService);
    }

    public void calcHipotenusa(PromptUser promptUser, InputUser inputUser, PitagorasService pitagorasService) {
        double c1;
        double c2;
        double h;
        promptUser.showMessage("\n--Calcular la hipotenusa--\n");
        promptUser.showMessage("C1: ");
        c1 = inputUser.getDoubleValue();
        promptUser.showMessage("C2: ");
        c2 = inputUser.getDoubleValue();
        h = pitagorasService.getHipotenusaByCatetos(c1, c2);
        promptUser.showMessageWithParam("H: ", h);
    }

    public void calcHipotenusaByTriangulo(PromptUser promptUser, InputUser inputUser, PitagorasService
            pitagorasService) throws Exception {
        Double c1;
        Double c2;
        Double h;
        String input;
        Triangulo triangulo;
        InputValidator inputValidator = new InputValidator();
        TrianguloValidator trianguloValidator = new TrianguloValidator();
        promptUser.showMessage("\n--Calcular el lado faltante--\n");
        c1 = askOpcionalDoubleValueToUser(promptUser, inputUser, "C1");
        c2 = askOpcionalDoubleValueToUser(promptUser, inputUser, "C2");
        h = askOpcionalDoubleValueToUser(promptUser, inputUser, "H");
        inputValidator.validateMininumInputs(c1, c2, h);
        triangulo = new Triangulo(c1, c2, h);
        pitagorasService.computeLadoFaltanteOf(triangulo);
        if (trianguloValidator.isValidTrianguloRectangulo(triangulo)) {
            promptUser.showMessage(String.format("Triangulo: %s", triangulo));
        }else{
            promptUser.showMessage("El triangulo no es valido");
        }
    }

    private Double askOpcionalDoubleValueToUser(PromptUser prompt, InputUser inputUser, String label) {
        String input;
        Double value = null;
        String mensaje = String.format("¿Desea ingresar %s? (S/N): ", label);
        do {
            prompt.showMessage(mensaje);
            input = inputUser.getStringValue();
        } while (!input.equalsIgnoreCase("S") && !input.equalsIgnoreCase("N"));
        mensaje = String.format("%s: ", label);
        if (input.equalsIgnoreCase("S")) {
            prompt.showMessage(mensaje);
            value = inputUser.getDoubleValue();
        }
        return value;
    }
}
