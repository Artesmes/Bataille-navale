package bataille.navale;
import java.util.Random;

/**
 *
 * @author Alexandre
 */
public class Positionning {//allow ship to be positionning on the board
                           //need to verify the ship overlop
   static Random posi = new Random();//random variable need to be static too !
   
   //choisi une position Y aleatoire
   public static int pY(){
       return posi.nextInt(15)+1;// entre 1-15
   }
    //choisi une position X aleatoire
   public static char pX(){  
       return (char)(posi.nextInt(15) + 65);//code ascii entre a-o
   }
    //choisi une direction X aleatoire
   public static char dir(){//direction NORTH goes UP // SOUTH goes DOWN // EAST goes Right // WEST goes Left
       final String DIRECTION = "NWSE"; 
       return DIRECTION.charAt(posi.nextInt(4));
   }  
    
}
