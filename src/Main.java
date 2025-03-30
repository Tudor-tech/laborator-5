import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = readFile("C:\\Users\\tudor\\IdeaProjects\\lab5\\namesAndAges.txt");
        persons.sort(Comparator.comparing(Person::getName));
        printPersons(persons);

    }
    public static List<Person> readFile(String fileName) {
        List<Person> persons = new ArrayList<>();
        try{
            File fileNames = new File("C:\\Users\\tudor\\IdeaProjects\\lab5\\namesAndAges.txt");
            Scanner scanner = new Scanner(fileNames);
            while (scanner.hasNextLine()) {
                String names = scanner.nextLine();
                String[] nameParts = names.split(" ");
                String prenume = nameParts[0];
                String name = nameParts[1];
                int age = Integer.parseInt(nameParts[2]);
                persons.add(new Person(name, age, prenume));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return persons;
    }
    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person.getName() + " " + person.getPrenume() + " " + person.getAge());
        }
    }

}