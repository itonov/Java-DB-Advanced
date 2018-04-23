package animals;

public class Cat extends Animal {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("MiauMiau");
    }

    @Override
    public String toString() {
        return String.format("Cat%n%s %d %s", super.getName(), super.getAge(), super.getGender());
    }
}
