package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;



import co.edu.uco.compuconnect.business.assembler.concrete.EstadoPeriodoFuncionamientoAssembler;
import co.edu.uco.compuconnect.business.business.EstadoPeriodoFuncionamientoBusiness;
import co.edu.uco.compuconnect.business.domain.EstadoPeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

import co.edu.uco.compuconnect.entities.EstadoPeriodoFuncionamientoEntity;

public final class EstadoPeriodoFuncionamientoBusinessImp implements EstadoPeriodoFuncionamientoBusiness{

	private DAOFactory daoFactory;
	
	public EstadoPeriodoFuncionamientoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoPeriodoFuncionamientoDomain> consultar(
			EstadoPeriodoFuncionamientoDomain datosFiltroFuncionamiento) {
		final EstadoPeriodoFuncionamientoEntity entity = EstadoPeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(datosFiltroFuncionamiento);
		final List<EstadoPeriodoFuncionamientoEntity> result = daoFactory.getEstadoPeriodoFunicionamientoDAO().read(entity);
		return EstadoPeriodoFuncionamientoAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
}
