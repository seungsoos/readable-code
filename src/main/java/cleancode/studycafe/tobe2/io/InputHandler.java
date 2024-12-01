package cleancode.studycafe.tobe2.io;

import cleancode.studycafe.tobe2.model.StudyCafePass;
import cleancode.studycafe.tobe2.model.StudyCafePassType;

import java.util.List;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();
}
