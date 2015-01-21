package td.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import td.dao.AuthorDAO;
import td.dao.impl.AuthorDAOImpl;
import td.entities.Author;
import td.services.AuthorService;
import td.util.EntityManagerFactoryHelper;

public class AuthorServiceImpl implements AuthorService {

	private EntityManager entityManager ;
	private AuthorDAO dao ;
	
	public AuthorServiceImpl() {
		super();
		entityManager = getEntityManager() ;
		this.dao = new AuthorDAOImpl(entityManager) ;
	}
	
    private EntityManager getEntityManager() {
        if ( entityManager == null ) {
            EntityManagerFactory emf = EntityManagerFactoryHelper.getFactory();
            entityManager = emf.createEntityManager();
        }
        return entityManager;
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
		entityManager.getTransaction().begin();

		Author author = new Author() ;
		author.setId(id);
		author.setFirstName(firstName);
		author.setLastName(lastName);
		dao.persist(author);
		
		entityManager.getTransaction().commit();
	}

	@Override
	public void deleteAuthor(int id) {
		entityManager.getTransaction().begin();
		Author author = new Author() ;
		author.setId(id);
		dao.delete(author);
		entityManager.getTransaction().commit();
	}
}
