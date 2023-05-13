package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.DiaFestivoDomain;
import co.edu.uco.compuconnect.dto.DiaFestivoDTO;

public interface DiaFestivoFacade {
	
	List<DiaFestivoDTO> consultar(DiaFestivoDTO dto);
	
	

}
