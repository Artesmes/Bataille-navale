package BoardContainer;
import java.io.Serializable;
import shipContainer.*;

public abstract class Board  implements Serializable {
    public String NameOfTheBoard;
    
    //instance de box
    public Box[][] grid = new Box[15][15];
    
    public Board() {
        createGrid();
    }
    
    
    abstract void createGrid();
    
    //affiche la grille
    void displayGrid() {
        for(int i=0; i<15; i++) {
            for (int j=0; j<15; j++){
                System.out.print("[" + grid[i][j].x + "," + grid[i][j].y + "] ");
            }
            System.out.print("\n");
        }
    }
    
    //Permet de se placer à un endroit voulu de la box
    public Box goToBox(char x, int y) {
        return grid[charToInt(x)][y];
    }
    
    // change l'element afficher à l'écran
    void changeElementBox(char x, int y, String element) {
        grid[charToInt(x)][y].element = element ;
    }
    
    //affiche le plateau de jeu
    public void displayBoard() {
        System.out.println("\n------------------- " + this.NameOfTheBoard + " ------------------\n");
        System.out.print("   ");
        for(int k=0; k<15; k++){
            if (k<10) System.out.print("  " + (int)(k + 1));
            else System.out.print(" " + (int)(k + 1));
        }
        System.out.println("");
        
        for (int i=0; i<15; i++) {
            System.out.print( " " + intToChar(i) +"  ");
            for (int j=0; j<15; j++) {
                System.out.print("|"+ grid[i][j].printElement());
            }
            System.out.print("|");
            System.out.println("");
        }        
    }
    
    public void unHideBoard() {
        System.out.println("\n----------------- Unhide board: " + this.NameOfTheBoard + " ------------------\n");
        System.out.print("  ");
        for(int k=0; k<15; k++){
            if (k<10) System.out.print("  " + (int)(k + 1));
            else System.out.print(" " + (int)(k + 1));
        }
        System.out.println("");
        
        for (int i=0; i<15; i++) {
            System.out.print( intToChar(i) +"  ");
            for (int j=0; j<15; j++) {
                System.out.print("|"+ grid[i][j].unHideElement());
            }
            System.out.print("|");
            System.out.println("");
        }
    }
    
