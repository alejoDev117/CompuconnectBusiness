package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.EstadoPeriodoFuncionamientoAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.EstadoSolicitudAssembler;
import co.edu.uco.compuconnect.business.business.EstadoSolicitudBusiness;
import co.edu.uco.compuconnect.business.domain.EstadoSolicitudDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.EstadoPeriodoFuncionamientoEntity;
import co.edu.uco.compuconnect.entities.EstadoSolicitudEntity;

public final class EstadoSolicitudBusinessImp implements EstadoSolicitudBusiness{
	
	private DAOFactory daoFactory;
	
	public EstadoSolicitudBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoSolicitudDomain> consultar(EstadoSolicitudDomain datosFiltroSolicitud) {
		final EstadoSolicitudEntity entity = EstadoSolicitudAssembler.getInstance().toEntityFromDomain(datosFiltroSolicitud);
		final List<EstadoSolicitudEntity> result = daoFactory.getEstadoSolicitudDAO().read(entity);
		return EstadoSolicitudAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	
	
	
}
