package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.CentroInformaticaEquipoComputoDTO;

public interface CentroInformaticaEquipoComputoFacade {
	
	void registrar(CentroInformaticaEquipoComputoDTO dto);
	
	void modificar(CentroInformaticaEquipoComputoDTO dto);
	
	List<CentroInformaticaEquipoComputoDTO> consultar(CentroInformaticaEquipoComputoDTO dto);
	
	void eliminar(CentroInformaticaEquipoComputoDTO dto);

}
