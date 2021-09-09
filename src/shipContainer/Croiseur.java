package shipContainer;

import BoardContainer.Board;
import BoardContainer.Box;
import bataille.navale.Positionning;
import bataille.navale.Tools;
import players.Player;

public class Croiseur extends Ship implements Attack, Displace {

    //conxtructeur
    public Croiseur(String shipName, String forme){
        this.shipName=shipName;
        this.life=5;
        this.length =5;
        this.shootPower=4;
        this.posX=Positionning.pX();
        this.posY=Positionning.pY();
        this.direction=Positionning.dir();
        this.forme = forme;
        this.shipType="Croiseur";
        this.destroyed = false;
        this.touched = false;
    }
 
    //focntion shoot associer au croiseur
    @Override
    public boolean shoot(char posX ,int posY, Player enemy) {
        
        enemy.b1.goToBox(posX, posY).revealed = true;
        enemy.b1.goToBox(posX, posY).computerRevealed = true;
        enemy.b1.goToBox(posX, posY).impact = true;
      
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
        
        return true;
    }

    @Override
    public void move(int posX ,int posY) {
        
    }
    
    
}
