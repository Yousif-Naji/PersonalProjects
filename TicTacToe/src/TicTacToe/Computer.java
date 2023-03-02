package TicTacToe;

import java.util.ArrayList;
import java.util.Random;
public class Computer extends Player {
    public Computer() {
        super('O', false);
    }
    public void activateComputer() {
        ArrayList<Integer> computerChoices = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            computerChoices.add(i);
        }
        int computerMove = (int) Math.random() * computerChoices.size();
        computerChoices.remove(computerMove);
    }
}
