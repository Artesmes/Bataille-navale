package shipContainer;

import BoardContainer.*;
import bataille.navale.Tools;
import java.io.Serializable;
import players.Player;

/**
 *
 * @author asebi
 */
public abstract class Ship implements Serializable{
    
    
    //TODO: Alexandre
    public int life;
    public int length;
    public int shootPower;
    public int posY;
    
    public String shipName;
    public String shipType;
    public String forme;

    public char posX;
    public char direction;
    
    public boolean flare;
    public Boolean destroyed;
    public boolean touched;
    
    void touched() {
        this.life += -1;
        this.touched = true;
        if (life ==0) {
            this.destroyed = true;
        }
    }
    
    public boolean[] ShipInit() {//etat du bateau en fonction de sa position
        
        boolean []status = new boolean[this.length];
        
        for(int i=0;i<this.length;i++){
            status[i]=true;
        }
      return status;  
    }
    
    public abstract boolean shoot(char posX ,int posY, Player enemy);
    
    public void touchEnemyShip(Box b,Player enemy) {
        //System.out.println(b.shipName);
        //System.out.println(b.element);
        //System.out.println(b.boatTouched);
        
        if (b.shipName.equals(enemy.cuirasse.shipName)) {
            enemy.cuirasse.touched();
        }
        if (b.shipName.equals(enemy.croi1.shipName)) {
            enemy.croi1.touched();
        }
        if (b.shipName.equals(enemy.croi2.shipName)) {
            enemy.croi2.touched();
        }
        if (b.shipName.equals(enemy.destroy1.shipName)) {
            enemy.destroy1.touched();
        }
        if (b.shipName.equals(enemy.destroy2.shipName)) {
            enemy.destroy2.touched();
        }
        if (b.shipName.equals(enemy.destroy3.shipName)) {
            enemy.destroy3.touched();
        }
        if (b.shipName.equals(enemy.subM1.shipName)) {
            enemy.subM1.touched();
        }
        if (b.shipName.equals(enemy.subM2.shipName)) {
            enemy.subM2.touched();
        }
        if (b.shipName.equals(enemy.subM3.shipName)) {
            enemy.subM3.touched();
        }
        if (b.shipName.equals(enemy.subM4.shipName)) {
            enemy.subM4.touched();
        }
    }
       
}
