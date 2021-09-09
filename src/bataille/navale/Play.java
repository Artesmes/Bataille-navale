package bataille.navale;
import static bataille.navale.Tools.delay;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import players.*;

//
public class Play {
    
   static boolean cheatCode = false;
    
   //fonction qui fait tourner le jeu en boucle dans qu'il n(y a pas de gagnant
    public static void game(Player1 player1, Computer computer1){
        Tools.cls();
        Scanner sc = new Scanner(System.in);

        label1:
        while(!winGame(player1, computer1) && !winGame(computer1, player1)){
            int nb=0;
            do{
                Tools.cls();
                computer1.displayBoard();
                player1.displayBoard();System.out.println("\n Would you like to shoot or move a boat ? \n [1] shoot                   [9] save & Exit \n [2] move                    [10] exit\n");
                
                try{
                    String tampon;
                    tampon = sc.next();
                    nb = Integer.parseInt(tampon);
                }catch(NumberFormatException e){}//Exception e replace by NumberFormatException
            }while(!(nb==1 || nb==2 || nb==9 || nb==123456 || nb==10));

            switch(nb) {
                case 1:
                    Tools.cls();
                    if (cheatCode) computer1.unHideBoard();
                    computer1.displayBoard();
                    player1.displayBoard();
                    shooting(player1, computer1);
                    Tools.cls();
                    break;
                    
                case 2:
                    moving(player1, computer1);
                    Tools.cls();
                    computer1.displayBoard();
                    player1.displayBoard();
                    System.out.println("\n Successfull moove !");
                    Tools.delay(3000);
                    break;
                    
                case 123456:
                    System.out.println("CHEAT CODE ACTIVATED");
                    Tools.delay(3000);
                    cheatCode = true;
                    shooting(player1, computer1);
                    break;
                    
                case 1234567:
                    System.out.println("CHEAT CODE DESACTIVATED");
                    cheatCode = false;
                    Tools.cls();
                    
                    computer1.displayBoard();
                    player1.displayBoard();
                    
                    shooting(player1, computer1);
                    break;
                
                case 9:
                    String nameSave;
                    System.out.println("name of the save: ");
                    nameSave = sc.next();
                    System.out.println("Exiting game ...");
                    Tools.delay(2000);
                    Informations.push(nameSave);
                    Save.save(player1, computer1, nameSave);
                    break label1;
                
                case 10:
                    System.out.println("Exiting game ...");
                    Tools.delay(2000);
                    break label1;
                    
            }
                
            if (winGame(player1, computer1)) break;
            Tools.cls();
            computer1.displayBoard();
            player1.displayBoard();
            System.out.println("\n CAREFUL! The enemy is going to shoot !");
            Tools.delay(3000);        
            
            Tools.cls();
            computer1.displayBoard();
            player1.displayBoard();
            for(int i = 0; i<1; i++){
                enemyShooting(player1 ,computer1, computer1.shootHistory);
            }
            Tools.delay(4000);
            
            computer1.check();
            player1.check();
            
            
            Tools.cls();
            computer1.displayBoard();
            player1.displayBoard();
            System.out.println("\n Successfull Enemy shot");
            Tools.delay(2000);
            
        }
        
        if (winGame(player1, computer1) || winGame(computer1, player1)){
            Tools.cls();
            System.out.println("\n CONGRATULATION FOR THIS GAME !!\n");
            delay(3000);
        
        String sentence1 = "\n AND THE WINNER IS..................\n "+ theWinnerIs(player1, computer1);
        
        for (int i =0; i<sentence1.length(); i++) {
            System.out.print(sentence1.charAt(i));
            delay(100);
        }
        System.out.println("\n CONGRATULATION !!!!!");
        delay(5000);
        }
    }
    
