package interpolacion;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Nodos tomados de f(x) = x² + x + 1.
        double[] x = {0.0, 2.0, 4.0};
        double[] y = {1.0, 7.0, 21.0};
        double xEval = 3.0;

        // Los dos métodos reciben los mismos nodos y el mismo punto.
        double lagrange = InterpolacionLagrange.interpolacionLagrange(x, y, xEval);
        double[][] tabla = InterpolacionNewton.calcularDiferenciasDivididas(x, y);
        double newton = InterpolacionNewton.evaluarPolinomio(x, tabla, xEval);
        // Evaluamos la función original para comprobar los dos resultados.
        double referencia = xEval * xEval + xEval + 1;

        // La tabla permite revisar de dónde salen los coeficientes de Newton.
        InterpolacionNewton.imprimirTabla(x, tabla);
        System.out.printf("%nPunto de evaluacion: x = %.2f%n", xEval);
        System.out.printf("Lagrange: %.10f%n", lagrange);
        System.out.printf("Newton:   %.10f%n", newton);
        System.out.printf("Valor de referencia: %.10f%n", referencia);
        System.out.printf("Diferencia absoluta: %.10f%n", Math.abs(lagrange - newton));
    }
}
