
import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable{
    private int iin;
    private String fio;
    private LocalDate dateOfBirth;

    public Person(int iin, String fio, LocalDate dateOfBirth) {
        this.iin = iin;
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
    }

    public void getInfo(){
        System.out.println("ИИН: " + iin + ", Фио: " + fio + ", дата рождения: " + dateOfBirth);
    }

    public int getIin() {
        return iin;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public int compareTo(Object o) {
        Person e = (Person) o;
        if (( e.dateOfBirth.getYear()+e.dateOfBirth.getMonthValue()+e.dateOfBirth.getDayOfMonth() ) < ( this.dateOfBirth.getYear() +
                this.dateOfBirth.getMonthValue() + this.dateOfBirth.getDayOfMonth())) return -1;
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return iin == person.iin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iin);
    }
}