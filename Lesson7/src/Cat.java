import java.util.Random;

public class Cat extends Animal {

    private static final int RUN_UPPER_BOUND = 200;
    private static final float JUMP_UPPER_BOUND = 2.0f;
    private static final int SWIM_UPPER_BOUND = 0;

    private final int foodAmount;
    private boolean fullness;

    public Cat() {
        this(RUN_UPPER_BOUND, JUMP_UPPER_BOUND, SWIM_UPPER_BOUND);
    }

    private Cat(int runLimit, float jumpLimit, int swimLimit) {
        super(runLimit, jumpLimit, swimLimit);
        foodAmount = new Random().nextInt(10);
        fullness = false;
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

    public int getFoodAmount() {
        return foodAmount;
    }

    public boolean eat(Bowl bowl) {
        if (bowl.getAmount() < this.foodAmount) return false;

        bowl.setAmount(bowl.getAmount() - this.foodAmount);
        return (this.fullness = true);
    }
}
