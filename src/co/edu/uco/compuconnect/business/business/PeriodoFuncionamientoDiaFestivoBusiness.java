package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDiaFestivoDomain;

public interface PeriodoFuncionamientoDiaFestivoBusiness {
	
	void crear(PeriodoFuncionamientoDiaFestivoDomain datosPeriodoFuncionamientoDiaFestivo);
	
	List<PeriodoFuncionamientoDiaFestivoDomain>consultar(PeriodoFuncionamientoDiaFestivoDomain datosFiltroPeriodoFuncionamientoDiaFestivo);
	
	void eliminar(PeriodoFuncionamientoDiaFestivoDomain datosEliminacionPeriodoFuncionamientoDiaFestivo);

}
