package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.PeriodoFuncionamientoBusiness;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public class PeriodoFuncionamientoDiaFestivoBusinessImp implements PeriodoFuncionamientoBusiness{
	
	private DAOFactory daoFactory;
	
	public PeriodoFuncionamientoDiaFestivoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(PeriodoFuncionamientoDomain datosPeriodoFuncionamiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(PeriodoFuncionamientoDomain datosModificacionPeriodoFuncionamiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(PeriodoFuncionamientoDomain datosEliminacionPeriodoFuncionamiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PeriodoFuncionamientoDomain> consultar(PeriodoFuncionamientoDomain datosFiltroPeriodoFuncionamiento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
