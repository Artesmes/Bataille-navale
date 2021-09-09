package shipContainer;

import bataille.navale.Positionning;
import players.Player;

public class SubMarin extends Ship implements Attack,Displace{

    public SubMarin(String shipName, String forme){
        this.shipName=shipName;
        this.life=1;
        this.length =1;
        this.shootPower=1;
        this.posX=Positionning.pX();
        this.posY=Positionning.pY();
        this.forme = forme;
        this.direction = 'N';
        this.shipType = "SubMarin";
        this.destroyed = false;
        this.touched = false;
        //pas de direction car  longueur = 1;
    }
    
    
     
    //focntion shoot associer au sousMarin
    @Override
    public boolean shoot(char posX ,int posY, Player enemy) {
        
        enemy.b1.goToBox(posX, posY).revealed = true;
        enemy.b1.goToBox(posX, posY).computerRevealed = true;
      
        if("SubMarin".equals(enemy.b1.goToBox(posX, posY).shipType)){
           enemy.b1.goToBox(posX, posY).boatTouched = true;
           super.touchEnemyShip(enemy.b1.goToBox(posX, posY), enemy);   
        }
        return true;
    }

    @Override
    public void move(int posX ,int posY) {
    }
    
}
