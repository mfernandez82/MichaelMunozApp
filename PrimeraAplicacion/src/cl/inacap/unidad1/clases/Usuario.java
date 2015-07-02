package cl.inacap.unidad1.clases;

import java.util.ArrayList;

public class Usuario {
	public int id_usuario;
	public String nombre_usuario;
	public String login_usuario;
	public String contrasena;

	//se genera y obtiene la lista de usuarios
	public ArrayList<Usuario> listaUsuarios()
	{
		 ArrayList<Usuario> lista = new  ArrayList<Usuario>();
		
	
		 
		 
		 Usuario usuario = new Usuario();
		 usuario.id_usuario=1;
		 usuario.nombre_usuario="Juan Perez";
		 usuario.login_usuario="Juan";
		 usuario.contrasena="Juan";		  
		 lista.add(usuario);
		 
		 usuario = new Usuario();
		 usuario.id_usuario=2;
		 usuario.nombre_usuario="Usuario Test";
		 usuario.login_usuario="test";
		 usuario.contrasena="test"; 
		 lista.add(usuario);
		 
		return lista;
	}

	
	//se realiza la validacion del login de usuario
	
	public boolean validarLogin(String login,String contrasena)
	{
		Usuario usuario;
		ArrayList<Usuario> usuarios=listaUsuarios();
		int largo= usuarios.size();	
		for(int i=0;i <largo;i++)
		{
			usuario=usuarios.get(i);
			if(usuario.login_usuario.equals(login)&& usuario.contrasena.equals(contrasena))
			{
				return true;
			}
		}
		
		return false;
	}

	//forma string de la clase
	
	public String  toString()
	{
		return String.valueOf(this.id_usuario) + " : " + this.nombre_usuario +" ("+ this.login_usuario + ")";                         
	}
	
	
}
