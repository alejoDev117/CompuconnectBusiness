package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.DetalleReservaDTO;

public interface DetalleReservaFacade {
	
	void crear(DetalleReservaDTO dto);
	
	void modificar(DetalleReservaDTO dto);
	
	void eliminar(DetalleReservaDTO dto);
	
	List<DetalleReservaDTO> consultar(DetalleReservaDTO dto);
	
}
