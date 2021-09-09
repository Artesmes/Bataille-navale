package bataille.navale;
import java.util.Scanner;
import players.Computer;
import players.Player1;

/**
 *
 * @author Alexandre
 */
public class Menu {
    
    //fonction qui affiche le menu
    public static void displayMenu(){
        
        
        int menu=0;
        Scanner choix = new Scanner(System.in);//blindage des saisies
        do{
            Tools.cls();
            System.out.println("BattleShip | The Final War\n");
            System.out.println("\n [1] Play\n [2] Load Game\n [3] Option & Help\n [4] Exit Game\n==>");
            try{
                String tampon;
                tampon = choix.next();
                menu = Integer.parseInt(tampon);
            }catch(Exception InputMismatchException){
                   
                    //System.err.println("Error\nEnter valid input");
            }
        switch(menu){
            //lance le jeu avec une nouvelle partie
            case 1 : System.out.println("PLAY");
                Player1 player1 = new Player1();
                Computer computer1 = new Computer();
                player1.initShipping();
                computer1.initShipping();
                Tools.cls();
                Tools.hello();
                Play.game(player1, computer1);
                Tools.cls();
                Menu.displayMenu();
                break;
                
            case 2 :
                //lance le jeu avec une partie deja chargé
                System.out.println("LOAD GAME");
                Informations info = Informations.load();
                if (info.saveNames.size() == 0){
                    System.out.println("No game to load");
                    Tools.delay(3000);
                    displayMenu();
                    break;
                }
                System.out.println("Which game do you want to load ?");
                
                for (int i=0; i<info.saveNames.size(); i++) {
                    int j = i+1;
                    System.out.println("[" + j + "] " + info.saveNames.get(i));
                }
                int nb = choix.nextInt()-1;
                String saveName = info.saveNames.get(nb);
                
                Player1 player2;
                Computer computer2;
                
                Object[] tab = (Object[]) Save.load(saveName);
                
                player2 = (Player1) tab[0];
                computer2 = (Computer) tab[1];

                Play.game(player2, computer2);
                break;
                
            //afffiche les regles et les crédits
            case 3 : System.out.println("OPTION / HELP");
                System.out.println("Règles du jeu :\n" +
                        "\n" +
                        "Le joueur et l’ordinateur disposent chacun de deux grilles de 15*15 cases :\n" +
                        "- Une grille n°1 pour positionner et visualiser ses navires\n" +
                        "- Une grille n°2 pour visualiser les dégâts causés à l’adversaire\n" +
                        "Chaque joueur possède une flotte de 10 navires : 1 cuirassé, 2 croiseurs, 3 destroyers et 4 sous-marins\n" +
                        "\n" +
                        "- Chaque type de navire est de taille différente :\n" +
                        " type        taille\n" +
                        "cuirassé -> 7 cases\n" +
                        "croiseur -> 5 cases\n" +
                        "destroyer -> 3 cases\n" +
                        "sous-marin -> 1 case\n" +
                        "\n" +
                        "\n" +
                        "-La puissance de tir (nombre de cases touchées d’un côté ou/et de l’autre du point d’impact) dépend du\n" +
                        "type de navires :\n" +
                        "type Puissance de tir\n" +
                        "cuirassé -> 9 cases\n" +
                        "croiseur -> 4 cases\n" +
                        "destroyer -> 1 case\n" +
                        "sous-marin -> 1 case\n" +
                        "\n" +
                        "Les actions d’un navire par tour de jeu et par joueur\n" +
                        "Chaque joueur (humain et ordinateur) joue à tour de rôle.\n" +
                        "A chaque tour de jeu, les joueurs peuvent choisir l’une des 2 actions suivantes sur un seul navire de\n" +
                        "leur choix de la grille n° 1, en choisissant les coordonnées de l’une des cases du navire :\n" +
                        "-Tirer\n" +
                        "-Déplacer\n" +
                        "\n" +
                        "Le premier qui a coulé toute la flotte de son adversaire a gagné la partie !\n\n"
                        + "Jeu réalisé par Alexandre Sebire / Paul Waligora / Alan Larnaud\n\n");
                        Menu.displayMenu();
                break;
                
            //quitte le jeu    
            case 4 : System.out.println("EXIT");
                break;
            
            case 5: 
                Informations.init();
                
            default : //System.err.println("please enter a valid input\n");
                break;
        }
       }while(menu<1||menu>5);
    }
}
