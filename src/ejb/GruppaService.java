package ejb;

import tables.Gruppa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yevhen on 26.02.2016.
 */
@Stateless
public class GruppaService {
    @PersistenceContext
    EntityManager em;

    public Gruppa create(String name) {
        Gruppa g = new Gruppa(name);
        em.persist(g);
        return g;
    }

    public List<Gruppa> findAll() {
        return em.createNamedQuery("Gruppa.findAll").getResultList();
    }
}
