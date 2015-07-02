package cl.inacap.unidad1.activity;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;

public class DosRpedido extends Activity {
	DatePicker picker; 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dos_rpedido);
		
		 picker=(DatePicker)findViewById(R.id.datePicker1);
		 
		
	        
	        NumberPicker np =(NumberPicker) findViewById (R.id.numberPicker1); 
	        		np.setMaxValue (100); 
	        		np.setMinValue (1);
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dos_rpedido, menu);
		return true;
	}

	public void pasarAuno(View v) 
	{

		Intent intent = new Intent(DosRpedido.this,Rpedido.class);
		DosRpedido.this.startActivity(intent);
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
