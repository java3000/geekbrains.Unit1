import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Dog[] dogs = {new Dog(), new Dog(), new Dog(), new Dog(), new Dog(), new Dog()};
        Cat[] cats = {new Cat(), new Cat(), new Cat(), new Cat(), new Cat(), new Cat()};

        System.out.println("=== собаки ===");
        for (Dog dog : dogs) {
            System.out.println(dog.run(new Random().nextInt(100)));
            System.out.println(dog.jump(new Random().nextInt(10)));
            System.out.println(dog.swim(new Random().nextInt(10)));
            System.out.println("----------");
        }

        System.out.println("=== кошки ===");
        for (Cat cat : cats) {
            System.out.println(cat.run(new Random().nextInt(100)));
            System.out.println(cat.jump(new Random().nextInt(10)));
            System.out.println(cat.swim(new Random().nextInt(10)));
            System.out.println("----------");
        }
    }
}
