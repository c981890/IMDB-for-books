package eu.trumm.imdbforbooks.Repository;

import eu.trumm.imdbforbooks.Entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {
    /**
     * Create a new Book
     *
     * @param book
     * @return Book
     */
    Book create(Book book);

    /**
     * Read Book by id
     *
     * @param id
     * @return Rating
     */
    Book read(Long id);

    /**
     * Update rating
     *
     * @param book
     */
    Book update(Book book);

    /**
     * Delete rating
     *
     * @param book
     */
    void delete(Book book);

    /**
     * close the entity manager factory
     */
    void close();
}
