package Tables;


import DB.DataBaseSQLite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Vendedor {
	
public static final String NOM_TABLE = "VENDEDORES";
	
	public static final String VENDEDOR_ID ="_id";
	public static final String VENDEDOR_NOMBRE ="nombre";
	public static final String VENDEDOR_CONTRASENA ="contrasena";
	
	public static final String CREATE_TABLE_VENDEDORES ="CREATE TABLE " + NOM_TABLE
            					+ "("+ VENDEDOR_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            					+ VENDEDOR_NOMBRE +"  TEXT, "
            					+ VENDEDOR_CONTRASENA +" TEXT); ";
            					
	private DataBaseSQLite helper;
	private SQLiteDatabase db;
	
	public Vendedor(Context context)
		{
			helper = new DataBaseSQLite(context);
			db = helper.getWritableDatabase();	
		}
	
	
	public ContentValues GenerarCV(String nom, String pass)
		{
			ContentValues values =  new ContentValues();
			values.put(VENDEDOR_NOMBRE, nom);
			values.put(VENDEDOR_CONTRASENA, pass);
			
			return values;	
		}
	
	public void InsertVendedor(String nom, String pass)
		{
			ContentValues values =  new ContentValues();
			values.put(VENDEDOR_NOMBRE, nom);
			values.put(VENDEDOR_CONTRASENA, pass);
		
			db.insert(NOM_TABLE, null, values);	
		}
	
	public void UpdateVendedor(String nom, String pass)
		{
		db.update(NOM_TABLE, GenerarCV(nom, pass), VENDEDOR_NOMBRE +"=?", new String []{nom});
		}
	
	public void DeleteVendedor(String nom)
		{
		db.delete(NOM_TABLE, VENDEDOR_NOMBRE +"=?", new String[] {nom});
		}
	
	public Cursor SetrCursorVendedor()
		{		
			String[] columnas = new String[] {VENDEDOR_ID, VENDEDOR_NOMBRE,VENDEDOR_CONTRASENA};				
			return	db.query(NOM_TABLE, columnas, null, null, null, null, null);			
		}
	
	public String GetCursorVendedor(String nom)
		{
			Cursor cursor=db.query(Vendedor.NOM_TABLE, null, " nombre=?", new String[]{nom}, null, null, null);
			if(cursor.getCount()<1) 
			{	
				cursor.close();
				return "No Existe";
			}
			cursor.moveToFirst();
			String pass= cursor.getString(cursor.getColumnIndex("contrasena"));
			cursor.close();
			return pass;				
		}

}
