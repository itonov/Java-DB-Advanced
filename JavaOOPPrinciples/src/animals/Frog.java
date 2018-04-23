package animals;

public class Frog extends Animal {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Frogggg");
    }

    @Override
    public String toString() {
        return String.format("Frog%n%s %d %s", super.getName(), super.getAge(), super.getGender());
    }
}
