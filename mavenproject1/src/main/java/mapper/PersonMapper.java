package mapper;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class PersonMapper {
    
        EntityManagerFactory emf;

    public PersonMapper(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
        public List<Person> findAllPersons() {
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createNamedQuery("Person.findAll");
            return q.getResultList();
        } finally
        {
            em.close();
        }
    }
}
