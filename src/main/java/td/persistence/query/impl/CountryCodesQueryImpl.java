package td.persistence.query.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import td.persistence.query.CountryCodesQuery;

@Repository
public class CountryCodesQueryImpl implements CountryCodesQuery {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<String> getCountryCodes() {
		
		TypedQuery<String> query = entityManager.createQuery("SELECT c.code FROM Country c", String.class);
		
		List<String> list = query.getResultList() ; 
		return list ;

	}
}
