package homework8;

public interface Participant {
    void jump();

    void run();

    String getName();

    int getLimitDistance();

    int getLimitHeight();

    int getSuccess();

    void setSuccess(int success);
}
