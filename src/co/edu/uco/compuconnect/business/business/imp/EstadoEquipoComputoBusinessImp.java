package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.EstadoEquipoComputoAssembler;
import co.edu.uco.compuconnect.business.business.EstadoEquipoComputoBusiness;
import co.edu.uco.compuconnect.business.domain.EstadoEquipoComputoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.EstadoEquipoComputoEntity;

public final class EstadoEquipoComputoBusinessImp implements EstadoEquipoComputoBusiness{
	
	private DAOFactory daoFactory;

	public EstadoEquipoComputoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoEquipoComputoDomain> consultar(EstadoEquipoComputoDomain datosFiltroEstadoEquipoComputo) {
		final EstadoEquipoComputoEntity entity = EstadoEquipoComputoAssembler.getInstance().toEntityFromDomain(datosFiltroEstadoEquipoComputo);
		final List<EstadoEquipoComputoEntity> result = daoFactory.getEstadoEquipoComputoDAO().read(entity);
		return EstadoEquipoComputoAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
}
