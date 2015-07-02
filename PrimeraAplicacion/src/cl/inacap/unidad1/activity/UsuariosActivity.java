package cl.inacap.unidad1.activity;

import java.util.ArrayList;

import cl.inacap.unidad1.clases.Usuario;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UsuariosActivity extends Activity {
private ArrayAdapter<Usuario> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usuarios);
		
		
		ListView lv_usuarios= (ListView)findViewById((Integer) R.id.lv_usuarios);
	
		Usuario usuario = new Usuario();
	
		ArrayList<Usuario> usuarios =usuario.listaUsuarios();

		adapter= new ArrayAdapter<Usuario>(getApplicationContext(),android.R.layout.simple_spinner_item,usuarios);
	lv_usuarios.setAdapter(adapter);
	adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.usuarios, menu);
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
