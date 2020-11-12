public class Main {

    public static void main(String[] args) {

        //5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
        // потом вывести информацию о сытости котов в консоль
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
