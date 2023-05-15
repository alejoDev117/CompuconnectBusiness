package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.SolicitudDomain;

public interface SolicitudBusiness {

	void crear(SolicitudDomain datosSolicitud);
	
	void enviar(SolicitudDomain datosEnvioSolicitud);
	
	List<SolicitudDomain> consultar(SolicitudDomain datosFiltroSolicitud);
	
	
}
