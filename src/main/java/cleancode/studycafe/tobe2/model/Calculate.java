package cleancode.studycafe.tobe2.model;

public class Calculate {

    public int discountCalculate(StudyCafePass selectedPass) {
        return (int) (selectedPass.getPrice() * selectedPass.getDiscountRate());
    }

    public int totalCalculate(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
        return selectedPass.getPrice() - discountCalculate(selectedPass) + (lockerPass != null ? lockerPass.getPrice() : 0);
    }
}
