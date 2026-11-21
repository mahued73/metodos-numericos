# Circuito RLC con Runge-Kutta de cuarto orden

Práctica de Métodos Numéricos: sistemas de ecuaciones diferenciales y RK4 vectorial. El programa resuelve el problema de valor inicial
`q'' + 0.4q' + q = 0`, con `q(0) = 1` y `q'(0) = 0`, mediante 25 pasos de RK4.

## Compilar y ejecutar

1. Instala un **JDK** (no solo Java Runtime) y verifica `java -version` y `javac -version`.
2. Abre una terminal en la carpeta que contiene `RK4CircuitoRLC.java`.
3. Compila y ejecuta:

```bash
javac -encoding UTF-8 RK4CircuitoRLC.java
java RK4CircuitoRLC
java RK4CircuitoRLC 0.1
java RK4CircuitoRLC 0.05
```

Sin parámetro, se usa `h = 0.2`. El argumento es un paso positivo finito, con
punto decimal. Los resultados se escriben en CSV en la terminal (26 filas de
datos por corrida: condición inicial y 25 pasos). Para reproducir los archivos:

```bash
java RK4CircuitoRLC 0.2 > resultados-h020.csv
java RK4CircuitoRLC 0.1 > resultados-h010.csv
java RK4CircuitoRLC 0.05 > resultados-h005.csv
```

Con un JDK moderno también se puede ejecutar la fuente directamente, por
ejemplo con `java RK4CircuitoRLC.java 0.2`. Si usas Windows PowerShell 5.1,
abre CMD para las redirecciones anteriores o usa `| Set-Content -Encoding ascii archivo.csv`
para evitar que `>` escriba los CSV en UTF-16.

## Archivos

- [RK4CircuitoRLC.java](RK4CircuitoRLC.java): código fuente.
- `resultados-h020.csv`, `resultados-h010.csv`, `resultados-h005.csv`: salidas reales.
- [graficar.py](graficar.py): reproduce la gráfica a partir de los CSV. Requiere
  Python con NumPy y Matplotlib; `python graficar.py` genera `grafica-rk4-rlc.png`.

## Clonar el repositorio

```bash
git clone https://github.com/mahued73/metodos-numericos.git
cd metodos-numericos/rk4-circuito-rlc
```

## Ejecutar en Visual Studio Code

1. Abre **Archivo → Abrir carpeta** y elige la carpeta que contiene este README y la subcarpeta `.vscode`.
2. Comprueba que el JDK esté en el PATH de la terminal integrada: `java -version` y `javac -version`. Si instalaste el JDK con VS Code abierto, reinicia el editor.
3. Presiona **Ctrl+Mayús+B** (o **Terminal → Ejecutar tarea de compilación**) y elige `0.2`, `0.1` o `0.05`. Se ejecuta la tarea **RLC: compilar y ejecutar**, que primero compila el archivo y luego imprime el CSV en **Terminal**. No se requiere extensión Java para esta tarea.
4. Para un paso distinto, ejecuta en la terminal integrada los comandos de la sección anterior con el valor deseado.

## Verificación

Las corridas con h = 0.20, 0.10 y 0.05 s se comprobaron en Visual Studio Code
con OpenJDK 21 y coinciden con los CSV incluidos. En t = 1 s, los errores
absolutos respectivos de la carga son 1.1500e-5, 7.0176e-7 y 4.3225e-8 C.
Se compara en el mismo tiempo porque con 25 pasos fijos el tiempo final es 25h.
