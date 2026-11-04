package interpolacion;

public class InterpolacionLagrange {
    private static void validarDatos(double[] x, double[] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0) {
            throw new IllegalArgumentException("Los arreglos no pueden ser nulos ni estar vacios.");
        }
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los arreglos x y y deben tener el mismo tamano.");
        }
        // Si hay dos nodos iguales, el denominador del producto sería cero.
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    throw new IllegalArgumentException("Nodos de x repetidos: " + x[i]);
                }
            }
        }
    }

    public static double interpolacionLagrange(double[] x, double[] y, double xEval) {
        validarDatos(x, y);
        double resultado = 0.0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            // Empezamos con y[i] y multiplicamos por los factores de su base.
            double termino = y[i];
            for (int j = 0; j < n; j++) {
                // El nodo i no entra en su propio producto.
                if (i != j) {
                    termino *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            // Sumamos la aportación de este nodo al resultado.
            resultado += termino;
        }
        return resultado;
    }
}
