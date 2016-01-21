package td.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import td.entities.Author;
import td.persistence.dao.AuthorDAO;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
// Spring : Scope singleton by default
//@Scope("prototype") 
public class AuthorDAOImpl implements AuthorDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public AuthorDAOImpl() {
		System.out.println("CONSTRUCTOR " + this.getClass().getSimpleName() );
	}

	@Override
	public void persist(Author entity) {
		entityManager.persist(entity);
	}

	@Override
	public void remove(Author entity) {
		entityManager.remove(entity);		
	}

	@Override
	public void delete(Author entity) {
		if ( entity != null ) {
			if ( entityManager.contains(entity) ) {
				//log("Author is in context : remove it" );
				entityManager.remove(entity);
			}
			else {
				//log("Author is NOT in context" );
				Author entityLoaded = entityManager.find(Author.class, entity.getId());
				if ( entityLoaded != null ) {
					entityManager.remove(entityLoaded);
				}
			}
		}
		else {
			throw new IllegalArgumentException("Author is null");
		}
	}

	@Override
	public Author findById(int id) {
		return entityManager.find(Author.class, id); 
	}

}
