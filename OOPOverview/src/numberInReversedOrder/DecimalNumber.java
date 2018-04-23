package numberInReversedOrder;

public class DecimalNumber {
    private String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public void printReversed() {
        StringBuilder sb = new StringBuilder(this.number);
        System.out.println(sb.reverse());
    }
}
