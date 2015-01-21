package td.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import td.entities.Author;
import td.services.BasicService;
import td.services.HelloService;

public class TestBasicService {

	public static void main(String[] args) 
	{
		System.out.println("----------");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		HelloService helloService = ac.getBean(HelloService.class);
		helloService.hello("Toto");

		BasicService basicService = ac.getBean(BasicService.class);
		List<Integer> list = basicService.queryBadgeNumbers();
		System.out.println("Number of badges : " + list.size() );
		for ( Integer i : list ) {
			System.out.println(". " + i );
		}		

		System.out.println("----------");
	}

	private static void print(List<Author> authors ) {
		System.out.println("Authors : ");
		for ( Author author : authors ) {
			System.out.println(" . " + author );
		}
	}
	private static void print(Author author ) {
		System.out.println(author);
	}
}
