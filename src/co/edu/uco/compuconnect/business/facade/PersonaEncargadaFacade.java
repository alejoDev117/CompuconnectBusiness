package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.PersonaEncargadaDTO;

public interface PersonaEncargadaFacade {

	void crear(PersonaEncargadaDTO dto);
	
	void modificar(PersonaEncargadaDTO dto);
	
	void eliminar(PersonaEncargadaDTO dto);
	
	List<PersonaEncargadaDTO> consultar(PersonaEncargadaDTO dto);
}
