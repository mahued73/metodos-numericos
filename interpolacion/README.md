# Interpolación de Lagrange y Newton

El programa evalúa ambos métodos con los nodos (0, 1), (2, 7) y (4, 21), en x = 3. También muestra la tabla de diferencias divididas de Newton. Los dos métodos dan 13, que coincide con x² + x + 1 en ese punto.

Se probó con JDK 21. Se puede usar Visual Studio Code con soporte para Java o compilar desde la terminal.

## Compilar y ejecutar

Abre una terminal en la carpeta del proyecto.

```powershell
javac -encoding UTF-8 -d out src/interpolacion/Main.java src/interpolacion/InterpolacionLagrange.java src/interpolacion/InterpolacionNewton.java
java -cp out interpolacion.Main
```

En Visual Studio Code, abre la carpeta del proyecto y ejecuta `src/interpolacion/Main.java`.

La clase de Newton conserva los métodos del [proyecto del profesor](https://github.com/victorvasher/M-todos-N-mericos-ITSX/tree/main/Interpolaci%C3%B3n). La clase de Lagrange completa el producto indicado en la práctica.
