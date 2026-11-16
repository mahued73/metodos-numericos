package euler;

public class MetodoEuler {

    public static double evaluarFuncion(double x, double y) {
        // x - y
        return x - y;
    }

    public static void main(String[] args) {
        ejecutar(0.1);
        ejecutar(0.05);
        ejecutar(0.01);
    }

    private static void ejecutar(double h) {
        double x0 = 0.0;
        double y0 = 1.0;
        double xFinal = 0.3;

        // Criterio de paro (numero total de pasos N)
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.printf(java.util.Locale.ROOT, "%nh = %.2f%n", h);
        System.out.println("n\t x_n\t y_n (Euler)");
        System.out.println("--------------------------------");
        System.out.printf(java.util.Locale.ROOT, "%d\t %.4f\t %.12f%n", 0, x, y);

        for (int i = 0; i < nPasos; i++) {
            double pendiente = evaluarFuncion(x, y);
            y += h * pendiente;
            x += h;
            System.out.printf(java.util.Locale.ROOT, "%d\t %.4f\t %.12f%n", i + 1, x, y);
        }
    }
}
