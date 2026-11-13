
import java.util.Scanner;

/**
 * Universidad CENFOTEC - SOFT-10 Estructuras de Datos.
 * Estrategia de aprendizaje: Algoritmos de ordenamiento y busqueda.
 *
 * Se utiliza un arreglo estatico de String, cuyo tamaño define el usuario.
 * Los algoritmos de ordenamiento y busqueda son metodos propios.
 */
public class Main {

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("  ALGORITMOS DE ORDENAMIENTO Y BUSQUEDA");
        System.out.println("===============================================");

        // El usuario define el tamaño y llena el arreglo.
        String[] palabrasOriginales = llenarArreglo();

        // Este arreglo almacenara los datos ordenados.
        String[] palabrasOrdenadas = null;

        int opcion;

        do {
            mostrarMenu();

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {

                case 1:
                case 2:
                case 3:
                case 4:
                case 5:

                    // Se copia el arreglo original para poder probar
                    // diferentes algoritmos sin perder los datos iniciales.
                    palabrasOrdenadas = copiarArreglo(palabrasOriginales);

                    switch (opcion) {

                        case 1:
                            ordenamientoSeleccion(palabrasOrdenadas);

                            System.out.println("\nMetodo utilizado: SELECCION");
                            System.out.println("Complejidad temporal: O(n^2).");
                            break;

                        case 2:
                            ordenamientoInsercion(palabrasOrdenadas);

                            System.out.println("\nMetodo utilizado: INSERCION");
                            System.out.println("Complejidad temporal: O(n^2) en el peor caso.");
                            System.out.println("Mejor caso: O(n).");
                            break;

                        case 3:
                            ordenamientoBurbuja(palabrasOrdenadas);

                            System.out.println("\nMetodo utilizado: BURBUJA");
                            System.out.println("Complejidad temporal: O(n^2) en el peor caso.");
                            System.out.println("Mejor caso: O(n).");
                            break;

                        case 4:
                            ordenamientoMezcla(palabrasOrdenadas);

                            System.out.println("\nMetodo utilizado: MEZCLA");
                            System.out.println("Complejidad temporal: O(n log n).");
                            break;

                        case 5:
                            ordenamientoRapido(palabrasOrdenadas);

                            System.out.println("\nMetodo utilizado: RAPIDO");
                            System.out.println("Complejidad temporal promedio: O(n log n).");
                            System.out.println("Peor caso: O(n^2).");
                            break;
                    }

                    System.out.println("\nARREGLO ORDENADO:");
                    mostrarArreglo(palabrasOrdenadas);

                    System.out.println("\nAhora puede seleccionar la opcion 6 para buscar una palabra.");
                    break;

                case 6:

                    // La busqueda binaria requiere que el arreglo este ordenado.
                    if (palabrasOrdenadas == null) {

                        System.out.println("\nPrimero debe ordenar el arreglo.");
                        System.out.println("Seleccione una opcion entre 1 y 5.");

                    } else {

                        System.out.print("\nIngrese la palabra que desea buscar: ");
                        String buscada = entrada.nextLine().trim();

                        if (buscada.isEmpty()) {

                            System.out.println("La palabra no puede estar vacia.");

                        } else {

                            int indice = busquedaBinaria(palabrasOrdenadas, buscada);

                            if (indice == -1) {

                                System.out.println("No se encontro la palabra '" + buscada + "'.");

                            } else {

                                System.out.println("\nPalabra encontrada: " + palabrasOrdenadas[indice]);
                                System.out.println("Indice del arreglo: " + indice);
                                System.out.println("Posicion para el usuario: " + (indice + 1));
                            }

                            System.out.println("Complejidad temporal: O(log n) en el peor caso.");
                        }
                    }
                    break;

                case 7:

                    System.out.println("\nARREGLO ORIGINAL:");
                    mostrarArreglo(palabrasOriginales);

                    if (palabrasOrdenadas == null) {

                        System.out.println("\nTodavia no se ha aplicado un ordenamiento.");

                    } else {

                        System.out.println("\nARREGLO ORDENADO:");
                        mostrarArreglo(palabrasOrdenadas);
                    }
                    break;

                case 8:

                    // Permite ingresar nuevamente un arreglo estatico.
                    palabrasOriginales = llenarArreglo();

                    // Se reinicia el resultado del ordenamiento anterior.
                    palabrasOrdenadas = null;

                    System.out.println("\nNuevo arreglo cargado correctamente.");
                    break;

                case 0:

                    System.out.println("\nPrograma finalizado. Hasta luego.");
                    break;

                default:

                    System.out.println("\nOpcion no valida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);

        entrada.close();
    }


    // =====================================================
    // METODO PARA LEER NUMEROS ENTEROS
    // =====================================================

    private static int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            try {

                return Integer.parseInt(entrada.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Error: debe ingresar un numero entero valido.");
            }
        }
    }


    // =====================================================
    // LLENAR ARREGLO ESTATICO
    // =====================================================

    private static String[] llenarArreglo() {

        int tamanio;

        // El tamaño del arreglo debe ser mayor que cero.
        do {

            tamanio = leerEntero("\nIndique la cantidad de palabras: ");

            if (tamanio <= 0) {

                System.out.println("Error: la cantidad debe ser mayor que cero.");
            }

        } while (tamanio <= 0);

        // Se crea un arreglo estatico del tamaño solicitado.
        String[] palabras = new String[tamanio];

        // Se solicita una palabra para cada casilla.
        for (int i = 0; i < palabras.length; i++) {

            do {

                System.out.print("Ingrese la palabra " + (i + 1) + ": ");

                palabras[i] = entrada.nextLine().trim();

                if (palabras[i].isEmpty()) {

                    System.out.println("Error: la palabra no puede estar vacia.");
                }

            } while (palabras[i].isEmpty());
        }

        System.out.println("\nArreglo cargado correctamente.");

        return palabras;
    }


    // =====================================================
    // COPIAR ARREGLO
    // =====================================================

    private static String[] copiarArreglo(String[] original) {

        String[] copia = new String[original.length];

        // Se copia cada elemento sin modificar el arreglo original.
        for (int i = 0; i < original.length; i++) {

            copia[i] = original[i];
        }

        return copia;
    }


    // =====================================================
    // MOSTRAR MENU
    // =====================================================

    private static void mostrarMenu() {

        System.out.println("\n===============================================");
        System.out.println("           MENU DE ALGORITMOS");
        System.out.println("===============================================");
        System.out.println("1. Ordenamiento por seleccion");
        System.out.println("2. Ordenamiento por insercion");
        System.out.println("3. Ordenamiento por burbuja");
        System.out.println("4. Ordenamiento por mezcla");
        System.out.println("5. Ordenamiento rapido");
        System.out.println("6. Busqueda binaria de una palabra");
        System.out.println("7. Mostrar arreglo original y ordenado");
        System.out.println("8. Ingresar un nuevo arreglo");
        System.out.println("0. Salir");
        System.out.println("===============================================");
    }


    // =====================================================
    // MOSTRAR ARREGLO
    // =====================================================

    private static void mostrarArreglo(String[] palabras) {

        for (int i = 0; i < palabras.length; i++) {

            System.out.println("[" + i + "] " + palabras[i]);
        }
    }


    // =====================================================
    // ORDENAMIENTO POR SELECCION
    // Complejidad temporal: O(n^2)
    // =====================================================

    private static void ordenamientoSeleccion(String[] palabras) {

        int n = palabras.length;

        // Se recorre el arreglo hasta la penultima posicion.
        for (int i = 0; i < n - 1; i++) {

            // Se considera inicialmente que la palabra menor
            // esta ubicada en la posicion actual.
            int menor = i;

            // Se busca la palabra alfabeticamente menor
            // en la parte que todavia no esta ordenada.
            for (int j = i + 1; j < n; j++) {

                if (palabras[j].compareToIgnoreCase(palabras[menor]) < 0) {

                    menor = j;
                }
            }

            // Se intercambia la palabra actual con la menor encontrada.
            String temporal = palabras[i];

            palabras[i] = palabras[menor];

            palabras[menor] = temporal;
        }
    }


    // =====================================================
    // ORDENAMIENTO POR INSERCION
    // Mejor caso: O(n)
    // Caso promedio y peor caso: O(n^2)
    // =====================================================

    private static void ordenamientoInsercion(String[] palabras) {

        // Se crea un arreglo auxiliar para construir
        // progresivamente la secuencia ordenada.
        String[] nuevo = new String[palabras.length];

        int cantidadInsertados = 0;

        // Se recorre cada palabra del arreglo original.
        for (int i = 0; i < palabras.length; i++) {

            // Se determina la siguiente posicion disponible.
            int posicionInsertar = cantidadInsertados;

            // Mientras existan palabras mayores a la actual,
            // se desplazan una casilla hacia la derecha.
            while (posicionInsertar > 0
                    && nuevo[posicionInsertar - 1].compareToIgnoreCase(palabras[i]) > 0) {

                nuevo[posicionInsertar] = nuevo[posicionInsertar - 1];

                posicionInsertar--;
            }

            // Se coloca la palabra en su posicion correspondiente.
            nuevo[posicionInsertar] = palabras[i];

            cantidadInsertados++;
        }

        // Se copia el resultado ordenado al arreglo recibido.
        for (int i = 0; i < palabras.length; i++) {

            palabras[i] = nuevo[i];
        }
    }


    // =====================================================
    // ORDENAMIENTO POR BURBUJA
    // Mejor caso: O(n)
    // Caso promedio y peor caso: O(n^2)
    // =====================================================

    private static void ordenamientoBurbuja(String[] palabras) {

        // El ciclo externo controla las pasadas.
        for (int i = 0; i < palabras.length - 1; i++) {

            boolean huboIntercambio = false;

            // Se comparan palabras que estan en posiciones consecutivas.
            // La ultima casilla de cada pasada ya queda ordenada.
            for (int j = 0; j < palabras.length - 1 - i; j++) {

                // Se intercambian si estan en orden incorrecto.
                if (palabras[j].compareToIgnoreCase(palabras[j + 1]) > 0) {

                    String temporal = palabras[j];

                    palabras[j] = palabras[j + 1];

                    palabras[j + 1] = temporal;

                    huboIntercambio = true;
                }
            }

            // Si no se realizaron intercambios,
            // significa que el arreglo ya esta ordenado.
            if (!huboIntercambio) {

                break;
            }
        }
    }


    // =====================================================
    // ORDENAMIENTO POR MEZCLA (MERGE SORT)
    // Complejidad temporal: O(n log n)
    // =====================================================

    private static void ordenamientoMezcla(String[] palabras) {

        // Se crea un arreglo auxiliar para combinar las mitades.
        String[] auxiliar = new String[palabras.length];

        ordenarMitades(palabras, auxiliar, 0, palabras.length - 1);
    }


    // Subrutina recursiva para dividir el arreglo.
    private static void ordenarMitades(String[] palabras, String[] auxiliar,
                                       int izquierda, int derecha) {

        // Caso base: si hay cero o una palabra, ya esta ordenada.
        if (izquierda >= derecha) {

            return;
        }

        // Se calcula el punto medio del segmento.
        int medio = izquierda + (derecha - izquierda) / 2;

        // Se ordena la mitad izquierda.
        ordenarMitades(palabras, auxiliar, izquierda, medio);

        // Se ordena la mitad derecha.
        ordenarMitades(palabras, auxiliar, medio + 1, derecha);

        // Se combinan ambas mitades en orden alfabetico.
        mezclar(palabras, auxiliar, izquierda, medio, derecha);
    }


    // Subrutina que combina las dos mitades ordenadas.
    private static void mezclar(String[] palabras, String[] auxiliar,
                                int izquierda, int medio, int derecha) {

        int i = izquierda;

        int j = medio + 1;

        int k = izquierda;

        // Se comparan las primeras palabras disponibles
        // de ambas mitades y se copia la menor al auxiliar.
        while (i <= medio && j <= derecha) {

            if (palabras[i].compareToIgnoreCase(palabras[j]) <= 0) {

                auxiliar[k] = palabras[i];

                i++;

            } else {

                auxiliar[k] = palabras[j];

                j++;
            }

            k++;
        }

        // Se copian las palabras restantes de la mitad izquierda.
        while (i <= medio) {

            auxiliar[k] = palabras[i];

            i++;

            k++;
        }

        // Se copian las palabras restantes de la mitad derecha.
        while (j <= derecha) {

            auxiliar[k] = palabras[j];

            j++;

            k++;
        }

        // Se devuelve la parte ordenada al arreglo original.
        for (int posicion = izquierda; posicion <= derecha; posicion++) {

            palabras[posicion] = auxiliar[posicion];
        }
    }


    // =====================================================
    // ORDENAMIENTO RAPIDO (QUICK SORT)
    // Caso promedio: O(n log n)
    // Peor caso: O(n^2)
    // =====================================================

    private static void ordenamientoRapido(String[] palabras) {

        ordenarRapidoRecursivo(palabras, 0, palabras.length - 1);
    }


    // Subrutina recursiva que ordena las particiones.
    private static void ordenarRapidoRecursivo(String[] palabras,
                                               int izquierda, int derecha) {

        // Caso base: un segmento con cero o una palabra ya esta ordenado.
        if (izquierda >= derecha) {

            return;
        }

        // Se obtiene la posicion definitiva del pivote.
        int indicePivote = particionar(palabras, izquierda, derecha);

        // Se ordenan las palabras anteriores al pivote.
        ordenarRapidoRecursivo(palabras, izquierda, indicePivote - 1);

        // Se ordenan las palabras posteriores al pivote.
        ordenarRapidoRecursivo(palabras, indicePivote + 1, derecha);
    }


    // Subrutina encargada de realizar la particion.
    private static int particionar(String[] palabras, int izquierda, int derecha) {

        // Se selecciona la ultima palabra como pivote.
        String pivote = palabras[derecha];

        int posicionMenores = izquierda;

        // Se recorren las palabras anteriores al pivote.
        for (int j = izquierda; j < derecha; j++) {

            // Las palabras menores o iguales al pivote
            // se colocan en la parte izquierda.
            if (palabras[j].compareToIgnoreCase(pivote) <= 0) {

                String temporal = palabras[posicionMenores];

                palabras[posicionMenores] = palabras[j];

                palabras[j] = temporal;

                posicionMenores++;
            }
        }

        // Se ubica el pivote en su posicion definitiva.
        String temporal = palabras[posicionMenores];

        palabras[posicionMenores] = palabras[derecha];

        palabras[derecha] = temporal;

        return posicionMenores;
    }


    // =====================================================
    // BUSQUEDA BINARIA
    // Mejor caso: O(1)
    // Peor caso: O(log n)
    // =====================================================

    private static int busquedaBinaria(String[] palabras, String buscada) {

        // La busqueda binaria requiere un arreglo ordenado.
        int limiteInferior = 0;

        int limiteSuperior = palabras.length - 1;

        // Se repite mientras exista una seccion donde buscar.
        while (limiteInferior <= limiteSuperior) {

            // Se calcula la posicion central de la seccion.
            int medio = limiteInferior + (limiteSuperior - limiteInferior) / 2;

            // Se compara la palabra buscada con la palabra central.
            int comparacion = buscada.compareToIgnoreCase(palabras[medio]);

            if (comparacion == 0) {

                // La palabra fue encontrada.
                return medio;

            } else if (comparacion < 0) {

                // Si la palabra buscada es menor,
                // se descarta la mitad derecha.
                limiteSuperior = medio - 1;

            } else {

                // Si la palabra buscada es mayor,
                // se descarta la mitad izquierda.
                limiteInferior = medio + 1;
            }
        }

        // Se devuelve -1 cuando la palabra no existe.
        return -1;
    }
}
