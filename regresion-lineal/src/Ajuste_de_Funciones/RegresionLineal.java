package Ajuste_de_Funciones;

import java.util.Locale;

public class RegresionLineal {
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        if (x.length != y.length || x.length == 0) {
            System.out.println("Error: Los arreglos deben tener el mismo tamano y no estar vacios.");
            return new double[]{0.0, 0.0, 0.0, 0.0};
        }

        int n = x.length;
        double sumX = 0, sumY = 0, sumX2 = 0, sumY2 = 0, sumXY = 0;

        // Juntamos las sumas que se usan en el ajuste y en Pearson.
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
            sumXY += x[i] * y[i];
        }
        // La pendiente y Pearson usan el mismo numerador.
        double dx = n * sumX2 - sumX * sumX;
        double dy = n * sumY2 - sumY * sumY;
        double numerador = n * sumXY - sumX * sumY;
        double beta1 = numerador / dx;
        double beta0 = (sumY - beta1 * sumX) / n;

        double pearsonR = numerador / Math.sqrt(dx * dy);
        double r2 = pearsonR * pearsonR;

        System.out.println("--- RESULTADOS DE MINIMOS CUADRADOS Y CORRELACION ---");
        System.out.printf(Locale.ROOT, "Sumatorias: n=%d, X=%.1f, Y=%.1f, X2=%.1f, Y2=%.1f, XY=%.1f%n",
                n, sumX, sumY, sumX2, sumY2, sumXY);
        System.out.printf(Locale.ROOT, "Pendiente (beta1): %.4f%n", beta1);
        System.out.printf(Locale.ROOT, "Ordenada al origen (beta0): %.4f%n", beta0);
        System.out.printf(Locale.ROOT, "Modelo obtenido: Y = %.4f %+.4fX%n", beta0, beta1);
        System.out.printf(Locale.ROOT, "Coeficiente de Pearson (r): %.4f%n", pearsonR);
        System.out.printf(Locale.ROOT, "Coeficiente de Determinacion (r2): %.4f%n", r2);

        return new double[]{beta0, beta1, pearsonR, r2};
    }

    public static double predecir(double beta0, double beta1, double xValor) {
        return beta0 + beta1 * xValor;
    }
}
