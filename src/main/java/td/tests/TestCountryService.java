package td.tests;

import java.util.List;

import td.entities.Country;
import td.provider.BeanProvider;
import td.services.CountryService;

public class TestCountryService {

	public static void main(String[] args) 
	{
		System.out.println("----------");

		CountryService service = BeanProvider.getBean(CountryService.class);
		
		Country c = new Country();
		c.setCode("ZZ");
		c.setName("Ze country");
		
		System.out.println("----------");
		System.out.println("Delete country : " + c + " ...");
		service.deleteCountry(c);
		System.out.println("After delete");
		
		System.out.println("----------");
		System.out.println("Add country : " + c + " ...");
		service.addCountry(c);
		System.out.println("Country : " + c + " added successfully");
		 
		System.out.println("----------");
		List<Country> list = service.fetchAll();
		print(list);
		 
		System.out.println("----------");
	}
	
	private static void print(List<Country> list ) {
		System.out.println("Countries : ");
		for ( Country c : list ) {
			System.out.println(" . " + c );
		}
	}
}
