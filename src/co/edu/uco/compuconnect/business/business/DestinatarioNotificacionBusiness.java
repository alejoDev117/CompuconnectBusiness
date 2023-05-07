package co.edu.uco.compuconnect.business.business;

public interface  DestinatarioNotificacionBusiness {

	void enviar(DestinatarioNotificacionDomain datosEnvioDestinatarioNotificacion);
	
	void generar(DestinatarioNotificacionDomain datosCreacionDestinatarioNotificacion);
	
	
}
