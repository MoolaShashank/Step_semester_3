public class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String initialCombination) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCombination;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}
