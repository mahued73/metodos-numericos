# Simpson 1/3 Compuesto

Práctica de Métodos Numéricos para comparar la Regla del Trapecio Compuesto con la Regla de Simpson 1/3 Compuesta usando el mismo intervalo y tolerancia.

## Datos de prueba

- Función: f(x) = x^2
- Intervalo: [0, 2]
- Tolerancia: 0.0001
- n inicial: 2

## Estructura

```text
src/dif_e_Integracion/
├── TrapecioCompuesto.java
├── SimpsonCompuesto.java
└── Main.java
```

## Compilar y ejecutar

Desde la raíz del proyecto:

```bash
mkdir -p out
javac -d out src/dif_e_Integracion/*.java
java -cp out dif_e_Integracion.Main
```

En Windows PowerShell también puede usarse:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out src/dif_e_Integracion/*.java
java -cp out dif_e_Integracion.Main
```

## Resultado esperado

Trapecio Compuesto alcanza la tolerancia después de 7 refinamientos, con n = 256 y una aproximación de 2.666687.

Simpson 1/3 Compuesto alcanza el criterio después de 1 refinamiento, con n = 4 y una aproximación de 2.666667.

El valor exacto de la integral de x^2 en [0,2] es 8/3 = 2.6666666667.
