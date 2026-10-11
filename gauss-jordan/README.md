# Método de Gauss-Jordan

Métodos Numéricos · Tarea 1 de la unidad 3

## Archivos

- `defmatrizz.java`: define la matriz aumentada.
- `Gauss.java`: contiene la eliminación gaussiana de la práctica anterior.
- `GaussJordan.java`: llama a Gauss, divide las filas entre sus pivotes y hace ceros arriba de la diagonal.
- `Lanzador_gauss_jordan.java`: muestra la matriz inicial, la matriz final y las soluciones.

Las cuatro clases están en el paquete `Ecuaciones_lineales`. El cálculo modifica la misma matriz creada en el lanzador. La clase Gauss conserva la sustitución regresiva de la práctica anterior, pero Gauss-Jordan obtiene las soluciones de la última columna y no llama a ese método.

## Compilar y ejecutar

Desde esta carpeta, con Java instalado:

```powershell
javac -encoding UTF-8 -d out src/Ecuaciones_lineales/*.java
java -cp out Ecuaciones_lineales.Lanzador_gauss_jordan
```

## Ejemplo del profesor

Salida de la ejecución con la matriz incluida en `defmatrizz.java`:

```text
Matriz aumentada inicial:
3.0	-0.1	-0.2	7.85	
0.1	7.0	-0.3	-19.3	
0.3	-0.2	10.0	71.4	

Matriz despues de Gauss-Jordan:
1.0	0.0	0.0	3.0	
0.0	1.0	0.0	-2.5	
0.0	0.0	1.0	7.000000000000002	

Soluciones del sistema:
x1 = 3.0
x2 = -2.5
x3 = 7.000000000000002
```

La salida del ejemplo está guardada en `corridas/ejemplo_profesor.txt`.

## Alcance

Se trabaja con una matriz de n filas y n + 1 columnas. Esta versión no incluye validaciones ni intercambio de filas; necesita pivotes distintos de cero. La impresión muestra los valores de tipo `double` sin redondearlos.
