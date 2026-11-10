package Ajuste_de_Funciones;

import java.util.Locale;

/** Adaptacion del codigo base del docente, Tarea 2 Unidad 5, pp. 1-2.
 * Conserva paquete, firmas, sumatorias y orden {beta0, beta1, r, r2}.
 * Las entradas invalidas se rechazan, en vez de devolver ceros ambiguos.
 */
public class RegresionLineal {
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length || x.length < 2) {
            throw new IllegalArgumentException("Se requieren arreglos no nulos, del mismo tamano y al menos dos pares.");
        }
        int n = x.length;
        double sumX = 0, sumY = 0, sumX2 = 0, sumY2 = 0, sumXY = 0;
        boolean constanteX = true, constanteY = true;
        for (int i = 0; i < n; i++) {
            if (!Double.isFinite(x[i]) || !Double.isFinite(y[i])) {
                throw new IllegalArgumentException("Todos los datos deben ser finitos; indice " + i);
            }
            constanteX &= x[i] == x[0];
            constanteY &= y[i] == y[0];
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
            sumXY += x[i] * y[i];
        }
        if (constanteX) throw new IllegalArgumentException("X constante: pendiente no identificable y Pearson indefinido.");
        if (constanteY) throw new IllegalArgumentException("Y constante: Pearson y r2 indefinidos; el modelo horizontal si existe.");
        double dx = n * sumX2 - sumX * sumX;
        double dy = n * sumY2 - sumY * sumY;
        double numerador = n * sumXY - sumX * sumY;
        validarDispersion(dx, n * sumX2, sumX * sumX, "X");
        validarDispersion(dy, n * sumY2, sumY * sumY, "Y");
        if (!Double.isFinite(numerador)) throw new ArithmeticException("Desbordamiento en covariacion: reescalar datos.");
        double beta1 = numerador / dx;
        double beta0 = (sumY - beta1 * sumX) / n;
        // TODO del PDF completado con las sumatorias. Division separada evita dx*dy.
        double pearsonR = (numerador / Math.sqrt(dx)) / Math.sqrt(dy);
        if (!Double.isFinite(beta0) || !Double.isFinite(beta1) || !Double.isFinite(pearsonR)) {
            throw new ArithmeticException("Resultado no finito: reescalar datos.");
        }
        if (Math.abs(pearsonR) > 1 + 1e-12) throw new ArithmeticException("Pearson fuera de rango por error numerico.");
        pearsonR = Math.max(-1, Math.min(1, pearsonR)); // Solo corrige redondeo diminuto.
        double r2 = pearsonR * pearsonR;
        System.out.println("--- RESULTADOS DE MINIMOS CUADRADOS Y CORRELACION ---");
        System.out.printf(Locale.ROOT, "Sumatorias: n=%d, X=%.6g, Y=%.6g, X2=%.6g, Y2=%.6g, XY=%.6g%n", n, sumX, sumY, sumX2, sumY2, sumXY);
        System.out.printf(Locale.ROOT, "Pendiente (beta1): %.4f%nOrdenada al origen (beta0): %.4f%n", beta1, beta0);
        System.out.printf(Locale.ROOT, "Modelo obtenido: Y = %.4f %+.4fX%n", beta0, beta1);
        System.out.printf(Locale.ROOT, "Coeficiente de Pearson (r): %.4f%nCoeficiente de Determinacion (r2): %.4f%n", pearsonR, r2);
        return new double[]{beta0, beta1, pearsonR, r2};
    }

    private static void validarDispersion(double d, double a, double b, String variable) {
        // Guardia practica, no una cota rigurosa de error para cualquier n.
        double escala = Math.max(Math.abs(a), Math.abs(b));
        if (!Double.isFinite(d) || !Double.isFinite(escala) || d <= 32 * Math.ulp(escala)) {
            throw new ArithmeticException("Dispersion de " + variable + " no resoluble con sumatorias directas: centrar/reescalar datos.");
        }
    }

    public static double predecir(double beta0, double beta1, double xValor) {
        if (!Double.isFinite(beta0) || !Double.isFinite(beta1) || !Double.isFinite(xValor)) {
            throw new IllegalArgumentException("Coeficientes y X deben ser finitos.");
        }
        double resultado = beta0 + beta1 * xValor;
        if (!Double.isFinite(resultado)) throw new ArithmeticException("Prediccion fuera del rango double.");
        return resultado;
    }
}
