package cleancode.studycafe.tobe2;

import cleancode.studycafe.tobe2.io.*;

public class StudyCafeApplication {

    public static void main(String[] args) {
        InputHandler inputHandler = new KioskInputHandler();
        OutputHandler outputHandler = new KioskOutputHandler();
        StudyCafePassMachine studyCafePassMachine =
                new StudyCafePassMachine(
                        inputHandler,
                        outputHandler,
                        new StudyCafeProcessor(new StudyCafeFileHandler())
                );
        studyCafePassMachine.run();
    }

}
