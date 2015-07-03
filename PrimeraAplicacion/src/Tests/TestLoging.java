package Tests;



import org.junit.Before;
import org.junit.Test;


import cl.inacap.unidad1.activity.LoginActivity;

public class TestLoging {
	
	private LoginActivity loginactivity= new LoginActivity();
	
	@Before
	public void setUp(){
		
		loginactivity.validarLoginUsuarioDB("Michael","pass");	
	}
	
	
	
	@Test
	public void test() {
  }
	
	
}
