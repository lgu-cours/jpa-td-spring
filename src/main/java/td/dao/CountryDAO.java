package td.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import td.entities.Country;

/**
 * The DAO for "Country" JPA entity <br>
 * NB : this DAO has an adherence with Spring annotations : <br>
 * Repository, Transactional and Propagation
 *
 */
@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class CountryDAO {

	private static final String SELECT_QUERY = "select c from Country c";
	 
	@PersistenceContext
	private EntityManager entityManager;
	 
//	public EntityManager getEntityManager() {
//		return entityManager;
//	}
	 
//	public void setEntityManager(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
	 
	public void persist(Country country) {
		entityManager.persist(country);
	}
	
	public void delete(Country entity) {
		if ( entity != null ) {
			if ( entityManager.contains(entity) ) {
				//log("Author is in context : remove it" );
				entityManager.remove(entity);
			}
			else {
				//log("Author is NOT in context" );
				Country entityLoaded = entityManager.find(Country.class, entity.getCode());
				if ( entityLoaded != null ) {
					entityManager.remove(entityLoaded);
				}
			}
		}
		else {
			throw new IllegalArgumentException("Author is null");
		}
	}

	public List<Country> findAll() {
		//Query query = entityManager.createQuery(SELECT_QUERY);
		TypedQuery<Country> query = entityManager.createQuery(SELECT_QUERY, Country.class);
		List<Country> list = (List<Country>) query.getResultList();
		return list;
	}
}
