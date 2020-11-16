public class Bowl {

    private int amount;
    private final int maximum;

    public Bowl(int v) {
        amount = maximum = v;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount =  (amount > 0 ) ? amount : maximum;
    }
}
