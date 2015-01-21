package td.dao.impl;

import javax.persistence.EntityManager;

import td.dao.AuthorDAO;
import td.entities.Author;

public class AuthorDAOImpl implements AuthorDAO {

	private final EntityManager entityManager;
	
	public AuthorDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
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
