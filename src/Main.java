public class Main {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Monday";
        schedule[1][0] = "Tuesday";
        schedule[2][0] = "Wednesday";
        schedule[3][0] = "Thursday";
        schedule[4][0] = "Friday";
        schedule[5][0] = "Saturday";
        schedule[6][0] = "Sunday";
        schedule[0][1] = "Cook or Share a Meal Together";
        schedule[1][1] = "Take a Walk or Go for a Short Drive";
        schedule[2][1] = "Watch a Movie or TV Show Together";
        schedule[3][1] = "Help with a Home Project";
        schedule[4][1] = "Play a Game or Do a Puzzle";
        schedule[5][1] = "Teach or Learn Something Together";
        schedule[6][1] = "Outdoor Adventure";
        Human mother = new Human("Padme", "Amidala", 1983);
        Human father = new Human("Anakin", "Skywalker", 1988);
        Pet pet = new Pet("dog", "Buddy", 4, 37, new String[]{"eat", "drink", "sleep"});
        Human child = new Human("Luke", "Skywalker", 2008, 60, pet, father, mother, schedule);
        child.describePet();
        child.greetPet();
        boolean b1 = child.feedPet(true);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child);
        System.out.println(pet);
    }
}

