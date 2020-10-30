import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //1. Написать программу, которая загадывает случайное число от 0 до 9,
    // и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос –
    // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    //2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
    // "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
    // "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
    // Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.

    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово
    //Используем только маленькие буквы

    public static void main(String[] args) {
        //выбор игры
        System.out.println("В какую игру сыграем в этот раз? (1 - числа | 2 - слова)");
        Scanner choice = new Scanner(System.in);

        //запустить игру
        switch (choice.nextInt()){
            case 1:
            {
                startGuessNumberGame(10, 3);
                break;
            }

            case 2:
            {
                startWordGuessGame();
                break;
            }
            default:
                System.out.println("Увидимся в следующий раз");

        }


        //заново.
    }

    private static void startGuessNumberGame(int seed, int count) {

        int number, choice;

        final String greetingString = "Я загадал число от 0 до %s, угадайте его за %s попыток";
        final String finalString = "Повторить игру еще раз? 1 – да / 0 – нет";
        final String victoryString = "Поздравляю! Вы угадали";
        final String aboveString = "Мое число больше";
        final String belowString = "Мое число меньше";
        final String myNumberIs = "Мое число было: ";

        Scanner input = new Scanner(System.in);

        do {
            System.out.printf(greetingString + "%n", seed - 1, count);
            number = new Random().nextInt(seed);
            int step = count;

            while (step > 0) {
                choice = input.nextInt();
                if (choice > number) System.out.println(belowString);
                else if (choice < number) System.out.println(aboveString);
                else {
                    System.out.println(victoryString);
                    break;
                }
                step--;
            }

            System.out.println(myNumberIs + number);
            System.out.println(finalString);
            choice = input.nextInt();

        } while (choice != 0);

        input.close();
    }

    private static void startWordGuessGame() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        final String greetingString = "Я загадал слово из %d букв, угадайте его %n";
        final String winString = "Вы угадали!";
        final String loseString = "Вы не угадали!";
        final String noLettersString = "Таких букв в этом слове нет";
        final String someLettersString = "Но вот такие буквы в этом слове есть: %s %n";

        String word = words[new Random().nextInt(words.length - 1)];
        Scanner input = new Scanner(System.in);
        String choice;

        System.out.printf(greetingString, word.length());


        do {
            choice = input.next();
            if (!word.equals(choice)) {
                System.out.println(loseString);

                StringBuilder sb = new StringBuilder();

                //сравниваем слова. Точно по месту расположения символов
                //...при этом есть смысл сравнивать буквы только по наименьшему из слов.
                int counter = Math.min(word.length(), choice.length());

                for (int i = 0; i < counter; i++) {
                    if (word.charAt(i) == choice.charAt(i)) {
                        sb.append(word.charAt(i));
                    } else {
                        sb.append("#");
                    }
                }

                //дополняем строку для секретности
                for (int i = 0; i < 15 - word.length(); i++) {
                    sb.append("#");
                }

                //проверка, угадали ли мы хоть что-нибудь или все состоит их "#"
                if (!sb.toString().matches("[#]+")){
                    System.out.printf(someLettersString, sb.toString());
                }
                else {
                    System.out.println(noLettersString);
                }

            } else {
                System.out.println(winString);
                input.close();
                break;
            }
        } while (true);
    }
}
