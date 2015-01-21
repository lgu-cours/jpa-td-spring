package td.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import td.dao.CountryDAO;
import td.entities.Country;
import td.services.CountryService;

public class TestCountryServiceAndDAO {

	public static void main(String[] args) 
	{
		System.out.println("----------");
		System.out.println("************** BEGINNING PROGRAM **************");
		 
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config1.xml");
		
		testDAO(context);
		testAll(context);

		System.out.println("************** ENDING PROGRAM *****************");
		System.out.println("----------");
	}
	
	public static void testDAO(ApplicationContext context ) {
		System.out.println("----- TEST DAO ");
		CountryDAO dao = context.getBean(CountryDAO.class);
		
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
		 
	}
	public static void testAll(ApplicationContext context ) {
		System.out.println("----- TEST SERVICE ");
		//CountryService service = (CountryService) context.getBean("countryService");
		CountryService service = context.getBean(CountryService.class);
		
		//-- For tests :
//		EntityManager em = service.getDAO().getEntityManager() ;
//		System.out.println("EntityManager class : " + em.getClass().getCanonicalName() );
		
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
		 
	}

	private static void print(List<Country> list ) {
		System.out.println("Countries : ");
		for ( Country c : list ) {
			System.out.println(" . " + c );
		}
	}
}
