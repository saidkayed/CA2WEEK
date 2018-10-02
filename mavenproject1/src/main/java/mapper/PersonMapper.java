package mapper;

import dto.PersonDTO;
import entity.Person;
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
    
        public PersonDTO findPersonFromPhonenr(int number) {
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createQuery("SELECT p FROM PhoneDTO p WHERE p.number = :insert");
            return (PersonDTO) q.getSingleResult();
        } finally
        {
            em.close();
        }
    }
}
