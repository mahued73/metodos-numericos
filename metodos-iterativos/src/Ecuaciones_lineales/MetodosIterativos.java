package Ecuaciones_lineales;

import java.util.Locale;

public class MetodosIterativos {
    public static double[] jacobi(double[][] A, double[] b, double[] x0,
            int maxIteraciones, double tolerancia) {
        double[] x = x0.clone();
        for (int iteracion = 1; iteracion <= maxIteraciones; iteracion++) {
            double[] xNuevo = new double[x.length];
            for (int i = 0; i < x.length; i++) {
                double suma = 0;
                for (int j = 0; j < x.length; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }
            double error = calcularError(x, xNuevo);
            mostrarIteracion(iteracion, xNuevo, error);
            x = xNuevo;
            if (error < tolerancia) {
                System.out.println("Convergio en " + iteracion + " iteraciones.");
                return x;
            }
        }
        System.out.println("No convergio dentro del limite de iteraciones.");
        return x;
    }

    public static double[] gaussSeidel(double[][] A, double[] b, double[] x0,
            int maxIteraciones, double tolerancia) {
        double[] x = x0.clone();
        for (int iteracion = 1; iteracion <= maxIteraciones; iteracion++) {
            double[] xAnterior = x.clone();
            for (int i = 0; i < x.length; i++) {
                double suma = 0;
                for (int j = 0; j < x.length; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];
                    }
                }
                x[i] = (b[i] - suma) / A[i][i];
            }
            double error = calcularError(xAnterior, x);
            mostrarIteracion(iteracion, x, error);
            if (error < tolerancia) {
                System.out.println("Convergio en " + iteracion + " iteraciones.");
                return x;
            }
        }
        System.out.println("No convergio dentro del limite de iteraciones.");
        return x;
    }

    public static double calcularError(double[] anterior, double[] actual) {
        double error = 0;
        for (int i = 0; i < actual.length; i++) {
            error = Math.max(error, Math.abs(actual[i] - anterior[i]));
        }
        return error;
    }

    private static void mostrarIteracion(int iteracion, double[] x, double error) {
        System.out.print(iteracion);
        for (int i = 0; i < x.length; i++) {
            System.out.printf(Locale.US, "  %.10f", x[i]);
        }
        System.out.printf(Locale.US, "  error=%.10f%n", error);
    }
}