    //fonction qui permet de convertir des int en char (evite de passer pâr la table ascii)
    public static char intToChar(int nombre) {
        switch(nombre) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
            case 8:
                return 'I';
            case 9:
                return 'J';
            case 10:
                return 'K';
            case 11:
                return 'L';
            case 12:
                return 'M';
            case 13:
                return 'N';
            case 14:
                return 'O';
        }
        return 'e';
    }
    
    public static int charToInt(char lettre) {
        switch(lettre) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            case 'I':
                return 8;
            case 'J':
                return 9;
            case 'K':
                return 10;
            case 'L':
                return 11;
            case 'M':
                return 12;
            case 'N':
                return 13;
            case 'O':
                return 14;
        }
        return -1;
        
    }
        
    //fonction qui place les bateaux aléatoirement
    // elle retourne false quand il y a une superposition des bateaux et refait
    //tous les placements
  public boolean placeShip(Ship s1){
      char dir = s1.direction;
      char x = s1.posX;
      int y = s1.posY;
      int length = s1.length;
      String shipName = s1.shipName;
      String shipType = s1.shipType;
      String forme = s1.forme;
      
       int verif=0;
//////////////////////DONE//////////////////////
       if(dir=='N'){
            //changer le 0 en y u en en focntion de la direction
            for(int i=charToInt(x);i>charToInt(x)+1-length-1;i--){
           try{         
                if(i>=0 && grid[i][y-1].getOccured()==false){
                    grid[i][y-1].element=forme;
                    grid[i][y-1].shipName = shipName;
                    grid[i][y-1].setOccured(true);
                    grid[i][y-1].shipType=shipType;
                    verif++;
                }else{
                    for(int j=charToInt(x);j>charToInt(x)+1-verif-1;j--){
                        //System.out.println("effacement");
                        //System.out.println("j="+j+"y="+(y-1));
                            grid[j][y-1].element="  ";
                            grid[j][y-1].setOccured(false);
                            grid[j][y-1].shipName =null;
                            grid[j][y-1].shipType =null;
                    }
                    return false;
                }
              }catch(Exception ArrayIndexOutOfBoundsException){//allow to fix error without leaving the prog
                    System.err.println("Positionning out of bound\n");
                    return false;
               }
            }
        }
   ///////////////////DONE//////////////////////    
       if(dir=='S'){
            for(int i=charToInt(x);i<charToInt(x)+1+length-1;i++){
           try{
                if(i<15 && grid[i][y-1].getOccured()==false){
                grid[i][y-1].element=forme;
                grid[i][y-1].setOccured(true);
                grid[i][y-1].shipName = shipName;
                grid[i][y-1].shipType = shipType;
                verif++;
                }else{
                    for(int j=charToInt(x);j<charToInt(x)+1+verif-1;j++){
                        //System.out.println("effacement");
                        //System.out.println("j="+j+"y="+(y-1));
                            grid[j][y-1].element="  ";
                            grid[j][y-1].setOccured(false);
                            grid[j][y-1].shipName =null;
                            grid[j][y-1].shipType = null;
                    }
                    return false;
                }
            }catch(Exception ArrayIndexOutOfBoundsException){
                System.err.println("Positionning out of bound\n");
                    return false;
             }    
           }
        }
 ///////////////////////////////////////////      
        if(dir=='E'){
            for(int i=y-1;i<y-1+length;i++){
            try{
                if(i<15 && grid[charToInt(x)][i].getOccured()==false){
                grid[charToInt(x)][i].element=forme;
                grid[charToInt(x)][i].setOccured(true);
                grid[charToInt(x)][i].shipName = shipName;
                grid[charToInt(x)][i].shipType = shipType;
                
                verif++;
                }else{
                    for(int j=y-1;j<y-1+verif;j++){
                        //System.out.println("effacement");
                        //System.out.println("x="+x+"y="+j);
                        grid[charToInt(x)][j].element="  ";
                        grid[charToInt(x)][j].setOccured(false);
                        grid[charToInt(x)][j].shipType = null;
                    }    
                    return false;
                }
            }catch(Exception ArrayIndexOutOfBoundsException){   
                System.err.println("Positionning out of bound\n");
                    return false;
            }
          }    
       }
///////////////////////////////////////////       
        if(dir=='W'){
            for(int i=y-1;i>y-1-length;i--){
            try{
                if(i>=0 && grid[charToInt(x)][i].getOccured()==false){
                grid[charToInt(x)][i].element=forme;
                grid[charToInt(x)][i].setOccured(true);
                grid[charToInt(x)][i].shipName = shipName;
                grid[charToInt(x)][i].shipType = shipType;
                verif++;
                }else{
                    for(int j=y-1;j>y-1-verif;j--){
                        grid[charToInt(x)][j].element= "  ";
                        grid[charToInt(x)][j].setOccured(false);
                        grid[charToInt(x)][j].shipName = null;
                        grid[charToInt(x)][j].shipType = null;
                    }        
                    return false;
                }
            }catch(Exception ArrayIndexOutOfBoundsException){
                System.err.println("Positionning out of bound\n");
                    return false;
            }
          }    
       }
        
        return true;
   }
  
  ////////////////////////////DISPLACE SHIP/////////////////////////////
  
   public void displace(char direc,Ship s) {
        
        char dir = s.direction;
        int longueur = s.length;
        char x = s.posX;
        int y = s.posY;
         int testo = y-1;
                
        if (direc == 'W'){//direction de déplacement (a saisir)
            
            if(dir=='W')//direction de positionnement du bateau
            {       
             if(y-longueur-1>0&&"  ".equals(grid[charToInt(x)][y-longueur-1].element)){
                 System.out.println("Ship has been moved : WEST");
                for(int i=y-longueur;i<y;i++){       
    
                    //changement de parametre pour une case du bateau
                    grid[charToInt(x)][i-1].element=grid[charToInt(x)][i].element;
                    grid[charToInt(x)][i-1].revealed=grid[charToInt(x)][i].revealed;
                    grid[charToInt(x)][i-1].boatTouched=grid[charToInt(x)][i].boatTouched;
                    grid[charToInt(x)][i-1].boatDestroyed=grid[charToInt(x)][i].boatDestroyed;
                    grid[charToInt(x)][i-1].shipName=grid[charToInt(x)][i].shipName;
                    grid[charToInt(x)][i-1].shipType=grid[charToInt(x)][i].shipType;
                    
                    //grid[charToInt(x)][i-1].x = grid[charToInt(x)][i].x;
                    //grid[charToInt(x)][i-1].y = grid[charToInt(x)][i].y;
                    
                    
                    //ancienne case du bateau remise a null
                    grid[charToInt(x)][i].element="  ";
                    grid[charToInt(x)][i].shipName=null;
                    grid[charToInt(x)][i].revealed = true;
                    grid[charToInt(x)][i].setOccured(false);       
                    grid[charToInt(x)][i].boatTouched = false;
                    grid[charToInt(x)][i].boatDestroyed = false;
                    grid[charToInt(x)][i].shipType=null;
                    
                    //grid[charToInt(x)][i].x = grid[charToInt(x)][i+1].x;
                    //grid[charToInt(x)][i].y = grid[charToInt(x)][i+1].y;
                    
                    }
                s.posY--;
                }else{

                 System.out.println("U cannot move\n");
              }
            }
            if(dir=='E')
            {   

               if(y-1>1&& "  ".equals(grid[charToInt(x)][y-2].element)){
                
                   System.out.println("Ship has been moved : WEST");
                for(int i= y-1;i<y+longueur-1;i++){
                    
                    grid[charToInt(x)][i-1].element=grid[charToInt(x)][i].element;
                    grid[charToInt(x)][i-1].revealed=grid[charToInt(x)][i].revealed;
                    grid[charToInt(x)][i-1].boatTouched=grid[charToInt(x)][i].boatTouched;
                    grid[charToInt(x)][i-1].boatDestroyed=grid[charToInt(x)][i].boatDestroyed;
                    grid[charToInt(x)][i-1].shipName=grid[charToInt(x)][i].shipName;
                    grid[charToInt(x)][i-1].shipType=grid[charToInt(x)][i].shipType;
                    
                    //grid[charToInt(x)][i-1].x = grid[charToInt(x)][i].x;
                    //grid[charToInt(x)][i-1].y = grid[charToInt(x)][i].y;


                    //ancienne case du bateau remise a null
                    grid[charToInt(x)][i].element="  ";
                    grid[charToInt(x)][i].shipName=null;
                    grid[charToInt(x)][i].revealed = true;
                    grid[charToInt(x)][i].setOccured(false);       
                    grid[charToInt(x)][i].boatTouched = false;
                    grid[charToInt(x)][i].boatDestroyed = false;
                    grid[charToInt(x)][i].shipType=null;
                    
                    //grid[charToInt(x)][i].x = grid[charToInt(x)][i+1].x;
                    //grid[charToInt(x)][i].y = grid[charToInt(x)][i+1].y;
                     
                } 
                s.posY--;
               }else{
                   System.out.println("U can not move\n");
               }
            }
        }
        //fin SI WEST
        
        if(direc == 'E'){
            
            if(dir=='W')
            {   
                 int test = y-longueur;
                 int test2 = y+1;

                 if((y<=14) && 
                     (y+1<=16 && "  ".equals(grid[charToInt(x)][y].element))){
                
                   System.out.println("Ship has been moved : EAST");
                for(int i= y-1;i>y-longueur-1;i--){
                    
                    grid[charToInt(x)][i+1].element=grid[charToInt(x)][i].element;
                    grid[charToInt(x)][i+1].revealed=grid[charToInt(x)][i].revealed;
                    grid[charToInt(x)][i+1].boatTouched=grid[charToInt(x)][i].boatTouched;
                    grid[charToInt(x)][i+1].boatDestroyed=grid[charToInt(x)][i].boatDestroyed;
                    grid[charToInt(x)][i+1].shipName=grid[charToInt(x)][i].shipName;
                    grid[charToInt(x)][i+1].shipType=grid[charToInt(x)][i].shipType;
                    
                    //grid[charToInt(x)][i+1].x = grid[charToInt(x)][i].x;
                    //grid[charToInt(x)][i+1].y = grid[charToInt(x)][i].y;
                    
                    //ancienne case du bateau remise a null
                    grid[charToInt(x)][i].element="  ";
                    grid[charToInt(x)][i].shipName=null;
                    grid[charToInt(x)][i].revealed = true;
                    grid[charToInt(x)][i].setOccured(false);       
                    grid[charToInt(x)][i].boatTouched = false;
                    grid[charToInt(x)][i].boatDestroyed = false;
                    grid[charToInt(x)][i].shipType=null;
                    
                    //grid[charToInt(x)][i].x = grid[charToInt(x)][i-1].x;
                    //grid[charToInt(x)][i].y = grid[charToInt(x)][i-1].y;
                     
                } 
                s.posY++;// on met a jour la position initiale du bateau
               }else{
                   System.out.println("U can not move\n");
               }
            }
            if(dir=='E')
            {   
                 if(
                    (y<=7 && "  ".equals(grid[charToInt(x)][y+longueur-1].element))){

                   System.out.println("Ship has been moved : EAST");
                
                 for(int i= y+longueur-1;i>y-2;i--){

                    grid[charToInt(x)][i+1].element=grid[charToInt(x)][i].element;
                    grid[charToInt(x)][i+1].revealed=grid[charToInt(x)][i].revealed;
                    grid[charToInt(x)][i+1].boatTouched=grid[charToInt(x)][i].boatTouched;
                    grid[charToInt(x)][i+1].boatDestroyed=grid[charToInt(x)][i].boatDestroyed;
                    grid[charToInt(x)][i+1].shipName=grid[charToInt(x)][i].shipName;
                    grid[charToInt(x)][i+1].shipType=grid[charToInt(x)][i].shipType;
                    
                    //grid[charToInt(x)][i+1].x = grid[charToInt(x)][i].x;
                    //grid[charToInt(x)][i+1].y = grid[charToInt(x)][i].y;
                    
                    //ancienne case du bateau remise a null
                    grid[charToInt(x)][i].element="  ";
                    grid[charToInt(x)][i].shipName=null;
                    grid[charToInt(x)][i].revealed = true;
                    grid[charToInt(x)][i].setOccured(false);       
                    grid[charToInt(x)][i].boatTouched = false;
                    grid[charToInt(x)][i].boatDestroyed = false;
                    grid[charToInt(x)][i].shipType=null;
                    
                    //grid[charToInt(x)][i].x = grid[charToInt(x)][i-1].x;
                    //grid[charToInt(x)][i].y = grid[charToInt(x)][i-1].y;
                     
                } 
                 s.posY++;// on met a jour la position initiale du bateau
               }else{
                   System.out.println("U can not move\n");
               }
            }
    }
       //Fin SI EAST 
       if(direc == 'N'){
            
            if(dir=='N')
            {   
                if(charToInt(x)>longueur-1 && "  ".equals(grid[charToInt(x)-longueur][y-1].element) ){
                
                   System.out.println("Ship has been moved : NORTH");
                
                   for(int i= charToInt(x)-longueur+1;i<charToInt(x)+1;i++){

                    grid[i-1][y-1].element=grid[i][y-1].element;
                    grid[i-1][y-1].revealed=grid[i][y-1].revealed;
                    grid[i-1][y-1].boatTouched=grid[i][y-1].boatTouched;
                    grid[i-1][y-1].boatDestroyed=grid[i][y-1].boatDestroyed;
                    grid[i-1][y-1].shipName=grid[i][y-1].shipName;
                    grid[i-1][y-1].shipType=grid[i][y-1].shipType;
                    
                    //grid[i-1][y-1].x = grid[charToInt(x)][i].x;
                    //grid[i-1][y-1].y = grid[charToInt(x)][i].y;
                    
                    //ancienne case du bateau remise a null
                    grid[i][y-1].element="  ";
                    grid[i][y-1].shipName=null;
                    grid[i][y-1].revealed = true;
                    grid[i][y-1].setOccured(false);       
                    grid[i][y-1].boatTouched = false;
                    grid[i][y-1].boatDestroyed = false;
                    grid[i][y-1].shipType=null;
                    
                    //grid[i+1][y-1].x = grid[charToInt(x)][i].x;
                    //grid[i+1][y-1].y = grid[charToInt(x)][i].y;
                     
                } 
                   s.posX--;// on met a jour la position initiale du bateau
               }else{
                   System.out.println("U can not move\n");
               }
            }
            if(dir=='S')
            {   
                if(charToInt(x)>0 
                        && "  ".equals(grid[charToInt(x)-1][y-1].element) ){
                
                   System.out.println("Ship has been moved : NORTH");
                
                   for(int i= charToInt(x);i<charToInt(x)+longueur;i++){

                    grid[i-1][y-1].element=grid[i][y-1].element;
                    grid[i-1][y-1].revealed=grid[i][y-1].revealed;
                    grid[i-1][y-1].boatTouched=grid[i][y-1].boatTouched;
                    grid[i-1][y-1].boatDestroyed=grid[i][y-1].boatDestroyed;
                    grid[i-1][y-1].shipName=grid[i][y-1].shipName;
                    grid[i-1][y-1].shipType=grid[i][y-1].shipType;
                    
                    //grid[i-1][y-1].x = grid[charToInt(x)][i].x;
                    //grid[i-1][y-1].y = grid[charToInt(x)][i].y;
                    
                    //ancienne case du bateau remise a null
                    grid[i][y-1].element="  ";
                    grid[i][y-1].shipName=null;
                    grid[i][y-1].revealed = true;
                    grid[i][y-1].setOccured(false);       
                    grid[i][y-1].boatTouched = false;
                    grid[i][y-1].boatDestroyed = false;
                    grid[i][y-1].shipType=null;
                    
                    //grid[i+1][y-1].x = grid[charToInt(x)][i].x;
                    //grid[i+1][y-1].y = grid[charToInt(x)][i].y;
                     
                }
                 s.posX--;// on met a jour la position initiale du bateau
               }else{
                   System.out.println("U can not move\n");
               }
          }
      }
       //Fin SI NORTH
       
          if(direc == 'S'){
            
            if(dir=='N')
            {   
                if(charToInt(x)<14
                        && "  ".equals(grid[charToInt(x)+1][y-1].element) ){
                
                   System.out.println("Ship has been moved : SOUTH");
                
                   for(int i= charToInt(x);i>charToInt(x)-longueur;i--){

                    grid[i+1][y-1].element=grid[i][y-1].element;
                    grid[i+1][y-1].revealed=grid[i][y-1].revealed;
                    grid[i+1][y-1].boatTouched=grid[i][y-1].boatTouched;
                    grid[i+1][y-1].boatDestroyed=grid[i][y-1].boatDestroyed;
                    grid[i+1][y-1].shipName=grid[i][y-1].shipName;
                    grid[i+1][y-1].shipType=grid[i][y-1].shipType;
                    
                    //grid[i+1][y-1].x = grid[charToInt(x)][i].x;
                    //grid[i+1][y-1].y = grid[charToInt(x)][i].y;
                    
                    //ancienne case du bateau remise a null
                    grid[i][y-1].element="  ";
                    grid[i][y-1].shipName=null;
                    grid[i][y-1].revealed = true;
                    grid[i][y-1].setOccured(false);       
                    grid[i][y-1].boatTouched = false;
                    grid[i][y-1].boatDestroyed = false;
                    grid[i][y-1].shipType=null;
                    
                    //grid[i-1][y-1].x = grid[charToInt(x)][i].x;
                    //grid[i-1][y-1].y = grid[charToInt(x)][i].y;
                     
                } 
                 s.posX++;// on met a jour la position initiale du bateau            
               }else{
                   System.out.println("U can not move\n");
               }
            }
            if(dir=='S')
            {      
                if(charToInt(x)+longueur<14 
                        && "  ".equals(grid[charToInt(x)+longueur+1][y-1].element) ){
                
                   System.out.println("Ship has been moved : SOUTH");
                
                   for(int i= charToInt(x)+longueur;i>charToInt(x)-1;i--){

                    grid[i+1][y-1].element=grid[i][y-1].element;
                    grid[i+1][y-1].revealed=grid[i][y-1].revealed;
                    grid[i+1][y-1].boatTouched=grid[i][y-1].boatTouched;
                    grid[i+1][y-1].boatDestroyed=grid[i][y-1].boatDestroyed;
                    grid[i+1][y-1].shipName=grid[i][y-1].shipName;
                    grid[i+1][y-1].shipType=grid[i][y-1].shipType;
                    
                    //grid[i+1][y-1].x = grid[charToInt(x)][i].x;
                    //grid[i+1][y-1].y = grid[charToInt(x)][i].y;
                    
                    //ancienne case du bateau remise à null
                    grid[i][y-1].element="  ";
                    grid[i][y-1].shipName=null;
                    grid[i][y-1].revealed = true;
                    grid[i][y-1].setOccured(false);       
                    grid[i][y-1].boatTouched = false;
                    grid[i][y-1].boatDestroyed = false;
                    grid[i][y-1].shipType=null;
                    
                    //grid[i-1][y-1].x = grid[charToInt(x)][i].x;
                    //grid[i-1][y-1].y = grid[charToInt(x)][i].y;
                     
                }
                 s.posX++;  // on met a jour la position initiale du bateau               
               }else{
                   System.out.println("U can not move\n");
               }
          } 
      }
   }
    
}
