package Ecuaciones_lineales;

public class Lanzador_gaus {
    public static void main(String[] args) {
        // El sistema del ejemplo se toma de la matriz definida en defmatrizz.
        double[][] matriz = defmatrizz.defmatriz();
        Gauss.eliminacionGaussiana(matriz);
        double[] soluciones = Gauss.sustitucionRegresiva(matriz);

        System.out.println("Soluciones del sistema:");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.println("x" + (i + 1) + " = " + soluciones[i]);
        }
    }
}
