package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.DestinatarioDomain;

public interface DestinatarioBusiness {
 
	void registrar(DestinatarioDomain datosRegistroDestinatario);
	
	void modificar(DestinatarioDomain datosModificacionDestintario);
	
	List<DestinatarioDomain> consultar(DestinatarioDomain datosFiltroDestinatario);
	
	void eliminar(DestinatarioDomain datosEliminacionDestinatario);
	
	
}
