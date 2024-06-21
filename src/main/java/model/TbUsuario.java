package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name="tb_usuario")
@NamedQuery(name="TbUsuario.findAll", query="SELECT t FROM TbUsuario t")
public class TbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idusuario;

	private String password;

	private String usuario;

	public TbUsuario() {
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}