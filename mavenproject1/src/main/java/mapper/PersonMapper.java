package mapper;

import dto.PersonDTO;
import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PersonMapper {

    EntityManagerFactory emf;

    public PersonMapper(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PersonDTO findPersonFromPhoneNumber(int number) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<PersonDTO> query = em.createQuery("select new dto.PersonDTO(c1.id, c1.email, c1.firstName, c1.lastName,"
                    + " c2.name, c2.description,"
                    + " c3.number, c3.description,"
                    + " c4.street, c4.additionalInfo,"
                    + " c5.zipCode, c5.city) from Person c1 inner join c1.hobbys as c2"
                    + " inner join c1.phones as c3"
                    + " inner join c1.address as c4"
                    + " inner join c4.cityinfo as c5"
                    + " where c1.phones.number = :phone", PersonDTO.class);
            query.setParameter("phone", number);
            return (PersonDTO) query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
