package td.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import td.entities.Country;
import td.persistence.dao.CountryDAO;
import td.services.CountryService;

//@Component
@Named
public class CountryServiceImpl implements CountryService {
	
	//@Autowired
	@Inject
	private CountryDAO dao;
	
	public CountryServiceImpl() {
		System.out.println("CONSTRUCTOR " + this.getClass().getSimpleName() );
	}

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
