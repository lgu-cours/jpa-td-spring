package td.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import td.entities.Author;
import td.persistence.dao.AuthorDAO;
import td.services.AuthorService;

//@Component
@Named
//@Scope("prototype")
public class AuthorServiceImpl implements AuthorService {

	//@Autowired
	@Inject
	private AuthorDAO dao ;
	
	public AuthorServiceImpl() {
		System.out.println("CONSTRUCTOR " + this.getClass().getSimpleName() );
	}
	
	@Override
	public String getAuthorFirstName(int id) {
		Author author = dao.findById(id);
		if ( author != null ) {
			return author.getFirstName() ;
		}
		return null;
	}

	@Override
	public void createAuthor(int id, String firstName, String lastName) {
		//entityManager.getTransaction().begin();
		Author author = new Author() ;
		author.setId(id);
		author.setFirstName(firstName);
		author.setLastName(lastName);
		dao.persist(author);
		//entityManager.getTransaction().commit();
	}

	@Override
	public void deleteAuthor(int id) {
		//entityManager.getTransaction().begin();
		Author author = new Author() ;
		author.setId(id);
		dao.delete(author);
		//entityManager.getTransaction().commit();
	}
}
