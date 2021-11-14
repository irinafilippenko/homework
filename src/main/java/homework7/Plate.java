package homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        } else {
            System.out.println("Котику не повезло. В тарелке слишком мало еды.");
            return false;
        }
    }

    public void info() {
        System.out.println("Количество еды в тарелке: " + food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
