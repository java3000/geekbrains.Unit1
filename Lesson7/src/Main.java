public class Main {

    public static void main(String[] args) {

        Cat[] cats = {new Cat(), new Cat(), new Cat(), new Cat(), new Cat(), new Cat()};
        Bowl bowl = new Bowl(10);

        for (Cat cat : cats) {
            System.out.printf("поел ли котик с аппетитом %d из миски с кол-вом еды %d : %s %n",
                    cat.getFoodAmount(),
                    bowl.getAmount(),
                    cat.eat(bowl));
        }
    }
}
