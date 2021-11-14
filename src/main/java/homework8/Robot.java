package homework8;

public class Robot implements Participant {
    private String name;
    private int limitDistance;
    private int limitHeight;
    private int success;

    public Robot(String name, int limitDistance, int limitHeight, int success) {
        this.name = name;
        this.limitDistance = limitDistance;
        this.limitHeight = limitHeight;
        this.success = success;
    }

    public Robot(String name, int limitDistance, int limitHeight) {
        this(name, limitDistance, limitHeight, 1);
    }

    public String getName() {
        return name;
    }

    public int getLimitDistance() {
        return limitDistance;
    }

    public int getLimitHeight() {
        return limitHeight;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгает.");
    }

    @Override
    public void run() {
        System.out.println("Робот бежит.");
    }
}
