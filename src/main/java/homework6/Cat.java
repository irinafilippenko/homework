package homework6;

public class Cat extends Animal {
    private static int countAnimal;
    private String color;

    public Cat(String nickname, int age, String breed, String color) {
        super(nickname, "Кот", age, breed, 200, 0);
        this.color = color;

        countAnimal++;
    }

    public Cat(String nickname, int age, String color) {
        this(nickname, age, "беспородный", color);
    }

    public String toString() {
        return super.toString() + " " + color + " окрас";
    }

    public boolean swim(int distance) {
        System.out.println("Кот не умееет плавать... :(");
        return false;
    }

    public static int getCountAnimal() {
        return countAnimal;
    }
}
