package td.tests;

import java.util.List;

import td.persistence.query.CountryCodesQuery;
import td.provider.BeanProvider;

public class TestCountryCodesQuery {

	public static void main(String[] args) 
	{
		System.out.println("----------");

		CountryCodesQuery qry = BeanProvider.getBean(CountryCodesQuery.class);
		List<String> list = qry.getCountryCodes();
		System.out.println("Number of country codes : " + list.size() );
		for ( String s : list ) {
			System.out.println(". " + s );
		}		
	}
}
