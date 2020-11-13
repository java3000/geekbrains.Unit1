public class Bowl {

    private int amount;
    private final int maximum;

    public Bowl(int v) {
        amount = maximum = v;
    }

    public int getAmount() {
        return amount;
    }

    //6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    //2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    // (например, в миске 10 еды, а кот пытается покушать 15-20)

    //п.2 пересекается с п.4. в коте.
    public void setAmount(int amount) {
        this.amount =  (amount > 0 ) ? amount : maximum;
    }
}
