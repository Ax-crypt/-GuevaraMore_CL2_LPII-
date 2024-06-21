package interfaces;

import java.util.List;

import model.TbUsuario;

public interface IUsuario {
	public void RegistrarUsuario(TbUsuario usuario);
	public void ActualizarUsuario(TbUsuario usuario);
	public void EliminarUsuario(TbUsuario usuario);
	public TbUsuario BuscarUsuario(TbUsuario usuario);
	public List<TbUsuario> listarUsuario();


}
