package test;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDao")
public class TestDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Object obj){
		sessionFactory.getCurrentSession().save(obj);
	}
}
