public class Bowl {

    private int amount;

    public Bowl(int v) {
        this.amount = v;
    }

    public int getAmount() {
        return amount;
    }

    //6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    //2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    // (например, в миске 10 еды, а кот пытается покушать 15-20)

    //п.2 пересекается с п.4. в коте.
    public void setAmount(int amount) {
        this.amount = Math.max(amount, 0);
    }
}
