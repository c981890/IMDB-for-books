package eu.trumm.imdbforbooks;

import eu.trumm.imdbforbooks.Entity.*;
import eu.trumm.imdbforbooks.Repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.*;

@SpringBootApplication
public class ImdbforbooksApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ImdbforbooksApplication.class, args);

		// Initializing repositories and importing data from CSV files
		UserRepositoryImpl userRepositoryImlp = new UserRepositoryImpl();
		readUsersFromCSV(userRepositoryImlp);

		RatingRepositoryImpl ratingRepositoryImpl = new RatingRepositoryImpl();
		readRatingsFromCSV(ratingRepositoryImpl);

		BookRepositoryImpl bookRepositoryImpl = new BookRepositoryImpl();
		readBooksFromCSV(bookRepositoryImpl);

		// Search - fulltext
		List result = userRepositoryImlp.search("Denmark");
		for (Object member : result) {
			System.out.println(member);
		}

		// Search - criteria
		List topResult = ratingRepositoryImpl.topItems(10);
		for (Object member : topResult) {
			System.out.println(member);
		}
	}

	private static void readBooksFromCSV(BookRepositoryImpl bookRepositoryImpl) throws IOException {
		// Build reader instance for books
		File fileBooks = ResourceUtils.getFile("classpath:BX-Books-10K.csv");
		CSVReader readerBook = new CSVReader(new FileReader(fileBooks), ';', '"', 1);
		List<String[]> allRowsBook = readerBook.readAll();
		for(String[] row : allRowsBook){
			String isbn = row[0];
			String bookTitle = row[1];
			String bookAuthor = row[2];
			int year = (char) Integer.parseInt(row[3]);
			String publisher = row[4];
			String imageUrlS = row[5];
			String imageUrlM = row[6];
			String imageUrlL = row[7];
			Book book = new Book(isbn, bookTitle, bookAuthor, year, publisher, imageUrlS, imageUrlM, imageUrlL);
			bookRepositoryImpl.create(book);
		}
	}

	private static void readRatingsFromCSV(RatingRepositoryImpl ratingRepositoryImpl) throws IOException  {
		// Build reader instance for ratings
		File fileRatings = ResourceUtils.getFile("classpath:BX-Book-Ratings-10K.csv");
		CSVReader readerRating = new CSVReader(new FileReader(fileRatings), ';', '"', 1);
		List<String[]> allRowsRating = readerRating.readAll();
		for(String[] row : allRowsRating){
			int userId = (char) Integer.parseInt(row[0]);
			String isbn = row[1];
			int bookRating = (char) Integer.parseInt(row[2]);
			Rating rating = new Rating(userId, isbn, bookRating);
			ratingRepositoryImpl.create(rating);
		}
	}

	public static void readUsersFromCSV(UserRepositoryImpl userRepositoryImpl) throws IOException {
		// Build reader instance for users
		File fileUsers = ResourceUtils.getFile("classpath:BX-Users-10K.csv");
		CSVReader readerUser = new CSVReader(new FileReader(fileUsers), ';', '"', 1);

		List<String[]> allRowsUser = readerUser.readAll();
		for(String[] row : allRowsUser){
			int userId = (char) Integer.parseInt(row[0]);
			String location = row[1];
			String str = row[2];
			int number = 0;
			try
			{
				if(str != null)
					number = Integer.parseInt(str);
			}
			catch (NumberFormatException e)
			{
				number = 0;
			}
			int age = number;
			User user = new User(userId, location, age);
			userRepositoryImpl.create(user);
		}
	}
}
