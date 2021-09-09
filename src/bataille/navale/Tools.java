/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille.navale;

/**
 *
 * @author paulw
 */
public class Tools {
    public static char intToChar(int nombre) {
        switch(nombre) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
            case 8:
                return 'I';
            case 9:
                return 'J';
            case 10:
                return 'K';
            case 11:
                return 'L';
            case 12:
                return 'M';
            case 13:
                return 'N';
            case 14:
                return 'O';
        }
        return 'e';
    }
    
    public static int charToInt(char lettre) {
        switch(lettre) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            case 'I':
                return 8;
            case 'J':
                return 9;
            case 'K':
                return 10;
            case 'L':
                return 11;
            case 'M':
                return 12;
            case 'N':
                return 13;
            case 'O':
                return 14;
        }
        return -1;
        
    }
    
     public static void cls() {
	try{	
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
	} catch(Exception E) {
            System.out.println(E);
	}
     
   
  
    }
     
     //fonction spécial Mr Fornier 
     public static void hello () {
        System.out.println("\n Hello Player!!\n");
        delay(3000);
        
        String sentence1 = " I HOPE YOU ARE READY FOR THE FINAL WAR !! ";
        
        for (int i =0; i<sentence1.length(); i++) {
            System.out.print(sentence1.charAt(i));
            delay(100);
        }
        
        delay(500);
        
        String sentence2 = "\n\nTHE GAME WILL START IN \n\n     3  \n\n     2    \n\n     1      \n\n     0..............";
        
        for (int i =0; i<sentence2.length(); i++) {
            System.out.print(sentence2.charAt(i));
            delay(100);
        }
        Tools.cls();
                       
    }
     
      static void delay(int time) {
          try{
          Thread.sleep(time);
          }
          catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
          }    
    }
}
