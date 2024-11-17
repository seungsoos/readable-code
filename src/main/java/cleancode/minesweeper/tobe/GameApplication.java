package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Beginner;
import cleancode.minesweeper.tobe.gamelevel.VeryBeginner;

public class GameApplication {

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper(new Beginner());
        minesweeper.run();
    }
}
