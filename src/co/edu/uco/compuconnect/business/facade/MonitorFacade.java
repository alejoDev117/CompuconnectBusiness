package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.MonitorDTO;

public interface MonitorFacade {
	
	
	void registrar(MonitorDTO dto);
	
	void modificar(MonitorDTO dto);
	
	void eliminar(MonitorDTO dto);
	
	List<MonitorDTO> consultar(MonitorDTO dto);
	
	
}
