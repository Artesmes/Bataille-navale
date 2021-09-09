/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardContainer;

import java.io.Serializable;

public class Box implements Serializable {
    
    //attribut de chaque box (case ou est contenu un element du bateau)
    
    public char x;
    public int y;
    public boolean revealed;
    public String element;
    
    public String shipType;
    public String shipName;
    public int position;
    
    private boolean occured;
    public boolean boatTouched;
    public boolean boatDestroyed;
    
    public boolean computerRevealed;
    
    public boolean impact;
    
    
    ///constructeur
    public Box(char x, int y, boolean revealed) {
        this.x = x;
        this.y = y;
        this.element = "  ";
        this.revealed = revealed;
        this.occured = false;
        this.boatTouched = false;
        this.boatDestroyed = false;
        this.computerRevealed = false;
        this.impact = false;
    }
    
    //affiche les element associer a chaque bateau(pour les différenciers)
    String printElement(){
        
        if (revealed) {
            
            if (impact && !boatTouched && !boatDestroyed) {
                return "++";
            }
            
            if (boatTouched){
                if(boatDestroyed) {
                    return "°°";
                }
                return "--";
            }
            return element;
        }
        
        return "**";
    }
    
    //rend visible la board de l'ennemi (aka cheat code)
    String unHideElement() {
        if (boatTouched){
                if(boatDestroyed) {
                    return "°°";
                }
                return "--";
            }
        return element;
    }
    
    /*getter et setter*/
    
    void setBoatDestroyed(boolean boatDestroyed) {
        this.boatDestroyed = true;
    }
    
    public void setOccured(boolean occured){
        this.occured=occured;
    }
    
    
    public boolean getOccured() {
        return this.occured;
    }
    
    boolean getBoatTouched() {
        return this.boatTouched;
    }
    
    boolean setBoatTouched() {
        return this.boatTouched;
    }
    
    
    
    
}
