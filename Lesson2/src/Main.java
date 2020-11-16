import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] first = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < first.length; i++) first[i] ^= 1;

        System.out.println(Arrays.toString(first));

        int[] second = new int[8];
        for (int i = 0; i < second.length; i++) second[i] = i * 3;

        System.out.println(Arrays.toString(second));

        int[] third = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < third.length; i++) if (third[i] < 6) third[i] *= 2;

        System.out.println(Arrays.toString(third));

        int[][] fourth = new int[5][5];
        for (int i = 0; i < fourth.length; i++) {
            fourth[i][i] = 1;
            fourth[i][(fourth.length - 1) - i] = 1;
            System.out.println(Arrays.toString(fourth[i]));
        }

        int[] fifth = new int[]{1, 5, 3, 2, 11, 4, 42, 14, 6, 8, 9, 7};
        int min = fifth[0], max = fifth[0];
        for (int x : fifth) {
            if (x < min) min = x;
            if (x > max) max = x;
        }

        System.out.printf("минимальный: %s максимальный: %s \n", min, max);
        System.out.printf("минимальный: %s максимальный: %s \n", Arrays.stream(fifth).min().getAsInt(), Arrays.stream(fifth).max().getAsInt());

        int[] arr = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        int[] arr1 = new int[]{1, 1, 1, 2, 1};

        System.out.println(checkBalance(arr));
        System.out.println(checkBalance(arr1));

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrShift(array, -1);
        System.out.println(Arrays.toString(array));
    }

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

    public static void arrShift(int[] array, int pos) {
        int step = Math.abs(pos);

        if (pos < 0) {
            while (step != 0) {
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] ^= array[i + 1];
                    array[i + 1] ^= array[i];
                    array[i] ^= array[i + 1];
                }
                step--;
            }
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
