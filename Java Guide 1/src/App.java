import java.util.Scanner; // Importamos la clase Scanner para leer la entrada del usuario

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos un objeto Scanner para leer la entrada del usuario
        boolean EntradaValida = false; // Creamos un boolean para verificar si la entrada del usuario es válida

        while (!EntradaValida) { // Comenzamos un bucle que se ejecutará hasta que la entrada del usuario sea válida
            System.out.println("Ingrese la cantidad de números impares (entre 3 y 15):"); // Pedimos al usuario que ingrese la cantidad de números 
            int n = scanner.nextInt(); // Leemos la cantidad de números ingresados por el usuario
            
            if (n >= 3 && n <= 15 && n % 2 != 0) { // Verificamos si la cantidad de números está dentro del rango permitido y si es impar
                EntradaValida = true; // Si la entrada es válida, cambiamos el valor del boolean a true

                int[] nums = new int[n]; // Creamos un arreglo para almacenar los números ingresados por el usuario
                System.out.println("Ingrese los números:"); // Pedimos al usuario que ingrese los números
                for (int i = 0; i < n; i++) { // Comenzamos un bucle para leer cada número ingresado por el usuario
                    nums[i] = scanner.nextInt(); // Leemos y almacenamos cada número en el arreglo
                }

                try {
                    int median = EncontrarMedio(nums); // Llamamos a la función EncontrarMedio para encontrar la mediana de los números ingresados
                    System.out.println("Los números ordenados son:"); // Mostramos un mensaje indicando que se mostrarán los números ordenados de menor a mayor
                    for (int num : nums) { // Comenzamos un bucle para imprimir cada número ordenado
                        System.out.print(num + " "); // Imprimimos cada número seguido de un espacio
                    }
                    System.out.println("\nLa mediana es " + median); // Mostramos la mediana 
                } catch (IllegalArgumentException e) { // Capturamos cualquier excepción lanzada por la función EncontrarMedio
                    System.out.println(e.getMessage()); // Imprimimos el mensaje de la excepción
                }
            } else { // Si la cantidad de números ingresada no está dentro del rango permitido o no es impar
                System.out.println("La cantidad de números ingresada no está dentro del rango permitido o no es impar."); // Mostramos un mensaje de error
            }
        }
    }

    public static int EncontrarMedio(int[] nums) { // Función para encontrar la mediana de un arreglo de números
        insertionSort(nums); // Llamamos a la función insertionSort para ordenar los números
        int n = nums.length; // Obtenemos la longitud del arreglo de números
        return nums[n / 2]; // Devolvemos el elemento en la posición central, que es la mediana
    }

    public static void insertionSort(int[] arr) { // Función para ordenar un arreglo de números usando el algoritmo de inserción
        int n = arr.length; // Obtenemos la longitud del arreglo
        for (int i = 1; i < n; ++i) { // Comenzamos un bucle para recorrer todos los elementos del arreglo
            int key = arr[i]; // Guardamos el valor del elemento actual
            int j = i - 1; // Creamos un índice para comparar con los elementos anteriores

            while (j >= 0 && arr[j] > key) { // Comenzamos un bucle para mover los elementos mayores que el valor actual a la derecha
                arr[j + 1] = arr[j]; // Movemos el elemento a la derecha
                j = j - 1; // Decrementamos el índice para comparar con el siguiente elemento
            }
            arr[j + 1] = key; // Insertamos el valor actual en su posición correcta en el arreglo ordenado
        }
    }
}