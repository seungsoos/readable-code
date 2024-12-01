package cleancode.studycafe.tobe2;

import cleancode.studycafe.tobe2.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe2.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe2.model.StudyCafePass;
import cleancode.studycafe.tobe2.model.StudyCafePassType;

import java.util.List;

public class StudyCafeProcessor {

    private final StudyCafeFileHandler studyCafeFileHandler;

    public StudyCafeProcessor(StudyCafeFileHandler studyCafeFileHandler) {
        this.studyCafeFileHandler = studyCafeFileHandler;
    }

    public List<StudyCafePass> getStudyCafePassInfo(StudyCafePassType studyCafePassType) {
        List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
        return studyCafePasses.stream()
                .filter(studyCafePass -> studyCafePass.getPassType().equals(studyCafePassType))
                .toList();

    }

    public StudyCafeLockerPass getStudyCafeLockerPassInfo(StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();
        return lockerPasses.stream()
                .filter(option ->
                        option.getPassType() == selectedPass.getPassType()
                                && option.getDuration() == selectedPass.getDuration()
                )
                .findFirst()
                .orElse(null);
    }
}
