/********************************************************************
* @author Andrea Calero Caro
* Alu: 0101202952
* Práctica 1: Cifrado de Vigenere
* Asignatura: Seguridad en Sistemas Informáticos
* Universidad de La Laguna 
********************************************************************/

// Librería para la lectura por teclado con la clase Scanner
import java.util.Scanner;

// Clase que tendrá el cifrado Vigenere
class CVigenere { 

// Función que genera la clave de manera cíclica por su tamaño
// hasta que su longitud sea igual a la longitud del texto original
public static String generateKey(String message, String key) { 
  for (int i = 0; i < message.length() ; i++) { 
    if (message.length() == i) {
      i = 0; 
    } // Si la longitud de la clave es igual al tamaño del texto terminamos de repetir
      // cíclicamente la clave
    if (key.length() == message.length()) { 
      break; 
    }
    // charAt nos devuelve el char del índice que queremos analizar
    // @return caracter por caracter
    key+= (key.charAt(i)); 
  } 
  return key; 
} 
  
// Función que encripta el mensaje pasándole la clave repetida
// cíclicamente como el tamaño del mensaje
public static String encryptedMessage(String message, String key) { 
  String encrypted_message=""; 
  for (int i = 0; i < message.length(); i++) { 
    int index_m = message.charAt(i);
    int index_k = key.charAt(i);
    // Leemos el mensaje, trabajamos con cada índice de él y de la clave 
    // de los cuales sumamos ambos índices o posiciones en el alfabeto
    // A->1,B->2...Z->26, sin contar la Ñ, realizamos el algoritmo "(Mi + ki) (mod m)"
    // Mi = Cada caracter del mensaje
    // ki = Cada caracter de la clave
    // m = letras totales del alfabeto
    // Finalmente sumamos la A para convertirlo en el alfabeto ASCII
    // que sea en mayúsculas de lo contrario Java no lo reconocería
    // suma acumulada de la conversión de int -> char -> string
    // @return el mensaje encriptado
    encrypted_message += (char)((index_m + index_k) %26 + 'A');
  } 
  return encrypted_message; 
} 
  
// Función que por el mismo método similar de antes desencripta un mensaje y retorna el original 
public static String decryptedMessage(String encrypted_message, String key) { 
  String decrypted_message=""; 
  // Esta vez recorremos el mensaje encriptado y el tamaño de la clave
  for (int i = 0 ; i < encrypted_message.length() &&  i < key.length(); i++) { 
    int index_m = encrypted_message.charAt(i);
    int index_k = key.charAt(i);
    // Al leerlo en vez de sumar los índices o posiciones de las letras
    // en el abecedario, del mensaje encriptado y la clave, se RESTA y para evitar números
    // negativos se suma por la cantidad de letras del abecedario, y como antes se hace 
    // el módulo y señalizamos la A como primer caracter desde el que empieza el 
    // abecedario en ASCII y así convertirlo
    // @return el mensaje desencriptado a partir del encriptado
    decrypted_message += (char)(((index_m - index_k) + 26) %26 + 'A');
  } 
  return decrypted_message; 
} 
  

public static void main(String[] args) { 
  // Guardamos en variables tipo string el mensaje y la clave que pediremos
  String message; 
  String keyword; 
  // Necesario para alguna modificación, no usado ahora
  String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
  // Instancia keyboard que pertenece a la clase Scanner y es para la entrada
  // por teclado
  Scanner keyboard = new Scanner(System.in);

  // Lo que se escribe por teclado se guarda en las variables string
  // que tendrán el mensaje y la clave a cifrar
  System.out.print("Cifrado de Vigenere");
  System.out.print("\n**************************");
  System.out.print("\nIntroduzca el mensaje a encriptar: ");
  message = keyboard.nextLine();
  System.out.print("Introduzca la clave: ");
  keyword = keyboard.nextLine();
  
  // Guardamos en variables nuevas string la clave repetida ciclicamente
  // y el mensaje encriptado pues se necesita posteriormente
  String key = generateKey(message, keyword); 
  String encrypted_message = encryptedMessage(message, key); 

  // Comprobación que se repite correctamente la clave
  System.out.println("\n########################");
  System.out.println("Clave repetida cíclicamente tamaño del mensaje: " + key);
  System.out.println("########################\n");

  // Se muestra el mensaje original, el encriptado y su desencriptación a partir del
  // encriptado llamando así a las funciones encryptedMessage() y decryptedMessage()
  System.out.println("Mensaje original: " + message + "\n"); 
  System.out.println("Mensaje cifrado: " + encrypted_message + "\n"); 
  System.out.println("Mensaje desencriptado: " + decryptedMessage(encrypted_message, key)); /*encrypted_message"*/
  } 

} // Fin de la clase CVigenere
