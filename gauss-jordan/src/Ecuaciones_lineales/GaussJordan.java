package Ecuaciones_lineales;

public class GaussJordan {

    public static void gaussJordan(double[][] matriz) {
        int n = matriz.length;

        // Reutilizamos Gauss sobre la misma matriz para hacer ceros debajo de la diagonal.
        Gauss.eliminacionGaussiana(matriz);

        for (int i = n - 1; i >= 0; i--) {
            double pivote = matriz[i][i];

            // Dividimos toda la fila para que el pivote sea 1, incluida la última columna.
            for (int k = 0; k <= n; k++) {
                matriz[i][k] /= pivote;
            }

            for (int j = i - 1; j >= 0; j--) {
                double factor = matriz[j][i];

                // Restamos la fila pivote multiplicada por el factor para hacer ceros arriba.
                for (int k = 0; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }
}
