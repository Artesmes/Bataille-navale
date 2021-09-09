/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille.navale;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import players.Computer;
import players.Player1;


//permet de sauvegarder le jeu
public class Save implements Serializable {
    
    //sauvegarde la partie en cours
    public static void save(Player1 player1, Computer computer1, String nameSave) {
    
        try {
            FileOutputStream fos = new FileOutputStream(nameSave);
            
            ObjectOutputStream oos= new ObjectOutputStream(fos);
   
            oos.writeObject(player1);
            oos.writeObject(computer1);
       
            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //charge la partie choisi en fonction du nom
    public static Object load(String saveName){
        try {
            
            FileInputStream fos = new FileInputStream(saveName);
            
            ObjectInputStream ois= new ObjectInputStream(fos);
            
            Player1 player1 = (Player1) ois.readObject();
            Computer computer1 = (Computer) ois.readObject();
            
            player1.displayBoard();
            computer1.displayBoard();
            
            Object[] tab = {player1, computer1};
            return tab;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        } catch (IOException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    }
}

class Informations implements Serializable {
    
    public ArrayList <String> saveNames;
    int numberSaves;
    
    public void addSave(String saveName) {
        this.saveNames.add(saveName);
    }
    
    public static void init() {
        
        try {
            FileOutputStream fos = new FileOutputStream("informations.ser");
            
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            
            Informations information = new Informations();
            information.numberSaves =0;
            information.saveNames = new ArrayList();
            oos.writeObject(information);

            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Informations load(){
        try {
            
            FileInputStream fos = new FileInputStream("informations.ser");
            
            ObjectInputStream ois= new ObjectInputStream(fos);
            
            Informations info1 = (Informations) ois.readObject();
            
            ois.close();
            
            return info1;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        } catch (IOException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
 
    }
    
    public static void push(String saveName) {
        
        try {
            Informations info = Informations.load();
            
            FileOutputStream fos = new FileOutputStream("informations.ser");
            
            ObjectOutputStream oos= new ObjectOutputStream(fos);
   
            info.numberSaves ++;
            info.saveNames.add(saveName);
            System.out.println(info.saveNames);
            oos.writeObject(info);

            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    

        

        

        

