package homework7;

import java.util.Scanner;

public class MainClass {
    private static final Scanner in = new Scanner(System.in);
    private static int food;

    public static void main(String[] args) {
        int fullCats;
        boolean isFirstRound;
        isFirstRound = true;

        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Кузя");
        Cat cat4 = new Cat("Пушок");
        Cat cat5 = new Cat("Плохиш");
        Cat cat6 = new Cat("Малышок");
        Cat[] cats = {cat1, cat2, cat3, cat4, cat5, cat6};

        defineFood();
        Plate plate = new Plate(food);

        do {
            plate.info();

            if (!isFirstRound) {
                addFood(plate);
            } else {
                isFirstRound = false;
            }

            fullCats = feedCats(cats, plate);

            fullCats(cats, fullCats);
            hungryCats(cats, fullCats);
            plate.info();
        } while (isContinueFeedCats());

    }

    private static void defineFood() {
        while (true) {
            System.out.print("Дайте котикам поесть. Введите количество еды в тарелке: ");

            if (in.hasNextInt()) {
                food = in.nextInt();
                break;
            } else {
                in.next();
                System.out.println("\nКоличество еды должно быть целым числом.");
            }
        }
    }

    private static void addFood(Plate plate) {
        while (true) {
            System.out.print("Укажите сколько вы хотите добавить еды в тарелке: ");

            plate.info();

            if (in.hasNextInt()) {
                food = plate.getFood();
                food += in.nextInt();
                plate.setFood(food);
                plate.info();
                break;
            } else {
                in.next();
                System.out.println("\nКоличество еды должно быть целым числом.");
            }
        }
    }

    private static int feedCats(Cat[] cats, Plate plate) {
        int fullCats;
        fullCats = 0;

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.info();
            System.out.println();
            fullCats = i;
            if (!cats[i].isFull()) {
                fullCats = i - 1;
                break;
            }
        }

        return fullCats;
    }

    private static void fullCats(Cat[] cats, int fullCats) {
        if (fullCats >= 0) {
            System.out.println("Сыты котики:");
            for (int i = 0; i <= fullCats; i++) {
                System.out.print(" " + cats[i].getName());
            }
            System.out.println();
        } else {
            System.out.println("Еды очень мало. Даже одному не хватило!");
        }
    }

    private static void hungryCats(Cat[] cats, int fullCats) {
        if ((fullCats + 1) < cats.length) {
            System.out.println("Голодные котики:");
            for (int i = (fullCats + 1); i < cats.length; i++) {
                System.out.print(" " + cats[i].getName());
            }
            System.out.println();
        } else {
            System.out.println("Все котики сыты и довольны!");
        }
    }

    private static boolean isContinueFeedCats() {
        System.out.println("Хотите продолжить? y/n");
        return switch (in.next()) {
            case "y", "yes" -> true;
            default -> false;
        };
    }

}
