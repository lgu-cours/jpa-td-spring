package td.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import td.dao.CountryDAO;
import td.entities.Country;

@Component
public class CountryService {
	
	@Autowired
	private CountryDAO dao;
	 
//	public CountryDAO getDAO() {
//		return dao;
//	}

	public void addCountry(Country entity) {
		dao.persist(entity);
	}
	
	public void deleteCountry(Country entity) {
		dao.delete(entity);
	}	 
	
	public List<Country> fetchAll() {
		return dao.findAll();
	}
}
