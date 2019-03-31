package eu.trumm.imdbforbooks.Repository;

import eu.trumm.imdbforbooks.Entity.Rating;
import org.hibernate.query.Query;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RatingRepositoryImpl implements RatingRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eu.trumm.imdbforbooks.Entity");
    private EntityManager em;
    private CriteriaBuilder cb;

    public RatingRepositoryImpl() {

        this.em = emf.createEntityManager();
        this.cb  = em.getCriteriaBuilder();
    }

    public List topItems(int numberOfItems) {
        CriteriaQuery<Rating> criteriaQuery =
                this.em.getCriteriaBuilder().createQuery(Rating.class);
        Root<Rating> rating = criteriaQuery.from(Rating.class);
        criteriaQuery.select(rating);
        List limitedCriteriaQuery = this.em.createQuery(criteriaQuery)
                .setMaxResults(numberOfItems)
                .getResultList();
        return limitedCriteriaQuery;

    }


    @Override
    public Rating create(Rating rating) {
        em.getTransaction().begin();
        em.persist(rating);
        em.getTransaction().commit();
        return rating;
    }

    @Override
    public Rating read(Long id) {
        em.getTransaction().begin();
        Rating rating = em.find(Rating.class, id);
        em.getTransaction().commit();
        return rating;
    }

    @Override
    public Rating update(Rating rating) {
        em.getTransaction().begin();
        rating = em.merge(rating);
        em.getTransaction().commit();
        return rating;
    }

    @Override
    public void delete(Rating rating) {
        em.getTransaction().begin();
        em.remove(rating);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }

}