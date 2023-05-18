package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.TiempoFuncionamientoCentroInformaticaDTO;

public interface TiempoFuncionamientoCentroInformaticaFacade {
	
	void crear(TiempoFuncionamientoCentroInformaticaDTO dto);
	
	void eliminar(TiempoFuncionamientoCentroInformaticaDTO dto);
	
	List<TiempoFuncionamientoCentroInformaticaDTO> consultar(TiempoFuncionamientoCentroInformaticaDTO dto);

}
