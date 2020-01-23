package bmi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class ZufallsPerson {
    private static ArrayList<String> vornamen = new ArrayList<>();
    private static ArrayList<String> nachnamen = new ArrayList<>();
    private static ArrayList<Person> personen = new ArrayList<>();

    private static int bmiMin = 16;
    private static int bmiMax = 32;

    private static void initNames() {
        vornamen.add("Elias");
        vornamen.add("Levi");
        vornamen.add("Archie");
        vornamen.add("Liam");
        vornamen.add("Linus");
        vornamen.add("Emilia");
        vornamen.add("Cataleya");
        vornamen.add("Anna");
        vornamen.add("Sarah");
        vornamen.add("Laura");

        nachnamen.add("Müller");
        nachnamen.add("Schmidt");
        nachnamen.add("Schneider");
        nachnamen.add("Fischer");
        nachnamen.add("Weber");
        nachnamen.add("Meyer");
        nachnamen.add("Wagner");
        nachnamen.add("Becker");
        nachnamen.add("Schulz");
        nachnamen.add("Hoffmann");
    }

    public static void main(String[] args) {
        initNames();
        generatePeople();
        menu();
    }

    static void generatePeople() {
        personen.clear();
        for (int i = 0; i < 10; i++) {
            Person newPerson;
            do {
                newPerson = new Person(
                        nachnamen.get(getRandomInt(10)),
                        vornamen.get((getRandomInt(10))));
            } while (newPerson.getBMI() < bmiMin || newPerson.getBMI() > bmiMax);
            personen.add(newPerson);
        }
    }

    static void showPeople() {
        personen.forEach((person) -> System.out.println(person.toString()));
    }

    private static int getRandomInt(int ceilingExclusive) {
        Random random = new Random();
        return random.nextInt(ceilingExclusive);
    }

    static void sortByName() {
        personen.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    static void sortByVorame() {
        personen.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getVorname().compareToIgnoreCase(o2.getVorname());
            }
        });
    }

    static void sortByGewicht() {
        personen.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getGewicht() == o2.getGewicht()) {
                    return 0;
                } else if (o1.getGewicht() > o2.getGewicht()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    static void sortByGroesse() {
        personen.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getGroesse() == o2.getGroesse()) {
                    return 0;
                } else if (o1.getGroesse() > o2.getGroesse()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    static void sortByBMI() {
        personen.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getBMI() == o2.getBMI()) {
                    return 0;
                } else if (o1.getBMI() > o2.getBMI()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    static void menu() {
        System.out.println();
        System.out.println("[1] Zehn neue Personen erzeugen");
        System.out.println("[2] Sortiert ausgeben nach Vorname");
        System.out.println("[3] Sortiert ausgeben nach Nachname");
        System.out.println("[4] Sortiert ausgeben nach Größe");
        System.out.println("[5] Sortiert ausgeben nach Gewicht");
        System.out.println("[6] Sortiert ausgeben nach BMI");
        System.out.println("[7] Beenden");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                generatePeople();
                showPeople();
                break;
            case 2:
                sortByVorame();
                showPeople();
                break;
            case 3:
                sortByName();
                showPeople();
                break;
            case 4:
                sortByGroesse();
                showPeople();
                break;
            case 5:
                sortByGewicht();
                showPeople();
            case 6:
                sortByBMI();
                showPeople();
            case 7:
                System.exit(0);
            default:
                // Tue nix
        }

        menu();
    }

}
