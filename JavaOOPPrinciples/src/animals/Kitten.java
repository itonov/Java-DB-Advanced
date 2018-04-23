package animals;

public class Kitten extends Cat {

    public Kitten(String name, int age) {
        super(name, age, "female");
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }

    @Override
    public String toString() {
        return String.format("Kitten%n%s %d %s", super.getName(), super.getAge(), super.getGender());
    }
}
