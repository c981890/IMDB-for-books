package eu.trumm.imdbforbooks.Entity;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ratings")
@Indexed
public class Rating {

    @Id
    @GeneratedValue
    private int identifier;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @NumericField
    private Integer userId;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String isbn;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @NumericField
    private int bookRating;

    public Rating() {

    }

    public Rating(int userId, String isbn, int bookRating) {
        this.userId = userId;
        this.isbn = isbn;
        this.bookRating = bookRating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getBookRating() {
        return bookRating;
    }

    public void setBookRating(int bookRating) {
        this.bookRating = bookRating;
    }
}