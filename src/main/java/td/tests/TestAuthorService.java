package td.tests;

import java.util.List;

import td.entities.Author;
import td.provider.BeanProvider;
import td.services.AuthorService;

public class TestAuthorService {

	public static void main(String[] args) 
	{
		System.out.println("----------");

		//AuthorService service = new AuthorServiceImpl();
		AuthorService service = BeanProvider.getBean(AuthorService.class);
		AuthorService service2 = BeanProvider.getBean(AuthorService.class);
		if ( service == service2 ) {
			System.out.println("Same instance => SINGLETON");
		}
		else {
			System.out.println("2 instances => PROTOTYPE");
		}
		
		String firstName = service.getAuthorFirstName(100);
		System.out.println("firstName = " + firstName );
		
		service.deleteAuthor(555); // Transaction 1
		
		service.createAuthor(555, "Tryphon", "Tournesol");  // Transaction 2
		
		
		/***
		List<Author> authors = service.listAll();
		print(authors);
		
		authors = service.list("W%");
		print(authors);
		
		Author a1 = new Author();
		a1.setId(333);
		a1.setFirstName("Jules");
		a1.setLastName("Verne");
		
		boolean deleted = service.delete(a1);
		System.out.println("Deleted ? " + deleted);
		
		service.create(a1);
		
		a1.setFirstName("Jules bis");
		boolean updated = service.update(a1);
		System.out.println("Updated ? " + updated);
		
		Author a2 = service.find(333);
		System.out.println("a2 : " + a2);

		Author a3 = new Author();
		a3.setId(901);
		a3.setFirstName("Jules (a3)");
		a3.setLastName("Verne (a3)");
		updated = service.update(a3);
		System.out.println("Updated ? " + updated);
		
		service.save(a3);
		
		deleted = service.delete(801);
		System.out.println("Deleted ? " + deleted);
		deleted = service.delete(802);
		System.out.println("Deleted ? " + deleted);

		
		authors = service.listAllNativeSql();
		print(authors);

		authors = service.listNativeSql("W%");
		print(authors);
*/
		System.out.println("----------");
	}

	private static void print(List<Author> authors ) {
		System.out.println("Authors : ");
		for ( Author author : authors ) {
			System.out.println(" . " + author );
		}
	}
	private static void print(Author author ) {
		System.out.println(author);
	}
}
