/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;
import compilador.Lexico;

/**
 *
 * @author kevb6
 */

public class Lexico {
    
     int contador = 0;
    String validar = "";

    
    public String Parseo(){
        Leer lee = new Leer();
        
        for(String parseo :lee.leer()){  //para hacer string el array
            validar += parseo;
        }
        
        return validar;
    }
    
    public String Token(){
        
        char x; //para concatenar 
        String cad = ""; //va a ir guardando las validaciones

        x = validar.charAt(contador);//va analizando el String y guardarlo en X
        
   
        /*
            Se anida el primer if en el que valida que el primer caracter sea V
            entonces una vez validado entra a otro if para validar que el siguiente
            caracter sea A, cumpliendo esas dos condiciones entra a un tercer if
            en donde validaria el resto de la expresión
        
            ASCII de V = 86 y A = 65
            En el caso de nuestra expresión:
             VA ( [A - Z] | [a - z ] | [0 - 9] )*
        */
        
        if(x == 86){
            cad += x; //almacena V
            contador++;
            x = validar.charAt(contador);
            
            if(x == 65){
                cad += x; //almacena A
                contador++;
                x = validar.charAt(contador);
                
                while((x >= 65 && x <= 90) || (x >= 97 && x <= 122) || (x >= 48 && x <= 57)){
  
                    if(x >= 65 && x <= 90){ //El 65 es de "A" y 90 es "Z"
                        cad += x; //almacena que sea A a Z
                        contador++;
                        x = validar.charAt(contador);
                    
                    }else if(x >= 97 && x <= 122){ //El 97 es de "a" y 122 es "z"
                        cad += x; //almacena que sea "a" a "z"
                        contador++;
                        x = validar.charAt(contador);

                    }else if(x >= 48 && x <= 57){ //El 48 es de "0" y 57 de "9"
                        cad += x; //almacena que sea 0 a 9
                        contador++;
                        x = validar.charAt(contador);
                    }
                }
                
            }
                       
        }else if(x >= 48 && x <= 57){
            cad += x; //almacena que sea 0 a 9
            contador++;
            x = validar.charAt(contador);
            
            while(x >= 48 && x <= 57){
                cad += x; //almacena que sea 0 a 9
                contador++;
                x = validar.charAt(contador);

            }if(x == 46){
                contador++;
                x = validar.charAt(contador);
                
                if(x >= 48 && x <= 57){
                    cad += '.'; //concatena punto
                    cad += x; //almacena que sea 0 a 9
                    contador++;
                    x = validar.charAt(contador);
                    
                    while(x >= 48 && x <= 57){
                        cad += x; //almacena que sea 0 a 9
                        contador++;
                        x = validar.charAt(contador);
                    }
                }else contador--;
            }
            
        }else{
            cad += x; //para que retorne cualquier simbolo o caracter
            contador++;
        }
        return cad;
    }
    
        public static void main(String[] args) {
        Lexico analizador = new Lexico();
        analizador.Parseo();
        
        System.out.println(""+analizador.Token());
            System.out.println(""+analizador.Token()); //espacio en blanco
        System.out.println(""+analizador.Token());
            System.out.println(""+analizador.Token()); //espacio en blanco
        System.out.println(""+analizador.Token());
            System.out.println(""+analizador.Token()); //espacio en blanco
        System.out.println(""+analizador.Token());     
            System.out.println(""+analizador.Token()); //espacio en blanco
    }
}
