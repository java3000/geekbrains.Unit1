import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] first = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < first.length; i++) first[i] ^= 1; //some magic ;)

        //[0, 0, 1, 1, 0, 1, 0, 0, 1, 1]
        System.out.println(Arrays.toString(first));


        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] second = new int[8];
        for (int i = 0; i < second.length; i++) second[i] = i * 3;

        //[0, 3, 6, 9, 12, 15, 18, 21]
        System.out.println(Arrays.toString(second));


        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньшие 6 умножить на 2;
        int[] third = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < third.length; i++) if (third[i] < 6) third[i] *= 2;

        //[2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2]
        System.out.println(Arrays.toString(third));


        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
        // цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] fourth = new int[5][5];
        for (int i = 0; i < fourth.length; i++) {
            fourth[i][i] = 1;
            fourth[i][(fourth.length - 1) - i] = 1;
            System.out.println(Arrays.toString(fourth[i]));
        }


        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] fifth = new int[]{1, 5, 3, 2, 11, 4, 42, 14, 6, 8, 9, 7};
        int min = fifth[0], max = fifth[0];
        for (int x : fifth) {
            if (x < min) min = x;
            if (x > max) max = x;
        }

        //минимальный: 1 максимальный: 42
        System.out.printf("минимальный: %s максимальный: %s \n", min, max);
        //...ну не мог, не мог я не попробовать стримы)))
        System.out.printf("минимальный: %s максимальный: %s \n", Arrays.stream(fifth).min().getAsInt(), Arrays.stream(fifth).max().getAsInt());


        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        int[] arr = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        int[] arr1 = new int[]{1, 1, 1, 2, 1};

        //суммы равны в позиции: 7
        //true
        //суммы равны в позиции: 4
        //true
        //[2, 3, 4, 5, 6, 7, 8, 9, 1]
        //
        //Process finished with exit code 0
        System.out.println(checkBalance(arr));
        System.out.println(checkBalance(arr1));


        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrShift(array, -1);

        //[2, 3, 4, 5, 6, 7, 8, 9, 1] <-- -1 = влево на 1, в итоге показалась справа, последней
        //[9, 1, 2, 3, 4, 5, 6, 7, 8] --> 1 = вправо на 1, в итоге вынырнула слева, первой
        System.out.println(Arrays.toString(array));
    }

    //просто двигаем границу слева напрво. если есть, то сумма обеих частей спавняется
    public static boolean checkBalance(int[] arr) {
        int leftSum = 0, rightSum = 0;
        int step = 0;

        while (step < arr.length) {
            for (int i = 0; i < step; i++) {
                leftSum += arr[step];
            }

            for (int i = step + 1; i < arr.length; i++) {
                rightSum += arr[i];
            }

            if (leftSum == rightSum) {
                System.out.println("суммы равны в позиции: " + step);
                return true;
            }
            step++;
        }
        return false;
    }

    //классический swap. лучше не придумал.
    public static void arrShift(int[] array, int pos) {
        int step = Math.abs(pos);

        //<-- -4
        if (pos < 0) {
            while (step != 0) {
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] ^= array[i + 1];
                    array[i + 1] ^= array[i];
                    array[i] ^= array[i + 1];
                }
                step--;
            }
            // -->
        } else if (pos > 0) {
            while (step != 0) {
                for (int i = array.length - 1; i > 0; i--) {
                    array[i] ^= array[i - 1];
                    array[i - 1] ^= array[i];
                    array[i] ^= array[i - 1];
                }
                step--;
            }
        }
    }
}
