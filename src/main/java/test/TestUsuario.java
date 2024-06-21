package test;

import java.util.List;

import model.TbUsuario;
import dao.UsuarioDao;

public class TestUsuario {
	public static void main(String[] args){
		//instanciar usuario
		TbUsuario usuario = new TbUsuario();
		UsuarioDao crud = new UsuarioDao();
	
		//Inicio de metodo Crear
		usuario.setUsuario("Naomi Zuares");
		usuario.setPassword("12345");
		crud.RegistrarUsuario(usuario);  
		



		
		//Metodo que lista los usuarios
		List<TbUsuario> listar = crud.listarUsuario();
		for(TbUsuario list:listar){
			System.out.println(
					" Codigo: "+list.getIdusuario()+","+
			        " Nombre: "+list.getUsuario()+","+
				    " Password: "+list.getPassword()
					);			
		} 
		
		
		
	}


}
