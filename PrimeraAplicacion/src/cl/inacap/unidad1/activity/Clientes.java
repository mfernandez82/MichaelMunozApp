package cl.inacap.unidad1.activity;

import Tables.Cliente;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Clientes extends Activity {
	private Cliente manager;
	private Cursor cursor;
	private ListView lista;
	SimpleCursorAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_clientes);
		
		manager = new Cliente(this);
	    /*
		manager.DeleteCliente("Alejandra");
		manager.DeleteCliente("Amaro");	
		manager.DeleteCliente("Malcom");
		manager.DeleteCliente("Michael");
	   
		manager.InsertCliente("Alejandra","Matta vial 515","225520120", 1, 1);
		manager.InsertCliente("Amaro","Matta vial 515","225520120", 2, 1);
		manager.InsertCliente("Malcom","Matta vial 515","225520120", 1, 1);
		manager.InsertCliente("Michael","Matta vial 515","225520120", 2, 1);
		Log.d("DataBase CRUD"," insert clientes");
		*/
		lista = (ListView) findViewById(R.id.lv_clientes);
		registerForContextMenu(lista);
		cursor = manager.SetCursorCliente();
		String[] from = new String[] { manager.CLIENTE_NOMBRE,manager.CLIENTE_DIRECCION, manager.CLIENTE_FONO };

		int[] to = new int[] { R.id.txt_nom, R.id.txt_dir, R.id.txt_fon };

		adapter = new SimpleCursorAdapter(this, R.layout.filas, cursor, from,to);
		lista.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
	//programando menu contextual@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
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
		
		case R.id.menu_modificar_client:
			modificarCliente_X((int) info.id);
			return true;
		
		
		case R.id.menu_delete_client:
			eliminarCliente_X((int) info.id);
			// recuperarTodasPersonas();

			return true;
		default:
			return super.onContextItemSelected((android.view.MenuItem) item);
		}
	}
	
	public void modificarCliente_X(int p_id){
		
			// Recupera un cliente especifico.
			Toast.makeText(
					getApplicationContext(),
					"Modificar cliente  "+ p_id,
					Toast.LENGTH_SHORT).show();
			
			    Intent intent = new Intent( Clientes.this, Crear.class);	                
	    		       
		        String codigo = String.valueOf(p_id);
		        // parametros para enviar a la otra actividad .		        		      
		        intent.putExtra("IDcliente", codigo);		   
		        startActivity(intent);  
			
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
						 Intent intent = new Intent( Clientes.this, Clientes.class);
						 startActivity(intent);
					}
				});
		mensaje.setNegativeButton("Cancelar",new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialogo, int id) {		
				}
				});
		mensaje.show();
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clientes, menu);
		return true;
	}
	
	public void pasarAcrea(View v) 
	{
		Intent intent = new Intent(this,Crear.class);
		this.startActivity(intent);
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
