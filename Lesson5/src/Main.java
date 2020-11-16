public class Main {

    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Janitor", " pi@mailbox.com ", "892312313", 12500, 18);
        persArray[2] = new Person("John Smith", "Manager", " xxx@mailbox.com ", "892312314", 1050, 72);
        persArray[3] = new Person("Bond James", "Boss", " 007@mailbox.com ", "892312315", 100500, 39);
        persArray[4] = new Person("No One", "Someone not needed", " noon@mailbox.com ", "892312316", 1, 45);

        for (Person p : persArray) {
            if (p.age > 40) p.printInfo();
        }
    }
}
