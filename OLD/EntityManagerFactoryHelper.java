package td.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * We need just one EntityManagerFactory per persistence unit
 * Just use a singleton
 *
 */
public class EntityManagerFactoryHelper {
	
    private static EntityManagerFactory factory;

    static {
        try {
        	factory = Persistence.createEntityManagerFactory("td"); 
        } catch(ExceptionInInitializerError e) {
            throw e;
        }
    }

    public static EntityManagerFactory getFactory() {
        return factory;
    }
}
