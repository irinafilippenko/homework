package homework10;

public class Main {
    public static void main(String[] args) {
        String array1[] = {"element1", "element2", "element3", "element4", "element5"};
        Integer array2[] = {11, 22, 13, 14, 15};

        display(array1);
        swap(array1, 1, 2);
        System.out.println("Измененный массив:");
        display(array1);

        Box<Orange> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
        Box<Apple> box3 = new Box<>();
        Box<Orange> box4 = new Box<>();

        for (int i = 0; i < 7; i++) {
            box1.add(new Orange());
        }
        for (int i = 0; i < 3; i++) {
            box2.add(new Apple());
        }
        for (int i = 0; i < 5; i++) {
            box3.add(new Apple());
        }
        for (int i = 0; i < 4; i++) {
            box4.add(new Orange());
        }
        System.out.println("Вес первой коробки: " + box1.getWeight());
        System.out.println("Вес второй коробки: " + box2.getWeight());
        System.out.println("Вес третьей коробки: " + box3.getWeight());
        System.out.println("Вес четвертой коробки: " + box4.getWeight());

        System.out.println("Результат сравнения веса первой и второй коробок: " + box1.compareBox(box2));
        System.out.println("Результат сравнения веса третьей и четвертой коробок: " + box3.compareBox(box4));

        if (box3.transferTo(box2)) {
            System.out.println("Фрукты пересыпаны.");
            System.out.println("Вес первой коробки: " + box1.getWeight());
            System.out.println("Вес второй коробки: " + box2.getWeight());
            System.out.println("Вес третьей коробки: " + box3.getWeight());
            System.out.println("Вес четвертой коробки: " + box4.getWeight());
        } else {
            System.out.println("Фрукты не совпадают и не пересыпаны.");
        }
    }

    private static void display(Object[] array) {
        for (Object datum : array) {
            System.out.println(datum + " ");
        }
        System.out.println();
    }

    private static void swap(Object[] array, int index1, int index2) {
        Object swap = array[index1];
        array[index1] = array[index2];
        array[index2] = swap;
    }
}
