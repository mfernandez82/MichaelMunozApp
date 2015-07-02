package cl.inacap.unidad1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends Activity {

	private TextView mUsuario;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		
		Bundle extras = getIntent().getExtras();
        String userLOGIN = extras.getString("userLOGIN");
       
        mUsuario = (TextView) this.findViewById(R.id.lb_mUsuario);
        mUsuario.setText(userLOGIN);
	}
	
	
	public void pasarAvender(View v) 
	{

		Intent intent = new Intent(MenuActivity.this,Rpedido.class);
		intent.putExtra("userMENU",mUsuario.getText());
		MenuActivity.this.startActivity(intent);
	}
	
	public void pasarAmantenedorclientes(View v) 
	{

		Intent intent = new Intent(MenuActivity.this,Clientes.class);
		intent.putExtra("userMENU",mUsuario.getText());
		MenuActivity.this.startActivity(intent);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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







