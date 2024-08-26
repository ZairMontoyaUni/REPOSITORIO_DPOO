package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros()
    {
        return arregloEnteros.clone();
    }


    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas()
    {
        return arregloCadenas.clone();
    }


    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros() {
        return arregloEnteros.length;
    }



    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	if (arregloCadenas == null) {
            return 0; // Retorna 0 si el arreglo es null
        }
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    
	public void agregarEntero( int entero )
    {
    	int[] nuevodato = new int[arregloEnteros.length + 1];
    	
    	for (int  i = 0 ; i < arregloEnteros.length ; i++ ) {
    	
    		nuevodato[i] = arregloEnteros[i];
    	}
    	nuevodato[nuevodato.length - 1] = entero;
    	
    	arregloEnteros = nuevodato;
    	
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] nuevodato = new String[arregloCadenas.length + 1];
		    	
		    	for (int  i = 0 ; i < arregloCadenas.length ; i++ ) {
		    	
		    		nuevodato[i] = arregloCadenas[i];
		    	}
		    	nuevodato[nuevodato.length - 1] = cadena;
		    	
		    	arregloCadenas = nuevodato;
	}

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int counter = contarApariciones(valor) ;
    			
    	
    	
		int[] nuevodato = new int[arregloEnteros.length-counter];
		    	
				
		    	for (int i = 0, k = 0; i < arregloEnteros.length; i++) {
		    	    if (arregloEnteros[i] == valor) {
		    	        continue; // Saltamos el índice del elemento que queremos eliminar
		    	    }
		    	    nuevodato[k++] = arregloEnteros[i];
		    	}
	   arregloEnteros = nuevodato;
	   
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int counter = contarApariciones(cadena) ;
		
    	
    	
    	
    	String[] nuevodato = new String[arregloCadenas.length- counter];
    	
    	for (int i = 0, k = 0; i < arregloCadenas.length; i++) {
    	    if (arregloCadenas[i] == cadena) {
    	        continue; // Saltamos el índice del elemento que queremos eliminar
    	    }
    	    nuevodato[k++] = arregloCadenas[i];
    	}
    	
    	arregloCadenas = nuevodato;
    	
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
 
    public void insertarEntero(int entero, int posicion) {
        // Crear un nuevo arreglo con tamaño incrementado
        int[] nuevoArreglo = new int[arregloEnteros.length + 1];
        
        // Determinar la posición de inserción
        int pos = Math.max(0, Math.min(posicion, arregloEnteros.length));
        
        // Copiar los elementos antes de la posición de inserción
        System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, pos);
        
        // Insertar el nuevo valor en la posición calculada
        nuevoArreglo[pos] = entero;
        
        // Copiar los elementos después de la posición de inserción
        System.arraycopy(arregloEnteros, pos, nuevoArreglo, pos + 1, arregloEnteros.length - pos);
        
        // Actualizar el arreglo original
        arregloEnteros = nuevoArreglo;
    }



    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion(int posicion) {
        
        if (posicion < 0 || posicion >= arregloEnteros.length) {
            return;
        }

       
        int[] nuevodato = new int[arregloEnteros.length - 1];

        
        for (int i = 0, j = 0; i < arregloEnteros.length; i++) {
            if (i != posicion) {
                nuevodato[j++] = arregloEnteros[i];
            }
        }

        
        arregloEnteros = nuevodato;
    }


    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros(double[] valores) {
        // Crear un nuevo arreglo de enteros con el mismo tamaño que el arreglo de valores
        arregloEnteros = new int[valores.length];
        
        // Recorrer el arreglo de valores y convertir cada uno a entero truncando la parte decimal
        for (int i = 0; i < valores.length; i++) {
            // Convertir el valor decimal a entero truncando la parte decimal
            arregloEnteros[i] = (int) valores[i]; // O puedes usar (int) valores[i] para truncar directamente
        }
    }


    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas(Object[] objetos) {
        // Crear un nuevo arreglo de cadenas con el mismo tamaño que el arreglo de objetos
        arregloCadenas = new String[objetos.length];
        
        // Recorrer el arreglo de objetos y convertir cada uno a cadena usando toString()
        for (int i = 0; i < objetos.length; i++) {
            // Convertir el objeto a cadena usando toString() y asignar al nuevo arreglo
            arregloCadenas[i] = objetos[i].toString();
        }
    }


    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos() {
        // Recorrer el arreglo de enteros
        for (int i = 0; i < arregloEnteros.length; i++) {
            // Si el valor es negativo, convertirlo a positivo
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] = -arregloEnteros[i];
            }
        }
    }


    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros() {
        quickSort(arregloEnteros, 0, arregloEnteros.length - 1);
    }

    // Método Quick Sort
    private void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particionar(arreglo, inicio, fin);
            quickSort(arreglo, inicio, pivote - 1);
            quickSort(arreglo, pivote + 1, fin);
        }
    }

    // Método para particionar el arreglo
    private int particionar(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[fin];
        int i = (inicio - 1);
        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                // Intercambiar arreglo[i] y arreglo[j]
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        // Intercambiar arreglo[i + 1] y arreglo[fin] (pivote)
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;
        return i + 1;
    }



    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas() {
        if (arregloCadenas == null || arregloCadenas.length <= 1) {
            return; // No hace falta ordenar si el arreglo es nulo o tiene 0 o 1 elementos
        }

        quickSort(arregloCadenas, 0, arregloCadenas.length - 1);
    }

    // Método Quick Sort
    private void quickSort(String[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particionar(arreglo, inicio, fin);
            quickSort(arreglo, inicio, pivote - 1);
            quickSort(arreglo, pivote + 1, fin);
        }
    }

    // Método para particionar el arreglo
    private int particionar(String[] arreglo, int inicio, int fin) {
        String pivote = arreglo[fin];
        int i = (inicio - 1);
        for (int j = inicio; j < fin; j++) {
            if (arreglo[j].compareTo(pivote) <= 0) {
                i++;
                // Intercambiar arreglo[i] y arreglo[j]
                String temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        // Intercambiar arreglo[i + 1] y arreglo[fin] (pivote)
        String temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;
        return i + 1;
    }


    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int counter=0;
    	
    	for (int i = 0, k = 0; i < arregloEnteros.length; i++) {
    	    if (arregloEnteros[i] == valor) {
    	    	
    	    	k++;
    	    	counter = k;
    	        continue; // Saltamos el índice del elemento que queremos eliminar
    	    }
    	
    	}
    	
        return counter;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones(String cadena) {
        int counter = 0;
        
        // Convertir la cadena de búsqueda a minúsculas para una comparación insensible a mayúsculas/minúsculas
        String cadenaBusqueda = cadena.toLowerCase();
        
        // Recorrer el arreglo de cadenas
        for (String str : arregloCadenas) {
            // Convertir cada cadena del arreglo a minúsculas y comparar
            if (str != null && str.toLowerCase().equals(cadenaBusqueda)) {
                counter++;
            }
        }
        
        return counter;
    }


    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int counter = contarApariciones(valor);
    	
    	int[] indices = new int[counter]; 
    	
    	for (int i = 0, k=0; i < arregloEnteros.length && counter !=0; i++) {
    	    if (arregloEnteros[i] == valor) {
    	    	
    	    	indices[k] = i ;
    	    	k++;	
    	        continue; // Saltamos el índice del elemento que queremos eliminar
    	    }
    	
    	}

        return indices;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros() {
        // Verificar si el arreglo está vacío
        if (arregloEnteros == null || arregloEnteros.length == 0) {
            return new int[0]; // Retorna un arreglo vacío
        }
        
        // Inicializar las variables para el valor mínimo y máximo
        int min = arregloEnteros[0];
        int max = arregloEnteros[0];
        
        // Recorrer el arreglo para encontrar el valor mínimo y máximo
        for (int i = 1; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < min) {
                min = arregloEnteros[i];
            }
            if (arregloEnteros[i] > max) {
                max = arregloEnteros[i];
            }
        }
        
        // Devolver un arreglo con el valor mínimo en la primera posición y el valor máximo en la segunda
        return new int[]{min, max};
    }


    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    
    public HashMap<Integer, Integer> calcularHistograma() {
        // Crear un HashMap para almacenar el histograma
        HashMap<Integer, Integer> histograma = new HashMap<>();
        
        // Verificar si el arreglo está vacío o es null
        if (arregloEnteros == null) {
            return histograma; // Retorna un mapa vacío
        }
        
        // Recorrer el arreglo de enteros
        for (int numero : arregloEnteros) {
            // Si el número ya está en el mapa, incrementar su contador
            if (histograma.containsKey(numero)) {
                histograma.put(numero, histograma.get(numero) + 1);
            } else {
                // Si el número no está en el mapa, agregarlo con un contador de 1
                histograma.put(numero, 1);
            }
        }
        
        // Devolver el HashMap con el histograma
        return histograma;
    }


    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos() {
        // Crear un HashMap para almacenar la frecuencia de cada valor
        HashMap<Integer, Integer> frecuencias = new HashMap<>();
        
        // Verificar si el arreglo está vacío o es null
        if (arregloEnteros == null || arregloEnteros.length == 0) {
            return 0; // Retorna 0 si el arreglo está vacío o es null
        }
        
        // Contar la frecuencia de cada valor en el arreglo
        for (int numero : arregloEnteros) {
            frecuencias.put(numero, frecuencias.getOrDefault(numero, 0) + 1);
        }
        
        // Contar cuántos valores tienen una frecuencia mayor a 1
        int conteoRepetidos = 0;
        for (int frecuencia : frecuencias.values()) {
            if (frecuencia > 1) {
                conteoRepetidos++;
            }
        }
        
        return conteoRepetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros(int[] otroArreglo) {
        // Verificar si ambos arreglos son null
        if (arregloEnteros == null && otroArreglo == null) {
            return true;
        }
        
        // Verificar si uno de los arreglos es null y el otro no
        if (arregloEnteros == null || otroArreglo == null) {
            return false;
        }
        
        // Verificar si los arreglos tienen la misma longitud
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
        
        // Comparar los elementos de ambos arreglos
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != otroArreglo[i]) {
                return false; // Si encontramos un elemento diferente, los arreglos no son iguales
            }
        }
        
        return true; // Si todos los elementos son iguales, los arreglos son iguales
    }


    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros(int[] otroArreglo) {
        // Verificar si ambos arreglos son null
        if (arregloEnteros == null && otroArreglo == null) {
            return true;
        }
        
        // Verificar si uno de los arreglos es null y el otro no
        if (arregloEnteros == null || otroArreglo == null) {
            return false;
        }
        
        // Verificar si los arreglos tienen la misma longitud
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
        
        // Contar las frecuencias de los elementos en el primer arreglo
        HashMap<Integer, Integer> frecuencia1 = new HashMap<>();
        for (int numero : arregloEnteros) {
            frecuencia1.put(numero, frecuencia1.getOrDefault(numero, 0) + 1);
        }
        
        // Contar las frecuencias de los elementos en el segundo arreglo
        HashMap<Integer, Integer> frecuencia2 = new HashMap<>();
        for (int numero : otroArreglo) {
            frecuencia2.put(numero, frecuencia2.getOrDefault(numero, 0) + 1);
        }
        
        // Comparar las dos frecuencias
        return frecuencia1.equals(frecuencia2);
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros(int cantidad, int minimo, int maximo) {
        // Verificar que la cantidad sea positiva y que mínimo sea menor que máximo
        if (cantidad <= 0 || minimo >= maximo) {
            throw new IllegalArgumentException("Cantidad debe ser positiva y mínimo debe ser menor que máximo.");
        }

        // Inicializar el arreglo de enteros con la cantidad especificada
        arregloEnteros = new int[cantidad];
        
        // Generar números aleatorios en el rango [mínimo, máximo]
        for (int i = 0; i < cantidad; i++) {
            // Math.random() devuelve un valor entre 0.0 (inclusive) y 1.0 (exclusivo)
            // Para ajustar esto a un rango entre mínimo y máximo, usamos la fórmula:
            // (int)(Math.random() * (maximo - minimo + 1)) + minimo
            arregloEnteros[i] = (int)(Math.random() * (maximo - minimo + 1)) + minimo;
        }
    }


}
