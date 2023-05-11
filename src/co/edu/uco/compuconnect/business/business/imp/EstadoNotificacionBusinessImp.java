package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.EstadoNotificacionAssembler;
import co.edu.uco.compuconnect.business.business.EstadoNotificacionBusiness;
import co.edu.uco.compuconnect.business.domain.EstadoNotificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.EstadoNotificacionEntity;

public final class EstadoNotificacionBusinessImp implements EstadoNotificacionBusiness{

	private DAOFactory daoFactory;
	
	public EstadoNotificacionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoNotificacionDomain> consultar(EstadoNotificacionDomain datosFiltroEstadoNotificacion) {
		final EstadoNotificacionEntity entity = EstadoNotificacionAssembler.getInstance().toEntityFromDomain(datosFiltroEstadoNotificacion);
		final List<EstadoNotificacionEntity> result = daoFactory.getEstadoNotificacionDAO().read(entity);
		return EstadoNotificacionAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	
	
}
