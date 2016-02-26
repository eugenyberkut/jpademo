package ejb;

import tables.Gruppa;
import tables.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yevhen on 26.02.2016.
 */
@Stateless
public class PersonService {
    @PersistenceContext
    EntityManager em;

    public Person create(String fio, Integer year) {
        Person p = new Person(fio,year);
        em.persist(p);
        return p;
    }

    public List<Person> findAll() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }
}
