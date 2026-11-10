package Ajuste_de_Funciones;
import java.util.Arrays;
import java.util.Locale;
public class Main {
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 5, 4, 5};
        System.out.println("Datos didacticos propios, no mediciones reales.");
        System.out.println("X = " + Arrays.toString(x));
        System.out.println("Y = " + Arrays.toString(y));
        try {
            double[] c = RegresionLineal.calcularMinimosCuadrados(x, y);
            System.out.printf(Locale.ROOT, "Prediccion interpolada X=3.5: %.4f%n", RegresionLineal.predecir(c[0], c[1], 3.5));
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
