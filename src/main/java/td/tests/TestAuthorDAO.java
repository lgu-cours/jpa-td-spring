package td.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.dao.AuthorDAO;
import td.dao.impl.AuthorDAOImpl;
import td.entities.Author;

public class TestAuthorDAO {

	public static void main(String[] args) 
	{
		System.out.println("--- Persistence.createEntityManagerFactory(xx)...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("td"); 
		
		System.out.println("--- emf.createEntityManager()...");		
		EntityManager em = emf.createEntityManager(); 
		
		System.out.println("----------");

		AuthorDAO dao = new AuthorDAOImpl(em);
		
		Author author = dao.findById(100);
		print(author);
		
		Author a1 = new Author();
		a1.setId(333);
		a1.setFirstName("Jules");
		a1.setLastName("Verne");
		em.getTransaction().begin();
		dao.delete(a1);
		dao.persist(a1);
		em.getTransaction().commit();
		
		Author a2 = dao.findById(333);
		print(a2);
		
		
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
		 // close the EM and EMF when done 
		System.out.println("--- closing ...");		
		
        em.close(); 
        emf.close();			
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
