package TestASM1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.model.User;


public class TestInsert {
	UserDao dao;
	User user;
	@Before
	public void init() {	
		dao = new UserDao();
		user = new User();
	}
	@Test
	public void TC1() {
		user.setId("trung1");
		user.setPassword("123456");
		assertEquals(1, dao.insert(user));
	}
	@Test
	public void TC2() {
		user.setId("trung2");
		user.setPassword("123456");
		assertEquals(2, dao.insert(user));
	}
	
	/*Khong co lien ket moi xoa dc*/
}
