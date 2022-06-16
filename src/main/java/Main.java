import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person(10102030,"IvanDurov", LocalDate.of(2002,10,25)); // Два одинаковых объекта
        Person person2 = new Person(10102030,"IvanDurov", LocalDate.of(2002,10,24)); // а вернее их ИИН
        Person person3 = new Person(10121301,"IvanRom", LocalDate.of(2002,10,23));
        Person person4 = new Person(10121302,"IvanRoma", LocalDate.of(2002,10,22));

        Set<Person> persons = new LinkedHashSet<Person>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);               //Список без дублекатов по ИИН-у
        for (Person pers: persons) {
            pers.getInfo();
        }
        System.out.println(" ");

        SortedSet<Person> sortedPersons = new TreeSet<>(((o1, o2) -> o1.getIin()==o2.getIin() ? 0 : 1));
        sortedPersons.add(person1);
        sortedPersons.add(person2);         //Список без дублекатов по ИИН-у и сортировка по дате рождения с компаратором
        sortedPersons.add(person3);
        sortedPersons.add(person4);
        for (Person pers2: sortedPersons) {
            pers2.getInfo();
        }
        System.out.println(" ");

        List<Person>unsortedPersons = new ArrayList<Person>();
        unsortedPersons.add(person1);
        unsortedPersons.add(person2);
        unsortedPersons.add(person3);
        unsortedPersons.add(person4);

        List<Person>sortedPerson = unsortedPersons.stream()   //Список без дублекатов по ИИН-у и сортировка по дате рождения через стримы
                .distinct()
                .sorted((o1, o2) -> o2.getFio().length() - o1.getFio().length())
                .collect(Collectors.toList());

        for (Person pers3: sortedPerson) {
            pers3.getInfo();
        }
    }

}
