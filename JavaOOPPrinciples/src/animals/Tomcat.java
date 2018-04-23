package animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age) {
        super(name, age, "male");
    }

    @Override
    public void produceSound() {
        System.out.println("Give me one million b***h");
    }

    @Override
    public String toString() {
        return String.format("Tomcat%n%s %d %s", super.getName(), super.getAge(), super.getGender());
    }
}
