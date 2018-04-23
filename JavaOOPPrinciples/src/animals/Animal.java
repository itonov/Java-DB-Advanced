package animals;

public abstract class Animal implements SoundProducible {
    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        this.name = name;
        this.setAge(age);
        this.gender = gender;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    @Override
    public void produceSound() {
        System.out.println("Not implemented!");
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }
}
