package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Yevhen on 26.02.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Gruppa.findAll", query = "select g from Gruppa g")
})
public class Gruppa implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Gruppa(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Gruppa(String name) {
        this.name = name;
    }

    public Gruppa() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gruppa)) return false;
        Gruppa gruppa = (Gruppa) o;
        return Objects.equals(id, gruppa.id) &&
                Objects.equals(name, gruppa.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Gruppa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "gruppa")
    private Collection<Person> persons;

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }
}
