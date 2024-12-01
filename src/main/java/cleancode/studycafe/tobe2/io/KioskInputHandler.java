package cleancode.studycafe.tobe2.io;

import cleancode.studycafe.tobe2.exception.AppException;
import cleancode.studycafe.tobe2.model.StudyCafePass;
import cleancode.studycafe.tobe2.model.StudyCafePassType;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KioskInputHandler implements InputHandler{

    private final Scanner SCANNER = new Scanner(System.in);

    @Override
    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInputPassType = SCANNER.nextLine();

        return Arrays.stream(StudyCafePassType.values())
                .filter(type -> type.number.equals(userInputPassType))
                .findFirst()
                .orElseThrow(() -> new AppException("잘못된 입력입니다."));
    }

    @Override
    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return "1".equals(userInput);
    }

    @Override
    public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        return passes.get(selectedIndex);
    }

}
