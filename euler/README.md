# Resolución numérica de ecuaciones diferenciales

Actividad de la Unidad 6 de Métodos Numéricos. El programa aplica Euler a
`y' = x - y` y Runge–Kutta de cuarto orden (RK4) a `y' = x + y`.
En ambos ejercicios, `y(0) = 1` y el cálculo termina en `x = 0.3`.

## Integrantes

- Mauricio Ahued Cortés
- Fátima Itzel Martínez Salamanca
- Aretzy Esmeralda Morales Merino

## Archivos

```text
euler/
├── README.md
├── Metodos_Numericos_Actividad_Unidad_6_20261118_AhuedCortes_M.pdf
└── src/
    └── euler/
        ├── MetodoEuler.java
        ├── MetodoRungeKutta.java
        ├── mainEuler.java
        └── mainRungeKutta.java
```

## Compilar y ejecutar

Usa Git y un JDK con `javac` y `java` disponibles en la terminal. Los
comandos se comprobaron con JDK 21. El programa utiliza las clases estándar de Java.

```text
git clone https://github.com/mahued73/metodos-numericos.git
cd metodos-numericos/euler
javac -encoding UTF-8 -d out src/euler/MetodoEuler.java src/euler/MetodoRungeKutta.java src/euler/mainEuler.java src/euler/mainRungeKutta.java
java -cp out euler.mainEuler
java -cp out euler.mainRungeKutta
```

## Salida esperada

Euler imprime una tabla por tamaño de paso. RK4 imprime la tabla de su
ejercicio con paso 0.1. Cada tabla contiene la iteración, la coordenada x
y el valor aproximado de y. La última fila de cada corrida corresponde
a x = 0.3.

| Método | Paso h | Pasos | y al final |
| --- | ---: | ---: | ---: |
| Euler | 0.1 | 3 | 0.758000000000 |
| Euler | 0.05 | 6 | 0.770183781250 |
| Euler | 0.01 | 30 | 0.779400746777 |
| RK4 | 0.1 | 3 | 1.399716994125 |

## Reporte

El [reporte final en PDF](Metodos_Numericos_Actividad_Unidad_6_20261118_AhuedCortes_M.pdf) incluye las tablas, las gráficas comparativas y las capturas de las ejecuciones en Visual Studio Code.
