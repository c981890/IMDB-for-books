package eu.trumm.imdbforbooks.Entity;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
@Indexed
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String isbn;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String bookTitle;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String bookAuthor;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @NumericField
    private Integer year;

    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String publisher;

    private String imageUrlS;
    private String imageUrlM;
    private String imageUrlL;

    protected Book() {

    }

    public Book(String isbn, String bookTitle, String bookAuthor, int year, String publisher, String imageUrlS, String imageUrlM, String imageUrlL) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.year = year;
        this.publisher = publisher;
        this.imageUrlS = imageUrlS;
        this.imageUrlM = imageUrlM;
        this.imageUrlL = imageUrlL;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrlS() {
        return imageUrlS;
    }

    public void setImageUrlS(String imageUrlS) {
        this.imageUrlS = imageUrlS;
    }

    public String getImageUrlM() {
        return imageUrlM;
    }

    public void setImageUrlM(String imageUrlM) {
        this.imageUrlM = imageUrlM;
    }

    public String getImageUrlL() {
        return imageUrlL;
    }

    public void setImageUrlL(String imageUrlL) {
        this.imageUrlL = imageUrlL;
    }
}

