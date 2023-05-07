package co.edu.uco.compuconnect.business.business;

import java.util.List;

public interface PerfilBusiness {

	void crear(PerfilDomain datosPerfil);
	
	void actualizar(PerfilDomain datosActualizarPerfil);
	
	void eliminar(PerfilDomain datosBorrarPerfil);
	
	List<PerfilDomain> consultar(PerfilDomain datosFiltroPerfil);
	
	
	
}
