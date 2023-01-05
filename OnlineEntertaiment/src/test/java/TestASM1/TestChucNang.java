package TestASM1;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.poly.dao.UserDao;
import com.poly.model.User;


public class TestChucNang {
	UserDao dao;
	User user;
	@Before
	public void init() {	
		dao = new UserDao();
		user = new User();
	}
	@Test
	public void TestInsert() {
		user.setId("trung123123");
		user.setPassword("123456");
		assertEquals(1, dao.insert(user));
	}
	@Test
	public void TestUpdate() {
		user.setId("trung123123");
		user.setPassword("12345678");
		user.setFullname("Nguy�n Trung");
		assertEquals(1, dao.update(user));
	}
	@Test
	public void TestDelete() {	
		assertEquals(1, dao.delete("trung123123"));
	}
	
	@Test
	public void TestFinUser() {
		String username = "trung123123";
		user = dao.findById(username);
		assertEquals(1, user);
	}
	/*Khong co lien ket moi xoa dc*/
}
