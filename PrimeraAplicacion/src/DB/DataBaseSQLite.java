package DB;

import Tables.Cliente;
import Tables.Producto;
import Tables.Vendedor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseSQLite extends SQLiteOpenHelper {

	public static final int version = 1;
	   public static final String DB_name= "BD";
	 public DataBaseSQLite(Context context) {
			super(context, DB_name, null,version);
			Log.d("DataBase CRUD"," db crada");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		 db.execSQL(Vendedor.CREATE_TABLE_VENDEDORES); 
		 db.execSQL(Cliente.CREATE_TABLE_CLIENTES); 
	   	 db.execSQL(Producto.CREATE_TABLE_PRODUCTOS);
	   	   Log.d("DataBase CRUD"," tablas cradas");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS VENDEDORES");
		db.execSQL("DROP TABLE IF EXISTS CLIENTE");
	
		onCreate(db);
	}

}
