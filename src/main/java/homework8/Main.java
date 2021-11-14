package homework8;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Кузя", 10, 20);
        Human human = new Human("Герман", 30, 10);
        Robot robot = new Robot("АРМ-1", 20, 2);

        Participant[] participants = {cat, human, robot};

        Wall wall1 = new Wall("Стена1", 10);
        RunningTrack track1 = new RunningTrack("Дорожка1", 30);
        RunningTrack track2 = new RunningTrack("Дорожка2", 10);

        Obstacles[] obstacles = {wall1, track1, track2};

        for (Obstacles obstacle : obstacles) {
            System.out.println("Итак, на пути препятствие " + obstacle.getName());
            for (Participant participant : participants) {
                obstacle.overcoming(participant);
            }
            System.out.println();
        }

    }
}
