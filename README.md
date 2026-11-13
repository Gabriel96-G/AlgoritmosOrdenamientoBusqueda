
# Algoritmos de Ordenamiento y Búsqueda

## Descripción

Proyecto académico desarrollado en Java para el curso SOFT-10 - Estructuras de Datos de la Universidad CENFOTEC.

El programa permite ingresar un arreglo estático de cadenas de texto (`String[]`), aplicar diferentes algoritmos de ordenamiento y realizar búsquedas binarias sobre los datos ordenados.

## Algoritmos implementados

El proyecto incluye cinco algoritmos de ordenamiento:

1. Ordenamiento por selección (Selection Sort).
2. Ordenamiento por inserción (Insertion Sort).
3. Ordenamiento por burbuja (Bubble Sort).
4. Ordenamiento por mezcla (Merge Sort).
5. Ordenamiento rápido (Quick Sort).

También incluye el algoritmo de búsqueda binaria (Binary Search).

## Complejidad temporal

| Algoritmo | Mejor caso | Caso promedio | Peor caso |
|---|---|---|---|
| Selección | O(n²) | O(n²) | O(n²) |
| Inserción | O(n) | O(n²) | O(n²) |
| Burbuja | O(n) | O(n²) | O(n²) |
| Mezcla | O(n log n) | O(n log n) | O(n log n) |
| Rápido | O(n log n) | O(n log n) | O(n²) |
| Búsqueda binaria | O(1) | O(log n) | O(log n) |

## Funcionalidades

- Ingreso de palabras mediante un arreglo estático.
- Selección del algoritmo de ordenamiento.
- Ordenamiento alfabético sin distinguir mayúsculas y minúsculas.
- Búsqueda binaria después de ordenar el arreglo.
- Visualización del arreglo original y del arreglo ordenado.
- Ingreso de nuevos arreglos.
- Validación de entradas incorrectas y palabras vacías.
- Visualización de la complejidad temporal de los algoritmos.

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Git y GitHub

## Ejecución del programa

1. Clonar o descargar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Abrir el archivo `src/Main.java`.
4. Ejecutar el método `main`.
5. Ingresar la cantidad de palabras y los valores solicitados.
6. Seleccionar una opción del menú.

Para realizar una búsqueda binaria, primero debe ejecutarse uno de los algoritmos de ordenamiento.

## Pruebas funcionales

Se completaron 21 pruebas manuales en IntelliJ IDEA para verificar las operaciones principales, los algoritmos, la búsqueda binaria y diferentes validaciones de entrada.

## Estructura del proyecto

```text
AlgoritmosOrdenamientoBusqueda/
├── src/
│   └── Main.java
├── README.md
└── .gitignore
```

## Información académica

**Universidad:** CENFOTEC

**Curso:** SOFT-10 - Estructuras de Datos

**Lenguaje:** Java

**Repositorio:** https://github.com/Gabriel96-G/AlgoritmosOrdenamientoBusqueda

## Autor

Alejandro Gabriel Medrano Ruiz

