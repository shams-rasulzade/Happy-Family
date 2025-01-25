import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private Integer trickLevel;
    private String[] habits;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(Integer trickLevel) {
        if (trickLevel >= 1 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        } else {
            throw new IllegalArgumentException("trickLevel must be between 1 and 100.");
        }
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public Pet() {

    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this(species, nickname);
        this.age = age;
        if (trickLevel >= 1 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        } else {
            throw new IllegalArgumentException("trickLevel must be between 1 and 100.");
        }
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating.");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", this.getNickname());
    }

    public void foul() {
        System.out.println("I need to cover it up.");
    }

    @Override
    public String toString() {
        return species + '{' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
}

