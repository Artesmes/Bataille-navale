package shipContainer;

import bataille.navale.Positionning;
import BoardContainer.Board;
import bataille.navale.Tools;
import players.Player;
/**
 *
 * @author Alexandre
 */
public class Destroyer extends Ship implements Attack,Displace{

     
    
    public Destroyer(String shipName, String forme){
        this.shipName=shipName;
        this.life=3;
        this.length =3;
        this.shootPower=1;
        this.posX=Positionning.pX();
        this.posY=Positionning.pY();
        this.direction=Positionning.dir();
        this.flare=true;
        this.forme = forme;
        this.shipType = "Destroyer";
        this.destroyed = false;
        this.touched = false;
    }
    
//focntion shoot associer au destroyer
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
        
        if (this.flare){
            this.flare = false;
            for(int i=0; i<4; i++){
                 for (int j=0; j<4; j++){
                     try{
                        char position = Tools.intToChar(Tools.charToInt(posX)+i);
                        enemy.b1.goToBox(position, posY+j).revealed = true;
                        enemy.b1.goToBox(position, posY+j).computerRevealed = true;
                    } catch(Exception e){}
                 }
            }
        }
        
        
        return true;
    }

    @Override
    public void move(int posX ,int posY) {
        
    }

    
    
}
