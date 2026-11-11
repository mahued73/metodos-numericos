package Ajuste_de_Funciones;

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Cada posición de x e y forma un par del ejemplo.
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 5, 4, 5};
        System.out.println("X = " + Arrays.toString(x));
        System.out.println("Y = " + Arrays.toString(y));

        double[] coeficientes = RegresionLineal.calcularMinimosCuadrados(x, y);
        // Los primeros dos coeficientes son la ordenada y la pendiente.
        double prediccion = RegresionLineal.predecir(coeficientes[0], coeficientes[1], 3.5);
        System.out.printf(Locale.ROOT, "Prediccion interpolada X=3.5: %.4f%n", prediccion);
    }
}
