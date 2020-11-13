import java.util.Random;

public abstract class Animal {

    protected int runLimit;
    protected float jumpLimit;
    protected int swimLimit;

    protected Animal(int runLimit, float jumpLimit, int swimLimit) {

        //чтобы обеспечить разюрос, но не создавать совсем уж слабых животных
        this.runLimit = new Random().nextInt(runLimit / 2) * 2;
        this.jumpLimit = (jumpLimit - 0.0f) * new Random().nextFloat();
        this.swimLimit = (swimLimit > 0) ? new Random().nextInt(swimLimit) : 0;
    }

    public abstract String run(int length);

    public abstract String swim(int length);

    public abstract String jump(int length);
}
