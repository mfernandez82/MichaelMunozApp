package cl.inacap.unidad1.activity;

import Tables.Cliente;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class Crear extends Activity {
	private Cliente manager;
	String int_cliente,paso;
	String cra="crea";
	private EditText txtNombre,txtDireccion,txtFono;
	private Cursor cursor;
	int codigo_interno;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_crear);
		 txtNombre = (EditText) findViewById(R.id.t_nom);
		 txtDireccion = (EditText) findViewById(R.id.t_dir);
		 txtFono = (EditText) findViewById(R.id.t_fon);
		 
		 //
		 paso = getIntent().getStringExtra("IDcliente");
		 manager = new Cliente(this);
		 //
		
		 
		 if (paso.equals(cra))
		 {
			
		 }
		 else
		 {
			 int_cliente = getIntent().getStringExtra("IDcliente"); 
			 codigo_interno = Integer.parseInt(int_cliente);
		 cursor = manager.getRegistro(codigo_interno);	
		 txtNombre.setText(cursor.getString(cursor.getColumnIndex(manager.CLIENTE_NOMBRE)));
		 txtDireccion.setText(cursor.getString(cursor.getColumnIndex(manager.CLIENTE_DIRECCION)));
		 txtFono.setText(cursor.getString(cursor.getColumnIndex(manager.CLIENTE_FONO)));
		 }
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crear, menu);
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
	
	public void pasarAcrear(View v) 
	{
		
		 if (paso.equals(cra))
		 {
			 EditText tNom = (EditText) findViewById(R.id.t_nom);
				EditText tDir = (EditText) findViewById(R.id.t_dir);
				EditText tFon = (EditText) findViewById(R.id.t_fon);
				
				if (tNom.getText().toString().matches("")
		 		   || tDir.getText().toString().matches("")
		 		   || tFon.getText().toString().matches("")) 
					{
		 				Toast.makeText(getApplicationContext(),"Faltan datos para crear el cliente",Toast.LENGTH_SHORT).show();
					} 
				else
					{
		    	   manager.InsertCliente(tNom.getText().toString(), tDir.getText().toString(), tFon.getText().toString());
		    	   Toast.makeText(Crear.this, "Cliente creado correctamente", Toast.LENGTH_SHORT).show();
		    	   Intent intent = new Intent( Crear.this, Clientes.class);	                
		    		startActivity(intent); 
		    	   tNom.setText("");
		   			tDir.setText("");
		   			tFon.setText("");
					}
		 }
		 else
		 {
				manager.UpdateCliente(txtNombre.getText().toString(), txtDireccion.getText().toString(), txtFono.getText().toString(),int_cliente);
				 Toast.makeText(this, "Cliente " + txtNombre+" actualizado satisfactoriamente !!"+int_cliente, Toast.LENGTH_LONG);
				
				Intent intent = new Intent(this, Clientes.class);	                
        		startActivity(intent);
		 }

	}

	public void pasarAlimpiar(View v) 
	{
		EditText tNom = (EditText) findViewById(R.id.t_nom);
		EditText tDir = (EditText) findViewById(R.id.t_dir);
		EditText tFon = (EditText) findViewById(R.id.t_fon);
		tNom.setText("");
		tDir.setText("");
		tFon.setText("");
	}

}
