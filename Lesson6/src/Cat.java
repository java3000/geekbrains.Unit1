import java.util.Random;

public class Cat extends Animal {

    //константы одинаковы для всех кошек, поэтому статичны и финальны
    //более того, есть и в коде класса String:
    //** use serialVersionUID from JDK 1.0.2 for interoperability */
    //    @java.io.Serial
    //    private static final long serialVersionUID = -6849794470754667710L;

    private static final int RUN_UPPER_BOUND = 200;
    private static final float JUMP_UPPER_BOUND = 2.0f;
    private static final int SWIM_UPPER_BOUND = 0;

    public Cat() {
        this(RUN_UPPER_BOUND, JUMP_UPPER_BOUND, SWIM_UPPER_BOUND);
    }

    private Cat(int runLimit, float jumpLimit, int swimLimit) {
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
