package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.SoftwareEquipoComputoDTO;

public interface SoftwareEquipoComputoFacade {

	
	void crear(SoftwareEquipoComputoDTO dto);
	
	void eliminar(SoftwareEquipoComputoDTO dto);
	
	List<SoftwareEquipoComputoDTO> consultar(SoftwareEquipoComputoDTO dto);
}
