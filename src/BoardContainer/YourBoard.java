/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardContainer;


/**
 *
 * @author paulw
 */
public class YourBoard extends Board {

    
    public YourBoard() {
        this.NameOfTheBoard = "Your Board";
    }
    //instancie chaque case de la board
    @Override
    void createGrid(){ 
        for(int i=0; i<15; i++) {
            for (int j=0; j<15; j++){
                grid[i][j] = new Box(intToChar(i), j+1, true);
            }
        }
    }
}
