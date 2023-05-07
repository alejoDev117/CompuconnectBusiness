package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.EstadoPeriodoFuncionamientoBusiness;
import co.edu.uco.compuconnect.business.domain.EstadoPeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class EstadoPeriodoFuncionamientoBusinessImp implements EstadoPeriodoFuncionamientoBusiness{

	private DAOFactory daoFactory;
	
	public EstadoPeriodoFuncionamientoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoPeriodoFuncionamientoDomain> consultar(
			EstadoPeriodoFuncionamientoDomain datosFiltroFuncionamiento) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
