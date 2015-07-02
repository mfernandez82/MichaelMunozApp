package cl.inacap.unidad1.activity;

import Tables.Cliente;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Modificar extends Activity {
	private Cliente manager;
	private Cursor cursor;
	private ListView lista;
	SimpleCursorAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_modificar);
		
		manager = new Cliente(this);
		lista = (ListView) findViewById(R.id.lv_modifica);
		registerForContextMenu(lista);
		cursor = manager.SetCursorCliente();
		String[] from = new String[] { manager.CLIENTE_NOMBRE,manager.CLIENTE_DIRECCION, manager.CLIENTE_FONO };

		int[] to = new int[] { R.id.txt_nom, R.id.txt_dir, R.id.txt_fon };

		adapter = new SimpleCursorAdapter(this, R.layout.filas, cursor, from,to);
		lista.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

	
	
	//-----------------------------------------------------------------------------------	
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) 
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			android.view.MenuInflater inflater = getMenuInflater();
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
			inflater.inflate(R.menu.modificacliente, menu);
		}
		
		@Override
		public boolean onContextItemSelected(android.view.MenuItem item) {
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
					.getMenuInfo();

			switch (item.getItemId()) {
			
			case R.id.menu_update_client:
				modificarCliente_X((int) info.id);
				return true;
			default:
				return super.onContextItemSelected((android.view.MenuItem) item);
			}
		}
		

		private void modificarCliente_X(int id) 
		{
			Toast.makeText(getApplicationContext(),"Modificar Cliente: "+ id,Toast.LENGTH_SHORT).show();
				
		        Intent Intent = new Intent(this, Crear.class);
		            
		        String cod = String.valueOf(id);		        		      
		        Intent.putExtra("codigo", cod);		   
		        startActivity(Intent);
		}
		
	//-----------------------------------------------------------------------------------
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modificar, menu);
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
