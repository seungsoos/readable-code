package cleancode.studycafe.tobe2;

import cleancode.studycafe.tobe2.exception.AppException;
import cleancode.studycafe.tobe2.io.*;
import cleancode.studycafe.tobe2.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe2.model.StudyCafePass;
import cleancode.studycafe.tobe2.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeProcessor studyCafeProcessor;

    public StudyCafePassMachine(InputHandler inputHandler, OutputHandler outputHandler, StudyCafeProcessor studyCafeProcessor) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.studyCafeProcessor = studyCafeProcessor;
    }

    public void run() {
        try {
            outputHandler.showWelcomeAndManualMessage();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            List<StudyCafePass> studyCafePassDetails = studyCafeProcessor.getStudyCafePassInfo(studyCafePassType);
            outputHandler.showPassListForSelection(studyCafePassDetails);
            StudyCafePass selectedPass = inputHandler.getSelectPass(studyCafePassDetails);

            StudyCafeLockerPass studyCafeLockerPassInfo = studyCafeProcessor.getStudyCafeLockerPassInfo(selectedPass);

            if (studyCafeLockerPassInfo == null) {
                outputHandler.showPassOrderSummary(selectedPass, null);
                return;
            }

            outputHandler.askLockerPass(studyCafeLockerPassInfo);
            boolean lockerSelection = inputHandler.getLockerSelection();

            if (lockerSelection) {
                outputHandler.showPassOrderSummary(selectedPass, studyCafeLockerPassInfo);
                return;
            }
            outputHandler.showPassOrderSummary(selectedPass, null);


        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

}
