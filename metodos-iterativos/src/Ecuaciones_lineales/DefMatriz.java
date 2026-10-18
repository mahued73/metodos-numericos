package Ecuaciones_lineales;

public class DefMatriz {
    public static double[][] obtenerMatrizA() {
        return new double[][] {{5, 1, 1}, {1, 4, 1}, {1, 2, 5}};
    }

    public static double[] obtenerVectorB() {
        return new double[] {7, 6, 8};
    }

    public static double[] obtenerVectorX() {
        return new double[] {0, 0, 0};
    }

    public static double obtenerTolerancia() {
        return 0.0001;
    }
}
