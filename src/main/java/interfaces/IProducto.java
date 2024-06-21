package interfaces;

import java.util.List;

import model.TbProducto;

public interface IProducto {
	public void RegistrarProducto(TbProducto producto);
	public void ActualizarProducto(TbProducto producto);
	public void EliminarProducto(TbProducto producto);
	public TbProducto BuscarProducto(TbProducto producto);
	public List<TbProducto> listarProductos();


}
