package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IProducto;
import model.TbProducto;

public class ProductoDao implements IProducto {

	@Override
	public void RegistrarProducto(TbProducto producto) {
		//Establecer conexion		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("GuevaraMore_CL2_LPII");
		//gestionar las entidades
		EntityManager manager = em.createEntityManager();
		//iniciamos la transaccion
		manager.getTransaction().begin();
		//registro en la base de datos
		manager.persist(producto);
		
		//mostrar mensaje
		System.out.println("Usuario registrado con exito!");
		//confirmamos la transaccion
		manager.getTransaction().commit();
		//cerramos
		manager.close();

		
	}

	@Override
	public void ActualizarProducto(TbProducto producto) {
		//Establecer conexion		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("GuevaraMore_CL2_LPII");
		//gestionar las entidades
		EntityManager manager = em.createEntityManager();
		//iniciamos la transaccion
		manager.getTransaction().begin();
		//Actualizar en la base de datos
		manager.merge(producto);
		
		//mostrar mensaje
		System.out.println("Producto actualizado correctamente!");
		//confirmamos la transaccion
		manager.getTransaction().commit();
		//cerramos
		manager.close();

		
	}

	@Override
	public void EliminarProducto(TbProducto producto) {
		//Establecer conexion		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("GuevaraMore_CL2_LPII");
		//gestionar las entidades
		EntityManager manager = em.createEntityManager();
		//iniciamos la transaccion
		manager.getTransaction().begin();
		TbProducto elim = manager.merge(producto);
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
	public TbProducto BuscarProducto(TbProducto producto) {
		//Establecer conexion		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("GuevaraMore_CL2_LPII");
		//gestionar las entidades
		EntityManager manager = em.createEntityManager();
		//iniciamos la transaccion
		manager.getTransaction().begin();
		TbProducto buscarProducto = manager.find(TbProducto.class,producto.getIdproducto());
		//mostrar mensaje
		System.out.println("Producto encontrado");
		//confirmamos la transaccion
		manager.getTransaction().commit();
		//cerramos
		manager.close();

		return buscarProducto;

	}

	@Override
	public List<TbProducto> listarProductos() {
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
				List<TbProducto> listarProductos = manager.createQuery("select t from TblProductocl1 t",TbProducto.class).getResultList();
				
				//mostrar mensaje
				System.out.println("Listado de productos");
				//confirmamos la transaccion
				manager.getTransaction().commit();
				//cerramos
				manager.close();

				return listarProductos;

	}

}
