package euler;

public class MetodoRungeKutta {

    public static double evaluarFuncion(double x, double y) {
        return x + y;
    }
    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        double xFinal = 0.3;

        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("n\t x_n\t y_n (RK4)");
        System.out.println("--------------------------------");
        System.out.printf(java.util.Locale.ROOT, "%d\t %.4f\t %.12f%n", 0, x, y);

        for (int i = 0; i < nPasos; i++) {
            double k1 = evaluarFuncion(x, y);
            double k2 = evaluarFuncion(x + h / 2.0, y + h * k1 / 2.0);
            double k3 = evaluarFuncion(x + h / 2.0, y + h * k2 / 2.0);
            double k4 = evaluarFuncion(x + h, y + h * k3);

            y += h * (k1 + 2.0 * k2 + 2.0 * k3 + k4) / 6.0;
            x += h;
            System.out.printf(java.util.Locale.ROOT, "%d\t %.4f\t %.12f%n", i + 1, x, y);
        }
    }
}
