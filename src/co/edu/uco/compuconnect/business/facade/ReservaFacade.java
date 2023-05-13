package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.ReservaDomain;
import co.edu.uco.compuconnect.dto.ReservaDTO;

public interface ReservaFacade {

	void generar(ReservaDTO dto);
	
	void modificar(ReservaDTO dto);
	
	void cancelar(ReservaDTO dto);
	
	List<ReservaDTO> consultar(ReservaDTO dto);
	
	
	
}
