# Regresión lineal por mínimos cuadrados

Tarea 2 de la unidad 5 de Métodos Numéricos. El programa ajusta una recta a cinco pares de datos y calcula el coeficiente de correlación de Pearson (`r`) y el coeficiente de determinación (`r²`). También usa la recta para estimar el valor de `y` en `x = 3.5`.

## Árbol del proyecto

```text
regresion-lineal/
├── .gitignore
├── README.md
├── Metodos_Numericos_Tarea_2_Unidad_5_20261115_AhuedCortes_M.pdf
└── src/
    └── Ajuste_de_Funciones/
        ├── Main.java
        └── RegresionLineal.java
```

`Main.java` contiene los datos del ejemplo y arranca el programa. `RegresionLineal.java` acumula las sumatorias y calcula la pendiente, la ordenada al origen, `r` y `r²`.

## Cómo clonar y ejecutar

Usa Git y un JDK 21 con `java` y `javac` disponibles en la terminal. El proyecto usa únicamente las clases de Java.

1. Clona el repositorio y entra en la carpeta de la práctica.

   ```powershell
   git clone https://github.com/mahued73/metodos-numericos.git
   cd metodos-numericos/regresion-lineal
   ```

2. Compila los dos fuentes y ejecuta la clase `Main`.

   ```powershell
   javac -encoding UTF-8 -d out src/Ajuste_de_Funciones/Main.java src/Ajuste_de_Funciones/RegresionLineal.java
   java -cp out Ajuste_de_Funciones.Main
   ```

Si usas VS Code, abre la carpeta `regresion-lineal` y ejecuta esos mismos comandos en la terminal integrada.

## Datos y resultado esperado

Se usan los pares didácticos `(1, 2)`, `(2, 4)`, `(3, 5)`, `(4, 4)` y `(5, 5)`. La consola imprime los datos y las sumatorias antes de mostrar el ajuste. Estas son las últimas líneas de la ejecución.

```text
Pendiente (beta1): 0.6000
Ordenada al origen (beta0): 2.2000
Modelo obtenido: Y = 2.2000 +0.6000X
Coeficiente de Pearson (r): 0.7746
Coeficiente de Determinacion (r2): 0.6000
Prediccion interpolada X=3.5: 4.3000
```

La pendiente indica que la estimación sube 0.6 por cada unidad de `x`. El valor de `r²` indica que la recta explica el 60 % de la variación de `y` en estos cinco datos. La estimación se comprueba sustituyendo 3.5 en la recta, lo que da 2.2 + 0.6 × 3.5 = 4.3.

## Reporte

El [reporte final en PDF](Metodos_Numericos_Tarea_2_Unidad_5_20261115_AhuedCortes_M.pdf) incluye el cálculo a mano, la captura de la ejecución en VS Code y la interpretación de los resultados.
