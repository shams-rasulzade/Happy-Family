import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family {
    Random rand = new Random();
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Human addChild(Human child) {
        child.setFamily(this);
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[children.length] = child;
        this.children = newChildren;
        return child;
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) {
            return false;
        }

        Human[] newChildren = new Human[children.length - 1];

        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }

        children[index].setFamily(null);  // Update the children array
        this.children = newChildren;

        return true;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Family(Human mother, Human father) {
        if (mother == null || father == null) {
            throw new IllegalArgumentException("A family must have two parents.");
        }
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public void greetPet() {
        System.out.printf("Hello, %s.\n", this.getPet().getNickname());
    }

    public void describePet() {
        System.out.printf("I have an %s is %d years old, he is %s.\n", this.getPet().getSpecies(), this.getPet().getAge(), (this.getPet().getTrickLevel() > 50) ? "very sly" : "almost not sly");
    }

    public boolean feedPet(boolean petIsFed) {
        if (!petIsFed) {
            System.out.printf("Hm... I will feed %s.\n", this.getPet().getNickname());
            return true;
        }
        if (this.getPet().getTrickLevel() > rand.nextInt(101)) {
            System.out.printf("Hm... I will feed %s.\n", this.getPet().getNickname());
            return true;
        }
        System.out.printf("I think %s is not hungry.\n", this.getPet().getNickname());
        return false;
    }

    public int countFamily() {
        return 2 + children.length;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Arrays.equals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, Arrays.hashCode(children), pet);
    }
}