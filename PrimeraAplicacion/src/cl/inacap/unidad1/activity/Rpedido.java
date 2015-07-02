package cl.inacap.unidad1.activity;

import cl.inacap.unidad1.clases.ImageAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

public class Rpedido extends Activity implements OnItemSelectedListener{

  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rpedido);
		

	        
	        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
		    String[] items = new String[]{"Alejandra", "Amaro", "Malcom"};
		    ArrayAdapter<String> adapters = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		    dropdown.setAdapter(adapters);
		    
		    
		    
		    GridView gridView = (GridView) findViewById(R.id.grid_viewSLIDER);
		    
	        // Instance of ImageAdapter Class
	        gridView.setAdapter(new ImageAdapter(this));
	        
	}

	
	public void pasarAdos(View v) 
	{

		Intent intent = new Intent(Rpedido.this,DosRpedido.class);
		Rpedido.this.startActivity(intent);
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rpedido, menu);
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
	
	
	
	 public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

	        switch (position) {
	            case 0:
	                // Whatever you want to happen when the first item gets selected
	                break;
	            case 1:
	                // Whatever you want to happen when the second item gets selected
	                break;
	            case 2:
	                // Whatever you want to happen when the thrid item gets selected
	                break;

	        }
	    }

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
}