    //fonction shoot
    static void shooting(Player player1, Computer computer1) {
        
        Scanner sc = new Scanner(System.in);
        
        int ship=0;
        do {
            do {
            Tools.cls();
            //si le cheatCode est entré le joueur a le droit de voir la board
            if (cheatCode) computer1.unHideBoard();
            computer1.displayBoard();
            player1.displayBoard();
            
            System.out.println("\n With which ship would you like to attack ?\n");
            
            for(int i =0; i<10; i++){
                if (player1.allShips()[i].destroyed) {
                    System.out.println(" [" + player1.allShips()[i].shipName + "] " + "is destroyed");
                }
                else {
                    int j = i+1;
                    System.out.println(" [" + j + "] " + player1.allShips()[i].shipName );
                }
            }

            
                try{ 
                    String tampon;
                    tampon = sc.next();
                    ship = Integer.parseInt(tampon);
                }catch(Exception e){}
            }while(ship<1 || ship>10);
            
            //test si le bateau est entierement détruit
            if (player1.allShips()[ship-1].destroyed) {
                Tools.cls();
                computer1.displayBoard();
                player1.displayBoard();
                System.out.println("\n This ship is destroyed, you cannot shoot with it");
                Tools.delay(3000);
                
                Tools.cls();
                computer1.displayBoard();
                player1.displayBoard();         
            }
        
        } while(player1.allShips()[ship-1].destroyed);
        
        //posiiton ou tirer
        char posX='Z';
        int posY=99;
        String take;
        do {
            try{
            Tools.cls();
            if (cheatCode) computer1.unHideBoard();
            computer1.displayBoard();
            player1.displayBoard();
            System.out.println("\n Where do you want to shoot ? (ex: C4)");
            
            take = sc.next();
            posX = take.charAt(0);
            String sposY = take.substring(1, take.length());
            posY = Integer.parseInt(sposY)-1;
            }catch(Exception e){};
        }while(posY>15 || posY<0 || posX>79 || posX<65);
        
        
        Tools.cls();
        computer1.displayBoard();
        player1.displayBoard();
        int j = posY +1;
        System.out.println("\n Shooting on " + posX + " " + j + " .....");
        Tools.delay(1000);
                
        //choix du bateau avec lequel tirer
        switch(ship) {
            case 1:
                player1.cuirasse.shoot(posX, posY, computer1);
                break;
        
            case 2:
                player1.croi1.shoot(posX, posY, computer1);
                break;
                
            case 3:
                player1.croi2.shoot(posX, posY, computer1);
                break;   
            
            case 4:
                player1.destroy1.shoot(posX, posY, computer1);
                break;
            
            case 5:
                player1.destroy2.shoot(posX, posY, computer1);
                break;
            
            case 6:
                player1.destroy3.shoot(posX, posY, computer1);
                break;
            
            case 7:
                player1.subM1.shoot(posX, posY, computer1);
                break;
            
            case 8:
                player1.subM2.shoot(posX, posY, computer1);
                break;
                
            case 9:
                player1.subM3.shoot(posX, posY, computer1);
                break;
                
            case 10:
                player1.subM4.shoot(posX, posY, computer1);
                break;    
        }
        Tools.cls();
        computer1.displayBoard();
        player1.displayBoard();
        computer1.check();
        player1.check();
        if(computer1.b1.goToBox(posX, posY).getOccured() && !computer1.b1.goToBox(posX, posY).impact){
            if (computer1.b1.goToBox(posX, posY).boatDestroyed) System.out.println("\n You flowed a Ship !");
            else System.out.println("\n You hit a Ship !");
        }
        else {
            System.out.println("\n No ship Touched ");
        }
        Tools.delay(2000);
    }
    
