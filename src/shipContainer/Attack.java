package shipContainer;

import players.Player;

public interface Attack {
    
    boolean shoot(char posX ,int posY, Player enemy);
    
}
