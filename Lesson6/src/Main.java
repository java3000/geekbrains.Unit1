import java.util.Random;

public class Main {

    //1. Создать классы Собака и Кот с наследованием от класса Животное.
    //2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    // В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
    // или высоту (для прыжков).
    //3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м.,
    // собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
    //4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
    // (Например, dog1.run(150); -> результат: run: true)
    //5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м.,
    // у другой 600 м.
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
