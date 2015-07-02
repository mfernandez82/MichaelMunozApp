package cl.inacap.unidad1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ManClientesActivity extends Activity {
	private TextView mUsuario2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_man_clientes);
		
		

		Bundle extras = getIntent().getExtras();
        String user2 = extras.getString("userMENU");
       
        mUsuario2 = (TextView) this.findViewById(R.id.tv_user);
        mUsuario2.setText(user2);
	}
	
	
	public void pasarAcrear(View v) 
	{
		Intent intent = new Intent(this,Crear.class);
		this.startActivity(intent);
	}
	
	public void pasarAmodificar(View v) 
	{
		Intent intent = new Intent(this,Modificar.class);
		this.startActivity(intent);
	}
	
	public void pasarAeliminar(View v) 
	{
		Intent intent = new Intent(this,Eliminar.class);
		this.startActivity(intent);
	}
	
	public void pasarAverclientes(View v) 
	{
		Intent intent = new Intent(this,Clientes.class);
		this.startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.man_clientes, menu);
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
