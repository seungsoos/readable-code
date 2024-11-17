package cleancode.minesweeper.tobe.cell;

public class NumberCell extends Cell {

    private int nearbyLandMineCount;

    public NumberCell(int nearbyLandMineCount) {
        this.nearbyLandMineCount = nearbyLandMineCount;
    }

    @Override
    public String getSign() {
        if (isOpened) {
            return String.valueOf(nearbyLandMineCount);
        }
        if (isFlagged) {
            return FLAG_SIGN;
        }
        return UNCHECKED_SIGN;
    }


    @Override
    public boolean hasLandMineCount() {
        return true;
    }

    @Override
    public boolean isLandMine() {
        return false;
    }
}
