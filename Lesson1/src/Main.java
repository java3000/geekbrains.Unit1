
public class Main {

    byte b = 1;
    char c = 'a';
    int i = 1;
    long l = 100500L;
    double d = 0.31415;
    float f = 0.314f;
    boolean bool = true;
    String str = "строка";

    public static void main(String[] args) {

        System.out.println(compute(2, 3, 6, 2));
        System.out.println(isInRange(5, 7));
        isNegativeOrPositive(-1);
        System.out.println(isNegative(-1));
        hello("Вася");
        isLeap(2021);
    }

    public static int compute(int a, int b, int c, int d) {
        return (d != 0) ? a * (b + (c / d)) : 0;
    }

    public static boolean isInRange(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    public static void isNegativeOrPositive(int a) {
        System.out.println((a < 0) ? "отрицательное" : "положительное");
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void hello(String str) {
        System.out.printf("Привет, %s!\n", str);
    }

    public static void isLeap(int year) {
        System.out.println(((year % 4 == 0 && !(year % 100 == 0)) || (year % 400 == 0)) ? "Високосный год" : "Не високосный год");
    }
}
