package com.pluralsight.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        // Step 1 - Create list of people
        List<Person> people = new ArrayList<>();

        people.add(new Person("Emma", "Johnson", 24));
        people.add(new Person("Liam", "Carter", 27));
        people.add(new Person("Sophia", "Martinez", 22));
        people.add(new Person("Noah", "Williams", 30));
        people.add(new Person("Olivia", "Brown", 26));
        people.add(new Person("James", "Anderson", 29));
        people.add(new Person("Ava", "Thomas", 21));
        people.add(new Person("Benjamin", "Harris", 33));
        people.add(new Person("Mia", "Clark", 25));
        people.add(new Person("Daniel", "Lewis", 28));

        // Step 2 - Search for a name
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine();

        List<Person> matches = new ArrayList<>();

        for (Person person : people) {

            if (person.getFirstName().equalsIgnoreCase(searchName)
                    || person.getLastName().equalsIgnoreCase(searchName)) {

                matches.add(person);
            }
        }

        System.out.println("\nMatching People:");

        if (matches.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            for (Person person : matches) {
                System.out.println(person.getFullName() + " - Age: " + person.getAge());
            }
        }

        // Step 3 - Calculate average, oldest, youngest
        int totalAge = 0;
        int oldestAge = people.get(0).getAge();
        int youngestAge = people.get(0).getAge();

        for (Person person : people) {

            totalAge += person.getAge();

            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }

            if (person.getAge() < youngestAge) {
                youngestAge = person.getAge();
            }
        }

        double averageAge = (double) totalAge / people.size();

        System.out.println("\nAverage Age: " + averageAge);
        System.out.println("Oldest Age: " + oldestAge);
        System.out.println("Youngest Age: " + youngestAge);

        scanner.close();
    }
}