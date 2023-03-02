package TicTacToe;
/**
    TicTacToe game with TicTacToe application.
    @author Yousif Naji
 */
import java.util.Scanner;
import java.util.Arrays;
public class TicTacToe {
    private Grid grid;
    public static char[][] gameBoard;
    private Player xPlayer;
    private Player oPlayer;
    private GUI gameGUI;
    private int gameTurn = 0;
    public static TicTacToe xoGame;
    public TicTacToe() {
        this.grid = new Grid();
        this.xPlayer = new Player('X', true);
        this.oPlayer = new Player('O', false);
        this.gameGUI = new GUI();
        this.gameBoard = new char[3][3];
    }
    public void makeMove(int row, int column) {
        try {
            if (gameTurn % 2 == 0 && xoGame.grid.getGameGrid()[row][column] == 0) {
                this.grid.getGameGrid()[row][column] = xPlayer.moveRepresentation();
                this.gameBoard[row][column] = xPlayer.getName();
            } else if (gameTurn % 2 != 0 && xoGame.grid.getGameGrid()[row][column] == 0) {
                this.grid.getGameGrid()[row][column] = oPlayer.moveRepresentation();
                this.gameBoard[row][column] = oPlayer.getName();
            } else {
                return;
            }
            gameTurn++;
        } catch (Exception e) {
            return;
        }
    }
    public Grid getGrid() {
        return this.grid;
    }

    public void resetBoard() {
        char[][] newBoard = new char[3][3];
        gameBoard = newBoard;
    }
    public static void main(String[] args) {
        xoGame = new TicTacToe();
        Scanner input = new Scanner(System.in);
        int turn = 0;
        while (xoGame.grid.isGameOver() == 0) {
            int row;
            int col;
            int position;
            System.out.println("Enter your play: ");
            try {
                position = input.nextInt();
            }
            catch (Exception e) {
                System.out.println("Invalid input, try again.");
                break;
            }
            if (position > 0 && position < 4) {
                row = 0;
                col = position - 1;
            } else if (position > 3 && position < 7) {
                row = 1;
                col = position - 4;
            } else if (position > 6 & position < 10) {
                row = 2;
                col = position - 7;
            } else {
                System.out.println("Invalid position chosen, try again.");
                continue;
            }
            if (turn % 2 == 0 && xoGame.grid.getGameGrid()[row][col] == 0) {
                xoGame.grid.getGameGrid()[row][col] = xoGame.xPlayer.moveRepresentation();
                xoGame.gameBoard[row][col] = 'X';
            } else if (turn % 2 != 0 && xoGame.grid.getGameGrid()[row][col] == 0) {
                xoGame.grid.getGameGrid()[row][col] = xoGame.oPlayer.moveRepresentation();
                xoGame.gameBoard[row][col] = 'O';
            } else {
                System.out.println("Slot already taken, try again.");
                continue;
            }
            turn++;
            System.out.println(Arrays.deepToString(xoGame.gameBoard));
        }
        System.out.println("Done");
    }
}
