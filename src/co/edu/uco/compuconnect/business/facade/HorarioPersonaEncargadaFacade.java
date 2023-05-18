package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.HorarioPersonaEncargadaDTO;

public interface HorarioPersonaEncargadaFacade {
	
	void asignar(HorarioPersonaEncargadaDTO dto);
	
	void eliminar(HorarioPersonaEncargadaDTO dto);
	
	List<HorarioPersonaEncargadaDTO> consultar(HorarioPersonaEncargadaDTO dto);

}
