
package players;
import BoardContainer.*;
import bataille.navale.Tools;
import java.io.Serializable;
import java.util.ArrayList;
import shipContainer.*;

public class Player implements Serializable {
    
    public String name;
    
    public Board b1;
    
    
    public Cuirasse cuirasse;
    public Croiseur croi1;
    public Croiseur croi2;
    public Destroyer destroy1;
    public Destroyer destroy2;
    public Destroyer destroy3;   
    public SubMarin subM1;
    public SubMarin subM2;       
    public SubMarin subM3;
    public SubMarin subM4;
    public ArrayList<Object> shootHistory;
    
    //initialisation des bateaux de chaque joueur
    public Player() {
        
        this.cuirasse = new Cuirasse("cuirasse","ØØ");
        this.croi1 = new Croiseur("croi1","x1");
        this.croi2 = new Croiseur("croi2","x2");
        this.destroy1 = new Destroyer("destroy1","d1");
        this.destroy2 = new Destroyer("destroy2","d2");
        this.destroy3 = new Destroyer("destroy3","d3");
        this.subM1 = new SubMarin("subM1","s1");
        this.subM2 = new SubMarin("subM2","s2");
        this.subM3 = new SubMarin("subM3","s3");
        this.subM4 = new SubMarin("subM4","s4");
        shootHistory = new ArrayList<>();
    }
    
    public Ship[] allShips() {
        Ship[] allShips = {this.cuirasse, this.croi1, this.croi2, this.destroy1, this.destroy2, this.destroy3, this.subM1, this.subM2, this.subM3, this.subM4};
        return allShips;
    }
    
    public void check() {
        for(int i=0; i<10; i++) {
            if (allShips()[i].destroyed) {
                //System.out.println("DESTROYING HERE");
                Ship shipToDestroy = allShips()[i];
                destroyShip(shipToDestroy);
            }
        }
    }
    
    //detruit les bateaux
    public void destroyShip(Ship s1) {
        //System.out.println("pos X: " + s1.posX);
        //System.out.println("pos Y: " + s1.posY);
        if (s1.direction == 'N'){
            for (int i=0; i<s1.length; i++) {
                char posX = Tools.intToChar(Tools.charToInt(s1.posX)-i);
                int posY = s1.posY-1;
                b1.goToBox(posX, posY).boatDestroyed = true;
            }
        }
        
        if (s1.direction == 'S'){
            for (int i=0; i<s1.length; i++) {
                char posX = Tools.intToChar(Tools.charToInt(s1.posX)+i);
                int posY = s1.posY-1;
                b1.goToBox(posX, posY).boatDestroyed = true;
            }
        }
        
        if (s1.direction == 'E'){
            for (int i=0; i<s1.length; i++) {
                 b1.goToBox(s1.posX, s1.posY-1+i).boatDestroyed = true;
            }
        }
        
        if (s1.direction == 'W'){
            for (int i=0; i<s1.length; i++) {
                 b1.goToBox(s1.posX, s1.posY-1-i).boatDestroyed = true;
            }
        }
        
    }
    
    //initialise les bateaux
    public void initShipping(){
        while(b1.placeShip(cuirasse)==false){
           cuirasse = new Cuirasse("cuirasse","ØØ");
        }
        while(b1.placeShip(croi1)==false){
            croi1 = new Croiseur("croi1","x1");
        }
        while(b1.placeShip(croi2)==false){
            croi2 = new Croiseur("croi2","x2");
        }
        while(b1.placeShip(destroy1)==false){
            destroy1 = new Destroyer("destroy1","d1");
        }
        while(b1.placeShip(destroy2)==false){
            destroy2 = new Destroyer("destroy2","d2");
        }
        while(b1.placeShip(destroy3)==false){
            destroy3 = new Destroyer("destroy3","d3");
        }
        while(b1.placeShip(subM1)==false){
            subM1 = new SubMarin("subM1","s1");
        }
        while(b1.placeShip(subM2)==false){
            subM2 = new SubMarin("subM2","s2");
        }
        while(b1.placeShip(subM3)==false){
            subM3 = new SubMarin("subM3","s3");
        }
        while(b1.placeShip(subM4)==false){
            subM4 = new SubMarin("subM4","s4");
        }
    }
    
    //affiches la board
    public void displayBoard() {
        b1.displayBoard();
    }
    
    public void unHideBoard() {
        b1.unHideBoard();
    }
    
    public void displaceShip(char pos,Ship bateau){
        b1.displace(pos,bateau);
    }
    
        //direction = direction de deplacement (a saisir) 
   
}
