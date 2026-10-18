package Ecuaciones_lineales;

public class Main {
    public static void main(String[] args) {
        double[][] A = DefMatriz.obtenerMatrizA();
        double[] b = DefMatriz.obtenerVectorB();
        double[] x0 = DefMatriz.obtenerVectorX();
        double tolerancia = DefMatriz.obtenerTolerancia();
        int maxIteraciones = 100;

        System.out.println("Jacobi: iteracion, x, y, z, error");
        MetodosIterativos.jacobi(A, b, x0, maxIteraciones, tolerancia);
        System.out.println("\nGauss-Seidel: iteracion, x, y, z, error");
        MetodosIterativos.gaussSeidel(A, b, x0, maxIteraciones, tolerancia);
    }
}
