package Tables;

import DB.DataBaseSQLite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Cliente {
	
public static final String NOM_TABLE = "CLIENTE";
	
	public static final String CLIENTE_ID ="_id";
	public static final String CLIENTE_NOMBRE ="nombre";
	public static final String CLIENTE_DIRECCION ="direccion";
	public static final String CLIENTE_FONO ="fono";
	public static final String CLIENTE_ID_VENDEDOR ="vendedor";
	public static final String CLIENTE_ESTADO ="estado";

	public static final String CREATE_TABLE_CLIENTES ="CREATE TABLE " + NOM_TABLE
								+ "( "+ CLIENTE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
								+ CLIENTE_NOMBRE +"  TEXT, "
								+ CLIENTE_DIRECCION +" TEXT, "
								+ CLIENTE_FONO +" TEXT,"
								+ CLIENTE_ID_VENDEDOR +" INTEGER,"
								+ CLIENTE_ESTADO + " INTEGER); ";
	
	private DataBaseSQLite helper;
	private SQLiteDatabase sdb;
	
	public Cliente(Context context)
		{
			helper = new DataBaseSQLite(context);
			sdb = helper.getWritableDatabase();
		}
	
	public ContentValues GenerarCV(String nom, String dir, String fon, int ven, int est)
		{
			ContentValues values =  new ContentValues();
			values.put(CLIENTE_NOMBRE, nom);
			values.put(CLIENTE_DIRECCION, dir);
			values.put(CLIENTE_FONO, fon);
			values.put(CLIENTE_ID_VENDEDOR, ven);
			values.put(CLIENTE_ESTADO, est);
		
			return values;		
		}
		
	public void InsertCliente (String nom, String dir, String fon, int ven, int est)
		{	
			sdb.insert(NOM_TABLE, null, GenerarCV(nom, dir,fon,ven, est));		
		}
	
	public void UpdateCliente(String nom, String dir, String fon, int ven, int est)
		{		
			sdb.update(NOM_TABLE, GenerarCV(nom, dir, fon,ven, est), CLIENTE_NOMBRE +"=?", new String []{nom});	
		}
	
	public void DeleteCliente(String nom)
		{
			sdb.delete(NOM_TABLE, CLIENTE_NOMBRE +"=?", new String[] {nom});	
		}
	
	public void DeleteClienteId(String _id)
		{
			sdb.delete(NOM_TABLE, CLIENTE_ID +"=?", new String[] {_id});	
		}
			
	public Cursor SetCursorCliente()
		{		
			String[] columnas = new String[] {CLIENTE_ID +" AS _id ", CLIENTE_NOMBRE +" AS nombre ",CLIENTE_DIRECCION,CLIENTE_FONO};				
			return	sdb.query(NOM_TABLE, columnas, null, null, null, null, null);			
		}	
	
	public Cursor GetCursorCliente(String _id)
		{		
			String[] columnas = new String[] {CLIENTE_ID +" AS _id ",CLIENTE_NOMBRE,CLIENTE_DIRECCION,CLIENTE_FONO};				
			return	sdb.query(NOM_TABLE, columnas, " ID=?"+new String[]{_id}, null, null, null, null);			
		}	
	
}
