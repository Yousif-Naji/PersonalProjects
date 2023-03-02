package TicTacToe;

/**
    The following class is responsible for the grid of the game to be played on.
    @author
 */
public class Grid {
    private int[][] gameGrid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    public int[][] getGameGrid() {
        return gameGrid;
    }
    public void resetGame() {
        int[][] newGrid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        gameGrid = newGrid;
    }
    private boolean checkRow(int row) {
        return this.gameGrid[row][0] != 0 && this.gameGrid[row][0] == this.gameGrid[row][1] && this.gameGrid[row][0] == this.gameGrid[row][2];
    }
    private boolean checkColumn(int column) {
        return this.gameGrid[0][column] != 0 && this.gameGrid[0][column] == this.gameGrid[1][column] && this.gameGrid[0][column] == this.gameGrid[2][column];
    }
    public int isGameOver() {
        boolean row1 = this.checkRow(0);
        boolean row2 = this.checkRow(1);
        boolean row3 = this.checkRow(2);
        boolean col1 = this.checkColumn(0);
        boolean col2 = this.checkColumn(1);
        boolean col3 = this.checkColumn(2);
        boolean diagonal1 = this.gameGrid[0][0] != 0 && this.gameGrid[0][0] == this.gameGrid[1][1] && this.gameGrid[0][0] == this.gameGrid[2][2];
        boolean diagonal2 = this.gameGrid[0][2] != 0 && this.gameGrid[0][2] == this.gameGrid[1][1] && this.gameGrid[0][2] == this.gameGrid[2][0];
        if (row1 || col1 || diagonal1) {
            return this.gameGrid[0][0];
        } else if (row2 || col2 || diagonal2) {
            return this.gameGrid[1][1];
        } else if (row3 || col3) {
            return this.gameGrid[0][2];
        } else {
            return 0;
        }
    }
}
