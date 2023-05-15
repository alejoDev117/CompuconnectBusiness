package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.BuzonSolicitudDomain;

public interface BuzonSolicitudBusiness {

	void generar(BuzonSolicitudDomain datosBuzonSolicitud);
	
	void actualizar(BuzonSolicitudDomain datosActualizacionBuzonSolicitud);
	
	List<BuzonSolicitudDomain> consultar(BuzonSolicitudDomain datosFiltroBuzonSolicitud);
	
	
}
