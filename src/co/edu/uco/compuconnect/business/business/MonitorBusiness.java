package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.MonitorDomain;

public interface MonitorBusiness {
	
	
	void registrar(MonitorDomain datosMonitor);
	
	void modificar(MonitorDomain datosMotificacionMontor);
	
	void eliminar(MonitorDomain datosBorrarMonitor);
	
	List<MonitorDomain> consultar(MonitorDomain datosFiltroMonitor);
	
	
}
