package homework7;

import java.util.Random;

public class Cat {
    private String name;
    private boolean full;
    Random random = new Random();

    public Cat(String name, boolean full) {
        this.name = name;
        this.full = full;
    }

    public Cat(String name) {
        this(name, false);
    }

    public void eat(Plate p) {
        int appetite;

        appetite = random.nextInt(7) + 1;
        full = p.decreaseFood(appetite);
        if (full) {
            System.out.format("Котик %s сыт и доволен. Он съел %d\n", name, appetite);
        } else {
            System.out.format("Котик %s голоден.\n", name);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return full;
    }
}
