package cleancode.minesweeper.tobe.cell;

public class EmptyCell extends Cell {
    private final String EMPTY_SIGN = "■";


    @Override
    public String getSign() {
        if (isOpened) {
            return String.valueOf(EMPTY_SIGN);
        }
        if (isFlagged) {
            return FLAG_SIGN;
        }
        return UNCHECKED_SIGN;
    }

    @Override
    public boolean hasLandMineCount() {
        return false;
    }

    @Override
    public boolean isLandMine() {
        return false;
    }
}
