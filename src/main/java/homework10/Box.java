package homework10;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : box) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void add(T fruit) {
        box.add(fruit);
    }

    public boolean compareBox(Box comparableBox) {
//        return (this.getWeight() == comparableBox.getWeight());
        return (Math.abs(this.getWeight() - comparableBox.getWeight()) < 0.001);
    }

    public boolean isApple(Box isAppleBox) {
        return (isAppleBox.box.get(0) instanceof Apple);
    }

    public boolean isOrange(Box isOrangeBox) {
        return (isOrangeBox.box.get(0) instanceof Orange);
    }

    public boolean transferTo(Box transferToBox) {
        if ((isApple(this) && isApple(transferToBox)) || (isOrange(this) && isOrange(transferToBox))) {
            transferToBox.box.addAll(box);
            box.clear();
            return true;
        } else {
            return false;
        }
    }
}
