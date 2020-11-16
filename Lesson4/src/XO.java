import java.util.Random;
import java.util.Scanner;

public class XO {

    protected static final int SIZE = 3;
    protected static final char DOT_X = 'X';
    protected static final char DOT_O = 'O';
    protected static final char DOT_EMPTY = '.';
    private boolean SILLY_MODE = false;

    protected static char[][] map;
    private final Random random;
    private final Scanner scanner;

    XO() {
        random = new Random();
        scanner = new Scanner(System.in);
        map = new char[SIZE][SIZE];
    }

    public static void main(String[] args) {
        new XO().game();
    }

    void game() {

        System.out.printf("Приветствую тебя, %s! Выбери уровень сложности: \n", System.getProperty("user.name"));
        System.out.println("0 - \"я банан\" или 1 - \"круче только горы\"  ");

        SILLY_MODE = scanner.nextInt() != 1;

        initMap();

        while (true) {

            printMap();

            humanTurn();
            if (checkWin()) break;
            aiTurn();
            if (checkWin()) break;
        }
        System.out.println("Игра окончена.");
    }

    private boolean checkWin() {
        if (isWin(DOT_X)) {
            System.out.println("Вы победили!");
            printMap();
            return true;
        }
        if (isWin(DOT_O)) {
            System.out.println("Победил ИИ!");
            printMap();
            return true;
        }
        if (isTableFull()) {
            System.out.println("Ничья!");
            printMap();
            return true;
        }
        return false;
    }

    void initMap() {
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++)
                map[row][col] = DOT_EMPTY;
    }

    public void printMap() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++)
                System.out.print(map[row][col] + " ");
            System.out.println();
        }
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки (X Y) oт 1 до " + SIZE);
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y;

        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        } else {
            MiniMax.Move bestMove = MiniMax.findBestMove(map);
            x = bestMove.row;
            y = bestMove.col;
        }
        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY;
    }

    boolean isWin(char dot) {

        for (int row = 0; row < SIZE; row++) {
            int count = 0;

            for (int i = 0; i < SIZE; i++) {
                if (map[row][i] == dot) count += 1;
            }
            if (count == SIZE) return true;
        }

        for (int col = 0; col < SIZE; col++) {
            int count = 0;

            for (int i = 0; i < SIZE; i++) {
                if (map[i][col] == dot) count += 1;
            }
            if (count == SIZE) return true;
        }

        for (int row = 0; row < SIZE; row++) {
            int count = 0;
            for (int i = 0; i < SIZE; i++) {
                if (map[i][i] == dot) count += 1;
            }
            if (count == SIZE) {
                return true;
            }

            count = 0;
            for (int i = SIZE - 1; i > 0; i--) {
                if (map[i][i] == dot) count += 1;
            }
            if (count == SIZE) {
                return true;
            }
        }

        return false;
    }

    boolean isTableFull() {
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++)
                if (map[row][col] == DOT_EMPTY)
                    return false;
        return true;
    }
}