    // IA (bot)
    static void enemyShooting(Player1 player1, Computer computer1, ArrayList enemyHistory) {
        int shootPosY =0;
        char shootPosX = 'A';
        
        boolean shootPrevious = false;
        boolean shootSubM = false;
        boolean findB = false;
        
        int posY=0;
        char posX='A';
        label2:
        for (int i=0; i<15;i++){
            for(int j=0; j<15;j++) {
                if (player1.b1.grid[i][j].computerRevealed && player1.b1.grid[i][j].getOccured() && !player1.b1.grid[i][j].impact  && !player1.b1.grid[i][j].boatTouched && !player1.b1.grid[i][j].boatDestroyed) {
                    findB = true;
                    
                    posY = j;
                    posX = Tools.intToChar(i);
                   
                    if("SubMarin".equals(player1.b1.grid[i][j].shipType)){
                        for(int k=6; k<10;k++) {
                            if (!computer1.allShips()[k].destroyed) {
                                shootSubM=true;
                                shootPrevious = false;
                                computer1.allShips()[k].shoot(posX, posY, player1);
                                posY++;
                                System.out.println("\n The enemy is shooting on " + posX + " " + posY + " with a " + computer1.allShips()[k].shipName);
                                break label2;
                            } 
                        }
                    }
                    
                    if(player1.b1.grid[i][j].shipName.equals(computer1.previousShip)){
                        shootPrevious = true;
                        shootPosY = posY;
                        shootPosX = posX;
                        
                    }  
                }
            }
        }
        
        if (shootPrevious){
            for(int k=0; k<10;k++){
                if(!computer1.allShips()[k].destroyed){
                    computer1.allShips()[k].shoot(shootPosX, shootPosY, player1);
                    computer1.previousShip = player1.b1.goToBox(shootPosX, shootPosY).shipName;
                    shootPosY++;
                    System.out.println("\n The enemy is shooting on: " + shootPosX + " " + shootPosY + " with a " + computer1.allShips()[k].shipName);
                    break;
                }
            }
        }
        
        if (!shootPrevious && !shootSubM && findB ) {
            for(int k=0; k<10;k++){
                if(!computer1.allShips()[k].destroyed){
                    computer1.allShips()[k].shoot(posX, posY, player1);
                    computer1.previousShip = player1.b1.goToBox(posX, posY).shipName;
                    posY++;
                    System.out.println("\n The enemy is shooting on: " + posX + " " + posY + " with a " + computer1.allShips()[k].shipName);
                    
                    break;
                }
            }
        }
//        
        
        if (!findB) {
            
            boolean err;
            Random rand = new Random();

            int randomY=1;
            char randomX='A';

            do {
                boolean flare1= false;
                err=false;
                for (int p=3; p<6;p++){
                    if (computer1.allShips()[p].flare && !computer1.allShips()[p].destroyed) {
                        randomY = rand.nextInt(12)  ;
                        randomX =  Tools.intToChar(rand.nextInt(12));
                        flare1 =true;
                    }
                }
                if (!flare1) {
                    randomY = rand.nextInt(15)  ;
                    randomX =  Tools.intToChar(rand.nextInt(15));
                }
                

                for (int j = 0; j<enemyHistory.size(); j+=2) {
                    if((enemyHistory.get(j) == (Object) randomX) && (enemyHistory.get(j+1) == (Object) randomY)){
                        err = true;
                        break;
                    }
                }

            } while (err == true || player1.b1.goToBox(randomX, randomY).impact);

            enemyHistory.add(randomX);
            enemyHistory.add(randomY);
            int j = randomY +1;
            
            boolean flare = false;
            
            for (int i=3; i<6; i++){
                if (computer1.allShips()[i].flare && !computer1.allShips()[i].destroyed){
                    computer1.allShips()[i].shoot(randomX, randomY, player1);
                    System.out.println("\n The enemy is shooting on: " + randomX + " " + j + " with a " + computer1.allShips()[i].shipName);
                    flare = true;
                    break;
                }
            }
            
            if(!flare){
                for(int k=0; k<10; k++){
                    if(!computer1.allShips()[k].destroyed){
                        computer1.allShips()[k].shoot(randomX, randomY, player1);
                        System.out.println("\n The enemy is shooting on: " + randomX + " " + j + " with a " + computer1.allShips()[k].shipName);
                        break;
                    }
                }
            }
            
            computer1.previousShip = player1.b1.goToBox(randomX, randomY).shipName;
        }
        
    }
    
    //appelle la fonction displace en fonctino des paramètres d'entrées
    static void moving(Player player1, Player computer1) {
        Scanner sc = new Scanner(System.in);
        int ship = 99;
        boolean retry;
        do {
            do {
                retry = false;
                Tools.cls();
                computer1.displayBoard();
                player1.displayBoard();
                System.out.println("\n Which ship would you like to move ?");

                for(int i =0; i<10; i++){
                    if (player1.allShips()[i].touched) {
                        System.out.println(" [" + player1.allShips()[i].shipName + "] " + "is touched");
                    }
                    else {
                        int j = i+1;
                        System.out.println(" [" + j + "] " + player1.allShips()[i].shipName );
                    }
                }
                try {
                    String tampon = sc.next();
                    ship = Integer.parseInt(tampon);
                } catch(Exception E) {};


            } while(ship < 1 || ship > 10 || retry == true);
        if (player1.allShips()[ship-1].touched) {
                retry = true;
                Tools.cls();
                computer1.displayBoard();
                player1.displayBoard();
                System.out.println("\n This ship is touched, you cannot move it");
                Tools.delay(2000);
            }
        }while(retry == true);
        
        char move = 'N';
        if (player1.allShips()[ship-1].direction =='N' || player1.allShips()[ship-1].direction =='S') {
            do {
                Tools.cls();
                computer1.displayBoard();
                player1.displayBoard();
                System.out.println("\n In which direction do you want to move the boat (N S)?");
                move = sc.next().charAt(0);
            }while(move != 'N' && move != 'S');
        }
        if (player1.allShips()[ship-1].direction =='E' || player1.allShips()[ship-1].direction =='W') {
           do {
               Tools.cls();
               computer1.displayBoard();
               player1.displayBoard();
               System.out.println("\n In which direction do you want to move the boat (E W)?");
               move = sc.next().charAt(0);
            }while(move != 'W' && move != 'E');
        }
        
        player1.displaceShip(move, player1.allShips()[ship-1]);
        
    }
    
    //verifie a chaque tour l'etat de tt les bateaux
    static boolean winGame(Player p, Player c) {
        int destroyed =0;
        for (int i=6; i<10; i++){
            if(c.allShips()[i].destroyed) destroyed++;
        }
        if (destroyed == 4) return true;
        return false;
    }
    
    static String theWinnerIs(Player p, Player c) {
        int destroyed =0;
        for (int i=6; i<10; i++){
            if(c.allShips()[i].destroyed) destroyed++;
            
        }
        if (destroyed == 4) return p.name;
        return c.name;
    }

} 


