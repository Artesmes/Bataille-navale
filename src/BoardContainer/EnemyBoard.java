package BoardContainer;

public class EnemyBoard extends Board {

    public EnemyBoard() {
        this.NameOfTheBoard = "Enemy Board";
    }
    
    //instancie chaque case de la board
    @Override
    void createGrid(){ 
        for(int i=0; i<15; i++) {
            for (int j=0; j<15; j++){
                grid[i][j] = new Box(intToChar(i), j+1, false);
            }
        }
    }
    //indique que chaque case du plateau eneme n'est pas revelé
    public void revealAllBoard() {
        for(int i=0; i<15; i++) {
            for(int j=0; j<15; j++) {
                goToBox(intToChar(j), i).revealed = true;
            }
        }        
    }
}
