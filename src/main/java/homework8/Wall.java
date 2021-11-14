package homework8;

public class Wall implements Obstacles {
    private String name;
    private int height;

    public Wall(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void overcoming(Participant participant) {
        if (participant.getSuccess() == 1) {
            participant.jump();
            if (getHeight() <= participant.getLimitHeight()) {
                System.out.printf("%s преодолевает высоту %d\n", participant.getName(), getHeight());
            } else {
                System.out.printf("%s не преодолевает высоту %d\n", participant.getName(), getHeight());
                participant.setSuccess(0);
            }
        }
    }

}
