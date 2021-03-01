//Cifrado de Vigenere
import java.io.*;

class CVigenere {
  public static void main(String[] args) { 
    
    InputStreamReader isr;
    BufferStreamReader tcld;

    String linea;
    isr = new InputStreamReader(System.in);
    /tcld = new BufferStreamReader(isr);

    System.out.println("Introduce la clave : \n");
    linea = isr.readLine();
    
    //NO String str = "GEEKSFORGEEKS";

    // NO String keyword = "AYUSH"; 
  
    //String key = generateKey(str, keyword); 
    //String cipher_text = cipherText(str, key); 
  
    System.out.println("Clave puesta : " + linea + "\n"); 
  
    //System.out.println("Original/Decrypted Text : " + originalText(cipher_text, key));  
  }
} 