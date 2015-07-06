package Tests;

import org.junit.Before;
import org.junit.Test;
import cl.inacap.unidad1.activity.LoginActivity;

public class TestLoging {
	
	public String user;
	private String pas;
	
	private LoginActivity loginactivity= new LoginActivity();
	
	@Before
	public void antesde(){
		user="Michael";	
		pas="pass";
	}
	
	
	@Test(timeout=1000)
	public void testWithTimeout() {
	loginactivity.validarLoginUsuarioDB(user,pas);
	
	}
}
