package homework6;

import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static int distance;
    private static String canOrNot;

    public static void main(String[] args) {
        Animal dog1 = new Dog("Бобик", 2, "терьер");
        Animal dog2 = new Dog("Шарик", 4);
        Animal dog3 = new Dog("Тузик", 3, "такса");
        Animal cat1 = new Cat("Мурзик", 3, "британец", "серый");
        Animal cat2 = new Cat("Барсик", 6, "черный");
        Animal cat3 = new Cat("Кузя", 3, "мейн-кун", "рыжий");
        Animal cat4 = new Cat("Пушок", 3, "персидская", "белый");
        Animal[] animals = {dog1, dog2, dog3, cat1, cat2, cat3, cat4};

        while (true) {
            System.out.print("Введите длину препятствия (дистанцию): ");
            if (in.hasNextInt()) {
                distance = in.nextInt();
                break;
            } else {
                in.next();
                System.out.println("\nДистанция должна быть целым числом.");
            }
        }

        cat3.setMaxDistanceSwim(0);
        dog1.setMaxDistanceRun(500);

        System.out.printf("\nУ нас имеется %d животных, в т. ч. собак - %d  и кошек - %d.\n\n", Animal.getCountAnimal(), Dog.getCountAnimal(), Cat.getCountAnimal());

        for (Animal animal : animals) {
            System.out.println(animal);
            canOrNot = canOrNot(animal.run(distance));
            System.out.printf("%s преодолеть дистанцию %d м бегом\n", canOrNot, distance);
            canOrNot = canOrNot(animal.swim(distance));
            System.out.printf("%s переплыть дистанцию %d м\n\n", canOrNot, distance);
        }
    }

    private static String canOrNot(boolean yesNo) {
        return (yesNo) ? "Может" : "Не может";
    }
}