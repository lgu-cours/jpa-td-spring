package td.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import td.services.BasicService;

@Component
@Scope("prototype")
public class BasicServiceImpl implements BasicService {
	
	// javax.persistence annotations
	//@PersistenceContext(unitName = "myPersistenceUnit") 
	//@PersistenceContext
	//@PersistenceUnit(unitName = "myPersistenceUnit")
	//@Autowired
	private EntityManager entityManager;

	public List<Integer> queryBadgeNumbers()
	{
		//Query query = entityManager.createQuery("SELECT b.badgeNumber FROM Badge b"); // Row type (unchecked conversion)
		//Query query = entityManager.createQuery("SELECT b.badgeNumber FROM Badge b", Integer.class); // Row type (unchecked conversion)
		
		
		TypedQuery<Integer> query = entityManager.createQuery("SELECT b.badgeNumber FROM Badge b", Integer.class);
		
		List<Integer> list = query.getResultList() ; 
		return list ;
	}
}
