package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.UsuarioDomain;

public interface UsuarioBusiness {

	void crear(UsuarioDomain datosUsuario);
	
	List<UsuarioDomain> consultar(UsuarioDomain datosFiltroUsuario);
	
	void eliminar(UsuarioDomain datosEliminacionUsuario);
	
	void modificar(UsuarioDomain datosModificacionUsuario);
	
	
}
