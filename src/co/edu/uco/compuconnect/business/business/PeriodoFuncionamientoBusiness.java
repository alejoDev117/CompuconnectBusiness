package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDomain;

public interface PeriodoFuncionamientoBusiness {

	void crear(PeriodoFuncionamientoDomain datosPeriodoFuncionamiento);
	
	void modificar(PeriodoFuncionamientoDomain datosModificacionPeriodoFuncionamiento);
	
	void eliminar(PeriodoFuncionamientoDomain datosEliminacionPeriodoFuncionamiento);
	
	List<PeriodoFuncionamientoDomain> consultar(PeriodoFuncionamientoDomain datosFiltroPeriodoFuncionamiento);
	
	
}
