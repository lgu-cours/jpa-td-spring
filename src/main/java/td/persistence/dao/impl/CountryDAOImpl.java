package td.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import td.entities.Country;
import td.persistence.dao.CountryDAO;

/**
 * The DAO for "Country" JPA entity <br>
 * NB : this DAO has an adherence with Spring annotations : <br>
 * Repository, Transactional and Propagation
 *
 */
@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class CountryDAOImpl implements CountryDAO {

	private static final String SELECT_QUERY = "select c from Country c";
	 
	@PersistenceContext
	private EntityManager entityManager;
	 
	public EntityManager getEntityManager() {
		return entityManager;
	}
	 
	public void persist(Country country) {
		// Not allowed to create transaction on shared EntityManager 
		// - use Spring transactions or EJB CMT instead
		// EntityTransaction tx = entityManager.getTransaction();
		//System.out.println("persist : Active TX ? " + entityManager.getTransaction().isActive() );
		System.out.println("persist : isOpen ? " + entityManager.isOpen() );
		entityManager.persist(country);
	}
	
	public void delete(Country entity) {
		//System.out.println("delete : Active TX ? " + entityManager.getTransaction().isActive() );
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
		System.out.println("findAll : isOpen ? " + entityManager.isOpen() );
		//Query query = entityManager.createQuery(SELECT_QUERY);
		TypedQuery<Country> query = entityManager.createQuery(SELECT_QUERY, Country.class);
		List<Country> list = (List<Country>) query.getResultList();
		return list;
	}
}
