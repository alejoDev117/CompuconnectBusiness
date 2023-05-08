package co.edu.uco.compuconnect.business.business;

import co.edu.uco.compuconnect.business.domain.DestinatarioNotificacionDomain;

public interface  DestinatarioNotificacionBusiness {

	void enviar(DestinatarioNotificacionDomain datosEnvioDestinatarioNotificacion);
	
	void generar(DestinatarioNotificacionDomain datosCreacionDestinatarioNotificacion);
	
	
}
