/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import BoardContainer.EnemyBoard;
import java.io.Serializable;

//creation de la classe enemy
public class Computer extends Player {
    public String previousShip;
    public Computer() {
        previousShip="no";
        this.b1 = new EnemyBoard();
        this.name ="computer";
    }
    
}
