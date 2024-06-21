package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_producto database table.
 * 
 */
@Entity
@Table(name="tb_producto")
@NamedQuery(name="TbProducto.findAll", query="SELECT t FROM TbProducto t")
public class TbProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproducto;

	private String descripcion;

	private String estado;

	private String nombre;

	private String preciocompra;

	private String precioventa;

	public TbProducto() {
	}

	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPreciocompra() {
		return this.preciocompra;
	}

	public void setPreciocompra(String preciocompra) {
		this.preciocompra = preciocompra;
	}

	public String getPrecioventa() {
		return this.precioventa;
	}

	public void setPrecioventa(String precioventa) {
		this.precioventa = precioventa;
	}

}