package TestASM1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.model.User;


public class TestDelete {
	UserDao dao;
	User user;
	@Before
	public void init() {	
		dao = new UserDao();
		user = new User();
	}

	@Test
	public void TC1() {	
		assertEquals(1, dao.delete("trung1"));
	}
	@Test
	public void TC2() {	
		assertEquals(1, dao.delete("trung3"));
	}

	/*Khong co lien ket moi xoa dc*/
}
