package td.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import td.entities.Country;

public interface CountryDAO {

	public EntityManager getEntityManager() ;
	
	public void persist(Country country);
	
	public void delete(Country entity);

	public List<Country> findAll();
}
