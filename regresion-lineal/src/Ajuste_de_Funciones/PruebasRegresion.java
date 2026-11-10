package Ajuste_de_Funciones;
public class PruebasRegresion {
    private static int casos = 0;
    private static void cerca(double real, double esperado) {
        if (!Double.isFinite(real) || Math.abs(real - esperado) > 1e-10 * Math.max(1, Math.abs(esperado)))
            throw new AssertionError("Esperado " + esperado + "; obtenido " + real);
    }
    private static void modelo(String nombre, double[] x, double[] y, double[] esperado) {
        double[] real = RegresionLineal.calcularMinimosCuadrados(x, y);
        for (int i = 0; i < 4; i++) cerca(real[i], esperado[i]);
        double media = 0, sse = 0, sst = 0;
        for (double v : y) media += v / y.length;
        for (int i = 0; i < x.length; i++) {
            double residuo = y[i] - RegresionLineal.predecir(real[0], real[1], x[i]);
            sse += residuo * residuo;
            sst += (y[i] - media) * (y[i] - media);
        }
        cerca(real[3], 1 - sse / sst); // Verificacion independiente de r*r.
        System.out.println("PASS: " + nombre); casos++;
    }
    private static void error(String nombre, Class<? extends RuntimeException> tipo, Runnable accion) {
        try { accion.run(); }
        catch (RuntimeException e) {
            if (!tipo.isInstance(e)) throw new AssertionError("Tipo incorrecto", e);
            System.out.println("PASS: " + nombre + " -> " + e.getMessage()); casos++; return;
        }
        throw new AssertionError("No se rechazo " + nombre);
    }
    public static void main(String[] args) {
        double[] x = {1,2,3,4,5};
        modelo("ejemplo no perfecto", x, new double[]{2,4,5,4,5}, new double[]{2.2,.6,3/Math.sqrt(15),.6});
        modelo("positiva perfecta", x, new double[]{3,5,7,9,11}, new double[]{1,2,1,1});
        modelo("negativa perfecta", x, new double[]{8,6,4,2,0}, new double[]{10,-2,-1,1});
        modelo("r cero con relacion cuadratica", new double[]{-2,-1,0,1,2}, new double[]{4,1,0,1,4}, new double[]{2,0,0,0});
        modelo("dos puntos", new double[]{0,2}, new double[]{1,5}, new double[]{1,2,1,1});
        modelo("decimales", new double[]{.1,.2,.3}, new double[]{1.2,1.4,1.6}, new double[]{1,2,1,1});
        error("nulo X", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(null,x));
        error("nulo Y", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(x,null));
        error("vacios", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{},new double[]{}));
        error("longitudes", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(x,new double[]{1,2}));
        error("un punto", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{1},new double[]{2}));
        error("X constante", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{2,2},new double[]{1,2}));
        error("Y constante", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{1,2},new double[]{2,2}));
        error("NaN", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{1,Double.NaN},new double[]{1,2}));
        error("infinito", IllegalArgumentException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{1,2},new double[]{1,Double.POSITIVE_INFINITY}));
        error("overflow", ArithmeticException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{1e200,2e200},new double[]{1,2}));
        error("cancelacion", ArithmeticException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{1e12,1e12+1,1e12+2},new double[]{1,2,3}));
        error("subdesbordamiento", ArithmeticException.class, () -> RegresionLineal.calcularMinimosCuadrados(new double[]{1e-200,2e-200},new double[]{1,2}));
        cerca(RegresionLineal.predecir(2.2,.6,3.5),4.3); casos++; System.out.println("PASS: prediccion");
        error("prediccion invalida", IllegalArgumentException.class, () -> RegresionLineal.predecir(0,1,Double.NaN));
        error("prediccion overflow", ArithmeticException.class, () -> RegresionLineal.predecir(0,Double.MAX_VALUE,2));
        System.out.println("TOTAL: " + casos + " casos aprobados.");
    }
}
