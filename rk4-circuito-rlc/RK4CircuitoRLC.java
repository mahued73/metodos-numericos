import java.util.Locale;

/** Integración del sistema RLC por Runge-Kutta de cuarto orden. */
public class RK4CircuitoRLC {
    private static final int PASOS = 25;
    private static final double OMEGA = Math.sqrt(0.96);

    public static double[] evaluarSistema(double t, double[] y) {
        // El sistema es autónomo; t se conserva en la firma del método.
        return new double[] {y[1], -0.4 * y[1] - y[0]};
    }

    public static double[] sumaEscalada(double[] A, double factor, double[] B) {
        if (A.length != B.length) throw new IllegalArgumentException("Dimensiones distintas");
        double[] resultado = new double[A.length];
        for (int j = 0; j < A.length; j++) resultado[j] = A[j] + factor * B[j];
        return resultado;
    }

    static double cargaExacta(double t) {
        return Math.exp(-0.2 * t)
            * (Math.cos(OMEGA * t) + (0.2 / OMEGA) * Math.sin(OMEGA * t));
    }

    public static void main(String[] args) {
        double h;
        try {
            if (args.length > 1) throw new IllegalArgumentException();
            h = args.length == 0 ? 0.2 : Double.parseDouble(args[0]);
            if (!Double.isFinite(h) || h <= 0 || !Double.isFinite(PASOS * h)) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.err.println("Uso: java RK4CircuitoRLC [paso positivo]");
            System.exit(2);
            return;
        }

        double[] y = {1.0, 0.0};
        System.out.println("n,t,y1,y2,q_exact,error_abs");
        for (int n = 0; n <= PASOS; n++) {
            double t = n * h;
            double exacta = cargaExacta(t);
            System.out.printf(Locale.ROOT, "%d,%.8f,%.14f,%.14f,%.14f,%.14e%n",
                n, t, y[0], y[1], exacta, Math.abs(y[0] - exacta));
            if (n == PASOS) break;
            double[] k1 = evaluarSistema(t, y);
            double[] k2 = evaluarSistema(t + h / 2, sumaEscalada(y, h / 2, k1));
            double[] k3 = evaluarSistema(t + h / 2, sumaEscalada(y, h / 2, k2));
            double[] k4 = evaluarSistema(t + h, sumaEscalada(y, h, k3));
            // Las pendientes ya están calculadas antes de actualizar ambas componentes.
            for (int j = 0; j < y.length; j++) {
                y[j] += h / 6 * (k1[j] + 2 * k2[j] + 2 * k3[j] + k4[j]);
            }
        }
    }
}
