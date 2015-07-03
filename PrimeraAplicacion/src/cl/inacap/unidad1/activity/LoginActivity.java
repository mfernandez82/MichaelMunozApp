package cl.inacap.unidad1.activity;

import cl.inacap.unidad1.clases.Usuario;
import Tables.Vendedor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {
	Vendedor loginDataBaseAdapter;
	private EditText txt_login_db;
	private EditText txt_contrasena_db;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  
        
	loginDataBaseAdapter = new Vendedor(this);		
	loginDataBaseAdapter.InsertVendedor("i", "i");
	loginDataBaseAdapter.InsertVendedor("Michael", "pass");
	Log.d("DataBase CRUD"," insert vendedores");
	
	txt_login_db =(EditText)findViewById(R.id.txt_login);
	txt_contrasena_db =(EditText)findViewById(R.id.txt_contrasena);
	
    }
    
	public void pasarAmenuPrincipal(View v) 
		{
		String userName = txt_login_db.getText().toString();
		String password = txt_contrasena_db.getText().toString();
		
			validarLoginUsuarioDB(userName,password);
		}
		
	public void validarLoginUsuarioDB(String user,String pass)
	{
		
		
		//String userName = txt_login_db.getText().toString();
		//String password = txt_contrasena_db.getText().toString();
		
		String storedPassword = loginDataBaseAdapter.GetCursorVendedor(user);
		Log.d("DataBase CRUD"," obtener pass usuario");
	
		if (pass.equals(storedPassword)) 
		{
			Toast.makeText(this, "Usuario Valido", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this,MenuActivity.class);
			intent.putExtra("userLOGIN",  txt_login_db.getText().toString());
			Log.d("DataBase CRUD"," nombre vendedor hacia menu");
			this.startActivity(intent);
		
			txt_login_db.setText("");
			txt_contrasena_db.setText("");	
		} 
		else 
		{
			Toast.makeText(LoginActivity.this, "Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	
    public void validarLoginUsuario()
    	{
    		EditText txt_login =(EditText)findViewById(R.id.txt_login);
    		EditText txt_contrasena =(EditText)findViewById(R.id.txt_contrasena);
    		Usuario usuario = new Usuario();
    	
    		if (usuario.validarLogin(txt_login.getText().toString(),txt_contrasena.getText().toString()))
    		{
    			Toast.makeText(LoginActivity.this, "Usuario Valido", Toast.LENGTH_SHORT).show();
    			Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
    			intent.putExtra("userLOGIN",  txt_login.getText().toString());
    			LoginActivity.this.startActivity(intent);
    		
    			txt_login.setText("");
    			txt_contrasena.setText("");	
    		}
    		else
    		{
    		Toast.makeText(LoginActivity.this, "Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
    		}
    	}
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
