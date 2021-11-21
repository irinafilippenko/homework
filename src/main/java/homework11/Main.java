package homework11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] originalArray = {"белый", "красный", "голубой", "серый", "зеленый", "красный", "голубой", "желтый", "белый", "красный", "синий", "розовый", "синий"};
        Set<String> unrepeatable = new TreeSet<>();

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(originalArray));
        Collections.addAll(unrepeatable, originalArray);
        countUnrepeatable(originalArray, unrepeatable);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Пушкин", "123");
        phoneBook.add("Лесков", "598");
        phoneBook.add("Некрасов", "005");
        phoneBook.add("Пушкин", "548");
        phoneBook.add("Гоголь", "673");
        phoneBook.add("Толстой", "028");
        phoneBook.add("Чехов", "367");
        phoneBook.add("Гоголь", "349");
        phoneBook.add("Герцен", "611");
        phoneBook.add("Пушкин", "099");

        String lastName = "Гоголь";
        System.out.printf("%nАбонент: " + lastName + " телефон: " + phoneBook.get(lastName));
    }

    private static void countUnrepeatable(String[] originalArray, Set<String> unrepeatable) {
        for (String color : unrepeatable) {
            int count = 0;
            for (String originalColor : originalArray) {
                if (color.equals(originalColor)) {
                    count++;
                }
            }
            System.out.printf("%nЦвет «%s» встречается %d раз(а).", color, count);
        }
    }
}


