package homework6;

public class Dog extends Animal {
    private static int countAnimal;

    public Dog(String nickname, int age, String breed) {
           super(nickname,"Собака", age, breed, 500, 10);

           countAnimal++;
    }

    public Dog(String nickname, int age) {
        this(nickname, age, "дворняжка");
    }

    public static int getCountAnimal() {
        return countAnimal;
    }
}
