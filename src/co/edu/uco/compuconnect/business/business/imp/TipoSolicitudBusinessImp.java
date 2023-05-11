package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.TipoSolicitudAssembler;
import co.edu.uco.compuconnect.business.business.TipoSolicitudBusiness;
import co.edu.uco.compuconnect.business.domain.TipoSolicitudDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.TipoSolicitudEntity;

public final class TipoSolicitudBusinessImp implements TipoSolicitudBusiness{
	
	private DAOFactory daoFactory;
	
	
	public TipoSolicitudBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public List<TipoSolicitudDomain> consultar(TipoSolicitudDomain datosFiltroTipoSolicitud) {
		final TipoSolicitudEntity entity = TipoSolicitudAssembler.getInstance().toEntityFromDomain(datosFiltroTipoSolicitud);
		final List<TipoSolicitudEntity> result = daoFactory.getTipoSolicitudDAO().read(entity);
		return TipoSolicitudAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	

}
