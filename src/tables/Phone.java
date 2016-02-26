package tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Yevhen on 26.02.2016.
 */
@Entity
public class Phone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String num;
    private String type;

    @ManyToMany(mappedBy = "phones")
    private Collection<Person> persons;

    public Phone(String num, String type) {
        this.num = num;
        this.type = type;
    }

    public Phone() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id) &&
                Objects.equals(num, phone.num) &&
                Objects.equals(type, phone.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, type);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }
}
