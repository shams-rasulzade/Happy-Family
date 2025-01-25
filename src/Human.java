import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surName;
    private int year;
    private Integer iq;
    private String[][] schedule;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
        if (iq >= 1 && iq <= 100) {
            this.iq = iq;
        } else {
            throw new IllegalArgumentException("iq must be between 1 and 100.");
        }
    }

    public Pet getPet() {
        return this.family.getPet();
    }

    public void setPet(Pet pet) {
        this.family.setPet(pet);
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Human() {
    }

    public Human(String name, String surName, int year) {
        this.name = name;
        this.surName = surName;
        this.year = year;
    }


    public Human(String name, String surName, int year, int iq, String[][] schedule) {
        this(name, surName, year);
        if (iq >= 1 && iq <= 100) {
            this.iq = iq;
        } else {
            throw new IllegalArgumentException("iq must be between 1 and 100.");
        }
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Human{" + "name='" + name + '\'' + ", surName='" + surName + '\'' + ", year=" + year + ", iq=" + iq + ", schedule=" + Arrays.deepToString(schedule) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surName, human.surName) && Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, year, iq, Arrays.deepHashCode(schedule));
    }
}

