package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.game.GameInitializable;
import cleancode.minesweeper.tobe.game.GameRunnable;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

public class Minesweeper implements GameInitializable, GameRunnable {

    private static int gameStatus = 0; // 0: 게임 중, 1: 승리, -1: 패배
    public Minesweeper(GameLevel gameLevel, InputHandler inputHandler, OutputHandler outputHandler) {
        gameBoard = new GameBoard(gameLevel);
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }
    private final GameBoard gameBoard;
    private final BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    @Override
    public void initialize() {
        gameBoard.initializeGame();
    }

    @Override
    public void run() {
        outputHandler.showGameStartComments();

        while (true) {
            try {
                outputHandler.showBoard(gameBoard);

                if (doesUserWinTheGame()) {
                    outputHandler.showGameWinningComment();
                    break;
                }
                if (doseUserLoseTheGame()) {
                    outputHandler.showGameLosingComment();
                    break;
                }

                String cellInput = getCellInputFromUser();
                String userActionInput = getCellActionFromUser();
                actOnCell(cellInput, userActionInput);
            } catch (GameException e) {
                outputHandler.showExceptionMessage(e);
            } catch (Exception e) {
                outputHandler.showSimpleMessage("예상치못한 문제입니다.");
            }
        }
    }


    private void actOnCell(String cellInput, String userActionInput) {
        int selectedColIndex = boardIndexConverter.getSelectedColIndex(cellInput, gameBoard.getColSize());
        int selectedRowIndex = boardIndexConverter.getSelectedRowIndex(cellInput, gameBoard.getRowSize());

        if (doesUserChooseToPlantFlag(userActionInput)) {
            gameBoard.flag(selectedRowIndex, selectedColIndex);
            checkIfGameIsOver();
            return;
        }

        if (doseUserChooseToOpenCell(userActionInput)) {
            if (gameBoard.isLandMineCell(selectedRowIndex, selectedColIndex)) {
                gameBoard.open(selectedRowIndex, selectedColIndex);
                changeGameStatusToLose();
                return;
            }

            gameBoard.openSurroundedCells(selectedRowIndex, selectedColIndex);
            checkIfGameIsOver();
            return;
        }

        throw new GameException("잘못된 번호를 선택하셨습니다.");
    }

    private void changeGameStatusToLose() {
        gameStatus = -1;
    }


    private boolean doseUserChooseToOpenCell(String userActionInput) {
        return userActionInput.equals("1");
    }

    private boolean doesUserChooseToPlantFlag(String userActionInput) {
        return userActionInput.equals("2");
    }

    private String getCellActionFromUser() {
        outputHandler.showCommentForUserAction();
        return inputHandler.getUserInput();
    }

    private String getCellInputFromUser() {
        outputHandler.showCommentForSelectingCell();
        return inputHandler.getUserInput();
    }

    private boolean doseUserLoseTheGame() {
        return gameStatus == -1;
    }

    private boolean doesUserWinTheGame() {
        return gameStatus == 1;
    }

    private void checkIfGameIsOver() {
        if (gameBoard.isAllCellChecked() ) {
            gameStatus = 1;
        }
    }

}
