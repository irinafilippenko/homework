package homework2;

public class HomeWorkMethod {
    public static void main(String[] args) {
//        Первый, третий и пятый метод «обернуты» в System.out.println для вывода результата в консоль.
        System.out.println(within10and20(16,3));
        isPositiveOrNegative(37);
        System.out.println(isNegative(-63));
        printWordNTimes("What a Wonderful World!",3);
        System.out.println(isYearLeapYear(2000));
    }

    private static boolean within10and20(int x1, int x2) {
        int sum = x1 + x2;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        else {
            return false;
        }
    }

    private static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Данное число положительное.");
        }
        else {
            System.out.println("Данное число отрицательное.");
        }
    }

    private static boolean isNegative(int x) {
//        ноль, как и во втором пункте задания, считаем положительным числом
        if (x < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private static void printWordNTimes(String word, int times) {
        for (int i=0; i < times; i++) {
            System.out.println(word);
        }
    }

    private static boolean isYearLeapYear(int year) {
//        Проверяем правильно ли введен год (ненулевое и неотрицательное значение). Возвращаем false.
        if (year <= 0) {
            System.out.println("С периодом до нашей эры не работаем. Работаем от Рождества Христова.");
            return false;
        }
        else if (year%400 == 0 || year%4 == 0 && year%100 != 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
