package cl.inacap.unidad1.activity;

import Tables.Cliente;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Eliminar extends Activity {
	private Cliente manager;
	private Cursor cursor;
	private ListView lista;
	SimpleCursorAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_eliminar);
		
		manager = new Cliente(this);
		lista = (ListView) findViewById(R.id.lv_elimina);
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
		inflater.inflate(R.menu.eliminacliente, menu);
	}
	
	@Override
	public boolean onContextItemSelected(android.view.MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();

		switch (item.getItemId()) {
		
		case R.id.menu_delete_client:
			eliminarCliente_X((int) info.id);
			// recuperarTodasPersonas();

			return true;
		default:
			return super.onContextItemSelected((android.view.MenuItem) item);
		}
	}
	

	private void eliminarCliente_X(int id) 
	{
		AlertDialog.Builder mensaje= new AlertDialog.Builder(this);

		final int id_cliente = id;

		mensaje.setTitle("Advertencia");
		mensaje.setCancelable(false);
		mensaje.setMessage("Esta seguro de eliminar este Cliente?");
		mensaje.setPositiveButton("Eliminar",new DialogInterface.OnClickListener() 
			{
				public void onClick(DialogInterface dialogo, int id) {
				
						String IDcliente = String.valueOf(id_cliente);
						manager.DeleteClienteId(IDcliente);
						Toast.makeText(getApplicationContext(),
								"Cliente Eliminado",
								Toast.LENGTH_SHORT).show();
						
				
						adapter.notifyDataSetChanged();
		
					}
				});
		mensaje.setNegativeButton("Cancelar",new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialogo, int id) {		
				}
				});
		mensaje.show();
	}
	
//-----------------------------------------------------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eliminar, menu);
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
