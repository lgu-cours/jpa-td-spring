package td.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.entities.Author;
import td.entities.Book;

public class TestAuthorWithBooks {

	public static void main(String[] args) 
	{
		System.out.println("--- Persistence.createEntityManagerFactory(xx)...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("td"); 
		
		System.out.println("--- emf.createEntityManager()...");		
		EntityManager em = emf.createEntityManager(); 
		
		System.out.println("----------");

		Author author = em.find(Author.class, 1);

		System.out.println("----------");
		 // close the EM and EMF when done 
		System.out.println("--- closing ...");		
		em.close();
		emf.close();			
		

		print(author);
		
		if ( author != null ) {
			List<Book> books = author.getListOfBook();
			System.out.println("books class : " + books.getClass().getCanonicalName());
			// Real acces to the list => Error :
			// failed to lazily initialize a collection 
			// of role: td.entities.Author.listOfBook, no session or session was closed
			System.out.println("Size = " + books.size());
			System.out.println("List of books : class = " + books.getClass().getCanonicalName() );
			print(books, "Books");
		}
				
	}

	private static void print(List<?> list, String title ) {
		System.out.println(title);
		for ( Object item : list ) {
			System.out.println(" . " + item );
		}
	}

	private static void print(Author author ) {
		System.out.println(author);
	}
}
