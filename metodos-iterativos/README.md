# Métodos iterativos

Métodos Numéricos · Tarea 2 de la unidad 3

Se resuelve el sistema `5x + y + z = 7`, `x + 4y + z = 6` y `x + 2y + 5z = 8` con Jacobi y Gauss-Seidel. Los dos métodos parten de `[0, 0, 0]`, usan tolerancia `0.0001` y tienen un límite de 100 iteraciones.

## Clases

Los tres archivos están en `src/Ecuaciones_lineales`:

- `DefMatriz.java`: define la matriz, los vectores y la tolerancia.
- `MetodosIterativos.java`: contiene Jacobi, Gauss-Seidel y el cálculo del error.
- `Main.java`: ejecuta ambos métodos y muestra las iteraciones.

Jacobi guarda los nuevos valores en un vector auxiliar. Gauss-Seidel actualiza el mismo vector durante el recorrido y aprovecha los valores recién calculados.

## Compilar y ejecutar

Con un JDK instalado, abrir una terminal en esta carpeta y ejecutar:

```text
javac -encoding UTF-8 -d out src/Ecuaciones_lineales/DefMatriz.java src/Ecuaciones_lineales/MetodosIterativos.java src/Ecuaciones_lineales/Main.java
java -cp out Ecuaciones_lineales.Main
```

## Resultados

El error es el máximo cambio absoluto entre dos aproximaciones consecutivas. Cada iteración actualiza las tres incógnitas; el programa termina cuando ese cambio es menor que `0.0001`.

| Método | Iteraciones | Último error |
|---|---:|---:|
| Jacobi | 16 | 0.0000523159 |
| Gauss-Seidel | 6 | 0.0000724376 |

Ambos resultados se aproximan a `[1, 1, 1]`. En este sistema, Gauss-Seidel necesita diez iteraciones menos. Los valores se redondean solo al imprimirlos.

## Reporte

[Consultar el PDF con el código explicado, la comparación y la captura de ejecución](reporte/Metodos_Numericos_Tarea_2_20261018_AhuedCortes_M.pdf).
