package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.SolicitudPerfilDomain;

public interface SolicitudPerfilBusiness {

	void crear(SolicitudPerfilDomain datosSolicitudPerfil);
	
	List<SolicitudPerfilDomain> consultar(SolicitudPerfilDomain datosFiltroSolicitudPerfil);
	
	void eliminar(SolicitudPerfilDomain datosEliminacionSolicitudPerfil);
	
}
