package cl.inacap.unidad1.activity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
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
        
        
        /* Use the LocationManager class to obtain GPS locations */
		LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		MyLocationListener mlocListener = new MyLocationListener();
		mlocListener.setMainActivity(this);
		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				(LocationListener) mlocListener);
        
	}
	
	
	public class MyLocationListener implements LocationListener {
		MenuActivity menuActivity;
		
		
		public void setMainActivity(MenuActivity mainActivity) {
			this.menuActivity = mainActivity;
		}

		@Override
		public void onLocationChanged(Location loc) {
			// Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
			// debido a la deteccion de un cambio de ubicacion
			loc.getLatitude();
		    loc.getLongitude();
			String Text = "Mi ubicacion actual es: " + "\n Lat = "
			+ loc.getLatitude() + "\n Long = " + loc.getLongitude();
			//messageTextView.setText(Text);
			Log.d("LOCALIZACION",(Text));
	        setLocation(loc);
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			//messageTextView.setText("GPS Activado");
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			//messageTextView.setText("GPS Desactivado");
		}

	}
	

	public void setLocation(Location loc) {
		Log.d("LOCALIZACION","entra");
		//Obtener la direccion de la calle a partir de la latitud y la longitud 
		if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
			Log.d("LOCALIZACION","entra if");
			try {
				Geocoder geocoder = new Geocoder(this, Locale.getDefault());
				List<Address> list = geocoder.getFromLocation(
						loc.getLatitude(), loc.getLongitude(), 1);
				if (!list.isEmpty()) {
					Log.d("LOCALIZACION","entra if2");
					Address address = list.get(0);
					Log.d("LOCALIZACION",("Mi direcci—n es: "+ address.getAddressLine(0)));
					//messageTextView2.setText("Mi direcci—n es: \n"
							//+ address.getAddressLine(0));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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







