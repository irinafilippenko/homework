package homework6;

public class Animal {
    private static int countAnimal;

    private String nickname;
    private String subclass;
    private int age;
    private String breed;
    private int maxDistanceRun;
    private int maxDistanceSwim;

    public Animal(String nickname, String subclass, int age, String breed, int maxDistanceRun, int maxDistanceSwim) {
        this.nickname = nickname;
        this.subclass = subclass;
        this.age = age;
        this.breed = breed;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;

        countAnimal++;
    }

    public String toString() {
        return String.format("%s %s породы %s %d лет от роду", subclass, nickname, breed, age);
    }

    public boolean run(int distance) {
        return (distance <= maxDistanceRun);
    }

    public boolean swim(int distance) {
        return (distance <= maxDistanceSwim);
    }

    public static int getCountAnimal() {
        return countAnimal;
    }

    public void setMaxDistanceRun(int maxDistanceRun) {
        this.maxDistanceRun = maxDistanceRun;
    }

    public void setMaxDistanceSwim(int maxDistanceSwim) {
        this.maxDistanceSwim = maxDistanceSwim;
    }
}
