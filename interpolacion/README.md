# Interpolación de Lagrange y Newton

En esta práctica usamos dos métodos para estimar el valor de una función entre puntos conocidos. Ambos reciben los mismos nodos y evalúan en el mismo punto. La consola muestra la tabla de diferencias divididas de Newton y permite comparar los resultados con un valor calculado a mano.

## Ejemplo de la práctica

Tomamos tres puntos de la función f(x) = x² + x + 1.

| x | f(x) |
|---:|---:|
| 0 | 1 |
| 2 | 7 |
| 4 | 21 |

Evaluamos en **x = 3**, entre los nodos 2 y 4. Podemos comprobar el resultado directamente con la función: f(3) = 9 + 3 + 1 = **13**.

- **Lagrange.** Cada nodo aporta su valor de y multiplicado por su base. En x = 3 las bases valen −1/8, 3/4 y 3/8. Al sumar 1(−1/8) + 7(3/4) + 21(3/8) obtenemos 13.
- **Newton.** La primera fila de la tabla da los coeficientes 1, 3 y 1. Con ellos evaluamos 1 + 3(3 − 0) + (3 − 0)(3 − 2), que también da 13.

## Archivos del proyecto

| Archivo | Qué hace |
|---|---|
| `Main.java` | Define los nodos y el punto de evaluación. Ejecuta ambos métodos y muestra la diferencia absoluta. |
| `InterpolacionLagrange.java` | Calcula el producto de cada base y suma la aportación de los nodos. |
| `InterpolacionNewton.java` | Construye e imprime la tabla de diferencias divididas y evalúa el polinomio. |

Los tres fuentes están en `src/interpolacion/`. La clase de Newton conserva los métodos del [proyecto del profesor](https://github.com/victorvasher/M-todos-N-mericos-ITSX/tree/main/Interpolaci%C3%B3n).

## Cómo ejecutarlo

Usa el JDK 21, que fue la versión con la que se probó la compilación. En VS Code, abre la carpeta `interpolacion` con soporte para Java y ejecuta `src/interpolacion/Main.java`.

También puedes compilar desde PowerShell, dentro de la carpeta `interpolacion`.

```powershell
javac -encoding UTF-8 -d out src/interpolacion/Main.java src/interpolacion/InterpolacionLagrange.java src/interpolacion/InterpolacionNewton.java
java -cp out interpolacion.Main
```

## Salida esperada

```text
--- TABLA DE DIFERENCIAS DIVIDIDAS ---
x_i     f[x_i]  Orden 1 Orden 2
-----------------------------------------------------
0.00    1.0000  3.0000  1.0000
2.00    7.0000  7.0000
4.00    21.0000

Punto de evaluacion: x = 3.00
Lagrange: 13.0000000000
Newton:   13.0000000000
Valor de referencia: 13.0000000000
Diferencia absoluta: 0.0000000000
```

Para probar otro punto de la misma función, cambia `xEval` en `Main.java` y vuelve a ejecutar. Por ejemplo, en `xEval = 1.0` el valor de referencia es 3.

## Reporte de la práctica

El [reporte en PDF](Metodos_Numericos_Tarea_1_Unidad_5_20261109_AhuedCortes_M.pdf) incluye la explicación de la línea corregida de Lagrange, las capturas de VS Code y la comparación del costo de ambos métodos.
