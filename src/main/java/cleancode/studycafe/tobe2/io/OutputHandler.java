package cleancode.studycafe.tobe2.io;

import cleancode.studycafe.tobe2.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe2.model.StudyCafePass;

import java.util.List;

public interface OutputHandler {

    void showWelcomeAndManualMessage();

    void showPassListForSelection(List<StudyCafePass> passes);

    void askLockerPass(StudyCafeLockerPass lockerPass);

    void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

    void showSimpleMessage(String message);

}
