package td.tests;

import java.util.List;

import td.entities.Country;
import td.persistence.dao.CountryDAO;
import td.provider.BeanProvider;

public class TestCountryDAO {

	public static void main(String[] args) 
	{
		System.out.println("----------");
		CountryDAO dao = BeanProvider.getBean(CountryDAO.class);
		
		System.out.println("EM is open ? " + dao.getEntityManager().isOpen() );
		
		
		Country c = new Country();
		c.setCode("ZZ");
		c.setName("Ze country");
		
		System.out.println("----------");
		System.out.println("Delete country : " + c + " ...");
		dao.delete(c);
		System.out.println("After delete");
		
		System.out.println("----------");
		System.out.println("Add country : " + c + " ...");
		dao.persist(c);
		System.out.println("Country : " + c + " added successfully");
		 
		System.out.println("----------");
		List<Country> list = dao.findAll();
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
