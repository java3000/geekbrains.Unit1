import java.util.Random;

public class Dog extends Animal {

    //константы одинаковы для всех собак, поэтому статичны и финальны
    //более того, есть и в коде класса String:
    //** use serialVersionUID from JDK 1.0.2 for interoperability */
    //    @java.io.Serial
    //    private static final long serialVersionUID = -6849794470754667710L;

    private static final int RUN_UPPER_BOUND = 500;
    private static final float JUMP_UPPER_BOUND = 0.5f;
    private static final int SWIM_UPPER_BOUND = 10;

    public Dog() {
        this(RUN_UPPER_BOUND, JUMP_UPPER_BOUND, SWIM_UPPER_BOUND);
    }

    private Dog(int runLimit, float jumpLimit, int swimLimit) {
        super(runLimit, jumpLimit, swimLimit);
    }

    @Override
    public String run(int length) {
        return String.format("Run %d [max: %d]: %s", length, this.runLimit, length <= this.runLimit);
    }

    @Override
    public String swim(int length) {
        return String.format("Swim %d [max: %s]: %s", length, this.swimLimit, length <= this.swimLimit);
    }

    @Override
    public String jump(int length) {
        return String.format("Jump %d [max: %.2f]: %s", length, this.jumpLimit, length <= this.jumpLimit);
    }
}
