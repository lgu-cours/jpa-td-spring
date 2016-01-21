package td.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanProvider {

	//private final static String SPRING_CONFIG_FILE = "spring-config1.xml" ;
	private final static String SPRING_CONFIG_FILE = "spring-config2.xml" ;
	
	private final static ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext(SPRING_CONFIG_FILE);
	
	public final static <T> T getBean(Class<T> beanClass) {
		if ( applicationContext != null ) {
			T bean = applicationContext.getBean(beanClass);
			return bean ;
		}
		else {
			throw new RuntimeException("ApplicationContext not initialized.");
		}
	}
}
