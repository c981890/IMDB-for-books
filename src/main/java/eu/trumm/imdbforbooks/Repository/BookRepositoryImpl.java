package eu.trumm.imdbforbooks.Repository;

import eu.trumm.imdbforbooks.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookRepositoryImpl implements BookRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eu.trumm.imdbforbooks.Entity");
    private EntityManager em;

    public BookRepositoryImpl() {

        em = emf.createEntityManager();
    }


    @Override
    public Book create(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        return book;
    }

    @Override
    public Book read(Long id) {
        em.getTransaction().begin();
        Book book = em.find(Book.class, id);
        em.getTransaction().commit();
        return book;
    }

    @Override
    public Book update(Book book) {
        em.getTransaction().begin();
        book = em.merge(book);
        em.getTransaction().commit();
        return book;
    }

    @Override
    public void delete(Book book) {
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

    @Override
    public void close() {

        emf.close();
    }
}