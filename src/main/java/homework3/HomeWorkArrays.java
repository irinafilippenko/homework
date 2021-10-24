package homework3;

import java.util.Arrays;

public class HomeWorkArrays {
    public static void main(String[] args) {
//        Первый пункт задания (2 варианта).
        invertArray1();
        invertArray2();
//        Второй пункт задания.
        fillArray();
//        Третий пункт задания.
        changeArray();
//        Четвертый пункт задания.
        fillDiagonal();
//        Пятый пункт задания.
        createArray(15, -2);
//        Шестой пункт задания.
        findMinMax();
//        Седьмой пункт задания.
        comparisonLeftRightArray(new int[]{2, 2, 2, 1, 2, 2, 10, 1});
//        Восьмой пункт задания.
        shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 30506);
    }

    private static void invertArray1() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Домашнее задание к уроку 3. Пункт 1. Вариант 1.");
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (++arr[i] > 1) {
                arr[i] = 0;
            }
        }
        System.out.println("Преобразованный массив:");
        System.out.println(Arrays.toString(arr));
    }

    private static void invertArray2() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Домашнее задание к уроку 3. Пункт 1. Вариант 2.");
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Преобразованный массив:");
        System.out.println(Arrays.toString(arr));
    }

    private static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("Домашнее задание к уроку 3. Пункт 2.");
//Вывод массива построчно (по 10 элементов в строке).
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d", arr[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    private static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Домашнее задание к уроку 3. Пункт 3.");
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println("Преобразованный массив:");
        System.out.println(Arrays.toString(arr));
    }

    private static void fillDiagonal() {
        int[][] arr = new int[4][4];
        int countdown;
        int length = 4;
        System.out.println("Домашнее задание к уроку 3. Пункт 4.");
        System.out.println("Исходный массив:");
        for (int[] datum : arr) {
            for (int num : datum) {
                System.out.printf("%3d", num);
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            countdown = length - i - 1;
            arr[i][i] = 1;
            arr[i][countdown] = 1;
        }
        System.out.println("Преобразованный массив:");
        for (int[] datum : arr) {
            for (int num : datum) {
                System.out.printf("%3d", num);
            }
            System.out.println();
        }
    }

    private static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        System.out.println("Домашнее задание к уроку 3. Пункт 5.");
        System.out.println("Возвращаемый массив:");
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static void findMinMax() {
        int[] arr = {1, 7, 12, 121, -9, 15, 0, -8, 136, 49, 63};
        int min, max;
        min = max = arr[0];
        System.out.println("Домашнее задание к уроку 3. Пункт 6.");
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max);
    }

    private static boolean comparisonLeftRightArray(int[] arr) {
        int length = arr.length;
        int leftSum = arr[0];
        int rightSum = arr[length - 1];
        int leftLimit = 0;
        int rightLimit = length - 1;
        System.out.println("Домашнее задание к уроку 3. Пункт 7.");
        if (length < 4) {
            System.out.println("Задан массив с количеством элементов меньше 4. Сравнение сумм невозможно.");
            return false;
        } else {
            do {
                if (leftSum < rightSum) {
                    leftLimit++;
                    leftSum += arr[leftLimit];
                } else {
                    rightLimit--;
                    rightSum += arr[rightLimit];
                }
            } while ((rightLimit - leftLimit) != 1);
//            Вывод массива с разделением на левую и правую части.
            for (int i = 0; i < length; i++) {
                System.out.print(" " + arr[i]);
                if (i == leftLimit) {
                    System.out.print(" |||");
                }
            }
            System.out.println();
//            Результат. Сравнение итоговых сумм.
            if (leftSum == rightSum) {
                System.out.println("Есть такое место. Суммы левой и правой части равны.");
                return true;
            } else {
                System.out.println("Суммы левой и правой части не равны.");
                return false;
            }
        }
    }

    private static void shiftArray(int[] arr, int n) {
        int length = arr.length;
        int shiftElement;
        System.out.println("Домашнее задание к уроку 3. Пункт 8.");
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));
        n = n % length;
        if (n > 0) {
            for (int j = 0; j < n; j++) {
//                Сдвиг вправо на один элемент.
                shiftElement = arr[length - 1];
                for (int i = (length - 1); i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = shiftElement;
            }
        } else if (n < 0) {
            for (int j = 0; j > n; j--) {
//                Сдвиг влево на один элемент.
                shiftElement = arr[0];
                for (int i = 0; i < (length - 1); i++) {
                    arr[i] = arr[i + 1];
                }
                arr[length - 1] = shiftElement;
            }
        } else {
            System.out.println("Задан нулевой шаг смещения. Массив остается без смещения.");
        }
        System.out.println("Смещенный массив:");
        System.out.println(Arrays.toString(arr));
    }
}