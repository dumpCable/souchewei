package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.User;

@Service
@Transactional
public class TestService {

	@Autowired
	private TestDao testDao;
    
	public void test(){
		
		User user=new User();
		user.setName("zhangsan");
		testDao.save(user);
		System.out.println("finish..");
		//dao.save(new ParkingPlaceOwner());
	}
}
