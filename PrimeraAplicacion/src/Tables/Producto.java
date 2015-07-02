package Tables;


import DB.DataBaseSQLite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Producto {
public static final String NOM_TABLE = "PRODUCTOS";
	
	public static final String PRODUCTO_ID ="_id";
	public static final String PRODUCTO_MARCA ="marca";
	public static final String PRODUCTO_NOMBRE ="nombre";	
	public static final String PRODUCTO_PRECIO ="precio";
	public static final String PRODUCTO_STOCK ="stock";
	public static final String PRODUCTO_ESTADO ="estado";
	
	public static final String CREATE_TABLE_PRODUCTOS ="CREATE TABLE " + NOM_TABLE
								+ "( "+ PRODUCTO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
								+ PRODUCTO_NOMBRE +" TEXT, "
								+ PRODUCTO_MARCA +" TEXT, "
            					+ PRODUCTO_PRECIO +" INTEGER,"
            					+ PRODUCTO_STOCK +" INTEGER,"
            					+ PRODUCTO_ESTADO + " INTEGER); ";
	
	
	private DataBaseSQLite helper;
	private SQLiteDatabase sdb;
	
	public Producto(Context context)
		{
			helper = new DataBaseSQLite(context);
			sdb = helper.getWritableDatabase();		
		}
	
	public ContentValues GenerarCV(String mar, String nom, int pre, int sto, int est)
		{
			ContentValues values =  new ContentValues();
			values.put(PRODUCTO_MARCA, mar);
			values.put(PRODUCTO_NOMBRE, nom);
			values.put(PRODUCTO_PRECIO, pre);
			values.put(PRODUCTO_STOCK, sto);
			values.put(PRODUCTO_ESTADO, est);
		
			return values;	
		}
	
	public void InsertProducto (String mar, String nom, int pre, int sto, int est)
		{	
			sdb.insert(NOM_TABLE, null, GenerarCV(mar, nom,pre,sto, est));		
		}
	
	 public void UpdateProducto(String mar, String nom, int pre, int sto, int est)
	    {	
			sdb.update(NOM_TABLE, GenerarCV(mar, nom, pre,sto, est), PRODUCTO_NOMBRE +"=?", new String []{nom});	
		}
	 
	public void DeleteProducto(String nom)
		{
			sdb.delete(NOM_TABLE, PRODUCTO_NOMBRE +"=?", new String[] {nom});	
		}
	 	
	public Cursor SetCursorProducto()
		{		
			String[] columnas = new String[] {PRODUCTO_ID+" AS ID ",PRODUCTO_MARCA,PRODUCTO_NOMBRE,PRODUCTO_PRECIO,PRODUCTO_STOCK};				
			return	sdb.query(NOM_TABLE, columnas, null, null, null, null, null);			
		}
	
	public Cursor GetProductos()
		{		
			String[] columnas = new String[] {PRODUCTO_ID+" AS ID ",PRODUCTO_MARCA,PRODUCTO_NOMBRE,PRODUCTO_PRECIO,PRODUCTO_STOCK,PRODUCTO_ESTADO};				
			return	sdb.query(NOM_TABLE, columnas, null, null, null, null, null);			
		}	
	
}
