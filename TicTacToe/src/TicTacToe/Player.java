package TicTacToe;

/**
 * Player class represents a player in a tic-tac-toe game with their properties.
 * @author Yousif Naji
 */

public class Player {
    private final char name;
    private boolean isTurn;
    public Player(char name, boolean isTurn) {
        this.name = name;
        this.isTurn = isTurn;
    }
    public char getName() {
        return this.name;
    }

    public int moveRepresentation() {
        if (this.name == 'X') {
            return 1;
        } else {
            return 2;
        }
    }

}
