/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author kevb6
 */
public class Leer {
    
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    int a;
    int buff;
    String cadena = new String();
    String texto = "";

    
    public ArrayList<String> leer(){//metodo para leer caracter por caracter un txt 
        String linea;
        ArrayList <String>cade = new ArrayList<>();
     try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("texto.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         
         int caract = fr.read();
         
         // Lectura del fichero
         while(caract != -1) { 
                //Mostrar en pantalla el carácter leído convertido a char
                // Esta el la línea donde nos muestra el código ASCII   
                //System.out.println(caract); 
                //System.out.println((char)caract);
          
                 linea = Character.toString((char)caract);
                cade.add(linea);        
                //System.out.println(cade);
        
                caract = fr.read();            
            }
      }
       catch (FileNotFoundException e) {
            //Operaciones en caso de no encontrar el fichero
            System.out.println("Error: Fichero no encontrado");
            //Mostrar el error producido por la excepción
            System.out.println(e.getMessage());
        }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
         return cade; 
   }  

    
    public static void main(String[] args) {
        Leer lex = new Leer();
        
        System.out.println(""+lex.leer());
    }
    
}
