package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.PeriodoFuncionamientoDiaFestivoDTO;

public interface PeriodoFuncionamientoDiaFestivoFacade {
	
	void crear(PeriodoFuncionamientoDiaFestivoDTO dto);
	
	List<PeriodoFuncionamientoDiaFestivoDTO>consultar(PeriodoFuncionamientoDiaFestivoDTO dto);
	
	void eliminar(PeriodoFuncionamientoDiaFestivoDTO dto);

}
