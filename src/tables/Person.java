package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by Yevhen on 26.02.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "select p from Person p")
})
public class Person implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fio;
    private Integer birthYear;
    @ManyToOne
    private Gruppa gruppa;

    @ManyToMany
    private List<Phone> phones;

    public Person(Integer id, String fio, Integer birthYear) {
        this.id = id;
        this.fio = fio;
        this.birthYear = birthYear;
    }

    public Person(String fio, Integer birthYear) {
        this.fio = fio;
        this.birthYear = birthYear;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Gruppa getGruppa() {
        return gruppa;
    }

    public void setGruppa(Gruppa gruppa) {
        this.gruppa = gruppa;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(fio, person.fio) &&
                Objects.equals(birthYear, person.birthYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, birthYear);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
