import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("В какую игру сыграем в этот раз? (1 - числа | 2 - слова)");
        Scanner choice = new Scanner(System.in);

        switch (choice.nextInt()) {
            case 1 -> {
                startGuessNumberGame(10, 3);
                break;
            }
            case 2 -> {
                startWordGuessGame();

                //второй вариант игры
                //startWordGuessGame2();
                break;
            }
            default -> System.out.println("Увидимся в следующий раз");
        }
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

                int counter = Math.min(word.length(), choice.length());

                for (int i = 0; i < counter; i++) {
                    if (word.charAt(i) == choice.charAt(i)) {
                        sb.append(word.charAt(i));
                    } else {
                        sb.append("#");
                    }
                }

                sb.append("#".repeat(15 - word.length()));

                if (!sb.toString().matches("[#]+")) {
                    System.out.printf(someLettersString, sb.toString());
                } else {
                    System.out.println(noLettersString);
                }

            } else {
                System.out.println(winString);
                input.close();
                break;
            }
        } while (true);
    }

    private static void startWordGuessGame2() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        final String greetingString = "Я загадал слово из %d букв (%s), угадайте его %n";
        final String winString = "Вы угадали!";
        final String loseString = "Вы не угадали!";
        final String noLettersString = "Таких букв в этом слове нет";
        final String someLettersString = "Но вот такие буквы в этом слове есть: %s %n";

        String word = words[new Random().nextInt(words.length - 1)];
        Scanner input = new Scanner(System.in);
        String choice;

        System.out.printf(greetingString, word.length(), word);

        do {
            choice = input.next();
            char[] letterMap = new char[word.length()];

            if (!word.equals(choice)) {
                System.out.println(loseString);

                for (int i = 0; i < word.length(); i++) {
                    for (int j = 0; j < choice.length(); j++) {
                        if (word.charAt(i) == choice.charAt(j)) {
                            letterMap[i] = word.charAt(i);
                            break;
                        } else {
                            letterMap[i] = '#';
                        }
                    }
                }

                StringBuilder sb = new StringBuilder(new String(letterMap));
                sb.append("#".repeat(15 - word.length()));

                if (!sb.toString().matches("[#]+")) {
                    System.out.printf(someLettersString, sb.toString());
                } else {
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
