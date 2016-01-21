package td.tests;

import java.util.List;

import td.entities.Author;
import td.entities.Book;
import td.persistence.dao.AuthorDAO;
import td.provider.BeanProvider;

public class TestAuthorDAO {

	public static void main(String[] args) 
	{
		System.out.println("----------");

		AuthorDAO dao = BeanProvider.getBean(AuthorDAO.class);
		AuthorDAO dao2 = BeanProvider.getBean(AuthorDAO.class);
		
		Author author = dao.findById(100);
		print(author);
		
		Author a1 = new Author();
		a1.setId(333);
		a1.setFirstName("Jules");
		a1.setLastName("Verne");
		//em.getTransaction().begin();
		dao.delete(a1);
		dao.persist(a1);
		//em.getTransaction().commit();
		
		Author a2 = dao.findById(333);
		print(a2);
		
		List<Book> books = a2.getListOfBook();
		System.out.println("List of books : class = " + books.getClass().getCanonicalName() );
		print(books, "Books");
		
		System.out.println("----------");
		 // close the EM and EMF when done 
		System.out.println("--- closing ...");		
		
	}

	private static void print(List<?> list, String title ) {
		System.out.println(title);
		System.out.println("Size = " + list.size());
		for ( Object item : list ) {
			System.out.println(" . " + item );
		}
	}

	private static void print(Author author ) {
		System.out.println(author);
	}
}
