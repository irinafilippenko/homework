package homework8;

public class RunningTrack implements Obstacles {
    private String name;
    private int distance;

    public RunningTrack(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void overcoming(Participant participant) {
        if (participant.getSuccess() == 1) {
            participant.run();
            if (getDistance() <= participant.getLimitDistance()) {
                System.out.printf("%s преодолевает дистанцию %d\n", participant.getName(), getDistance());
            } else {
                System.out.printf("%s не преодолевает дистанцию %d\n", participant.getName(), getDistance());
                participant.setSuccess(0);
            }
        }
    }

}
