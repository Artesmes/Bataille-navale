package shipContainer;

import bataille.navale.Positionning;
import bataille.navale.Tools;
import players.Player;
/**
 *
 * @author Alexandre
 */
public class Cuirasse extends Ship implements Attack,Displace{

    boolean []status = new boolean[this.length];
    
    int test = 14;
    public Cuirasse(String shipName, String forme){
        this.shipName=shipName;
        this.life=7;
        this.length =7;
        this.shootPower=9;
        this.posX=Positionning.pX();
        this.posY=Positionning.pY();
        this.direction=Positionning.dir();
        this.forme = forme;
        this.shipType = "Cuirasse"; 
        this.destroyed=false;
        this.touched = false;
    }
    //focntion shoot associer au cuirassé
    @Override
    public boolean shoot(char posX ,int posY, Player enemy) {
        
        enemy.b1.goToBox(posX, posY).revealed = true;
        enemy.b1.goToBox(posX, posY).computerRevealed = true;
        if ("SubMarin".equals(enemy.b1.goToBox(posX, posY).shipType)) enemy.b1.goToBox(posX, posY).impact = false;
        else enemy.b1.goToBox(posX, posY).impact = true;
        
        if((enemy.b1.goToBox(posX, posY).getOccured()) && (!"SubMarin".equals(enemy.b1.goToBox(posX, posY).shipType))){
           enemy.b1.goToBox(posX, posY).impact = false;
           enemy.b1.goToBox(posX, posY).boatTouched = true;
           super.touchEnemyShip(enemy.b1.goToBox(posX, posY), enemy);
        }
        try{
            enemy.b1.goToBox(posX, posY+1).revealed = true;
            enemy.b1.goToBox(posX, posY+1).computerRevealed = true;
        } catch(Exception e){}
        
        try {
            enemy.b1.goToBox(posX, posY-1).revealed = true;
            enemy.b1.goToBox(posX, posY-1).computerRevealed = true;
        } catch(Exception e){}
        
        try {
            char position = Tools.intToChar(Tools.charToInt(posX)-1);
            enemy.b1.goToBox(position, posY).revealed = true;
            enemy.b1.goToBox(position, posY).computerRevealed = true;
        } catch(Exception e){}
        
        try {
            char position = Tools.intToChar(Tools.charToInt(posX)+1);
            enemy.b1.goToBox(position, posY).revealed = true;
            enemy.b1.goToBox(position, posY).computerRevealed = true;
        } catch(Exception e){}
        
        try {
            char position = Tools.intToChar(Tools.charToInt(posX)+1);
            enemy.b1.goToBox(position, posY-1).revealed = true;
            enemy.b1.goToBox(position, posY-1).computerRevealed = true;
        } catch(Exception e){}
        try {
            char position = Tools.intToChar(Tools.charToInt(posX)+1);
            enemy.b1.goToBox(position, posY+1).revealed = true;
            enemy.b1.goToBox(position, posY+1).computerRevealed = true;
        } catch(Exception e){}
        
        try {
            char position = Tools.intToChar(Tools.charToInt(posX)-1);
            enemy.b1.goToBox(position, posY-1).revealed = true;
            enemy.b1.goToBox(position, posY-1).computerRevealed = true;
        } catch(Exception e){}
        
        try {
            char position = Tools.intToChar(Tools.charToInt(posX)-1);
            enemy.b1.goToBox(position, posY+1).revealed = true;
            enemy.b1.goToBox(position, posY+1).computerRevealed = true;
        } catch(Exception e){}
        
        return true;
    }

    @Override
    public void move(int posX ,int posY) {
        
        //verification de l'état du bateau
        int test=0;
        for(int i=0;i<this.length;i++){
            
            if(this.status[i]==false){
                test=1;
            }
        }
        if(test==0){
            System.out.println("Le bateau peut se déplacer");
        }else{
            System.err.println("Bateau touché // impossible de le déplacer");
        }
        
        //verifier si l'emplcameent est libre
    }
    
    
    
   
}
