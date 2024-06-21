package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IUsuario;
import model.TbUsuario;

public class UsuarioDao implements IUsuario {

	@Override
	public void RegistrarUsuario(TbUsuario usuario) {	
			//Establecer conexion		
			EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL1_GuevaraMoreAlex");
			//gestionar las entidades
			EntityManager manager = em.createEntityManager();
			//iniciamos la transaccion
			manager.getTransaction().begin();
			//registro en la base de datos
			manager.persist(usuario);
			
			//mostrar mensaje
			System.out.println("Usuario registrado con exito!");
			//confirmamos la transaccion
			manager.getTransaction().commit();
			//cerramos
			manager.close();

		
	}

	@Override
	public void ActualizarUsuario(TbUsuario usuario) {
		//Establecer conexion		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("GuevaraMore_CL2_LPII");
		//gestionar las entidades
		EntityManager manager = em.createEntityManager();
		//iniciamos la transaccion
		manager.getTransaction().begin();
		//Actualizar en la base de datos
		manager.merge(usuario);
		
		//mostrar mensaje
		System.out.println("Usuario actualizado correctamente!");
		//confirmamos la transaccion
		manager.getTransaction().commit();
		//cerramos
		manager.close();

		
	}

	@Override
	public void EliminarUsuario(TbUsuario usuario) {
		//Establecer conexion		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("GuevaraMore_CL2_LPII");
		//gestionar las entidades
		EntityManager manager = em.createEntityManager();
		//iniciamos la transaccion
		manager.getTransaction().begin();
		TbUsuario elim = manager.merge(usuario);
		//eliminar registro
		manager.remove(elim);
		
		//mostrar mensaje
		System.out.println("Se elimino un usuario");
		//confirmamos la transaccion
		manager.getTransaction().commit();
		//cerramos
		manager.close();

		
	}

	@Override
	public TbUsuario BuscarUsuario(TbUsuario usuario) {
		//Establecer conexion		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("GuevaraMore_CL2_LPII");
		//gestionar las entidades
		EntityManager manager = em.createEntityManager();
		//iniciamos la transaccion
		manager.getTransaction().begin();
		//Recuperamos codigo a buscar
		TbUsuario buscarUsuario = manager.find(TbUsuario.class,usuario.getIdusuario());
		
		//mostrar mensaje
		System.out.println("Usuario encontrado");
		//confirmamos la transaccion
		manager.getTransaction().commit();
		//cerramos
		manager.close();
		
		return buscarUsuario;

	}

	@Override
	public List<TbUsuario> listarUsuario() {
		//Establecer conexion		
				EntityManagerFactory em = Persistence.createEntityManagerFactory("GuevaraMore_CL2_LPII");
				//gestionar las entidades
				EntityManager manager = em.createEntityManager();
				//iniciamos la transaccion
				manager.getTransaction().begin();
				/* Utilizando el JPQL
				 * El metodo createQuery de entityManager se usa 
				 * para creacion de consultas dinamicas
				 */
				
				List<TbUsuario> listarUsuarios = manager.createQuery("select t from TblUsuariocl1 t", TbUsuario.class).getResultList();
			
				//mostrar mensaje
				System.out.println("Listando de usuarios");
				//confirmamos la transaccion
				manager.getTransaction().commit();
				//cerramos
				manager.close();
				//retorna el listado
				return listarUsuarios;			

	}

}
