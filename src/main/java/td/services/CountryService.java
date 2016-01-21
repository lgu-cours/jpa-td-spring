package td.services;

import java.util.List;

import org.springframework.stereotype.Component;

import td.entities.Country;

@Component
public interface CountryService {
	
	public void addCountry(Country entity) ;
	
	public void deleteCountry(Country entity) ;
	
	public List<Country> fetchAll() ;
}
