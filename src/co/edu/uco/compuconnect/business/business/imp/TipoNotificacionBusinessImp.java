package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.TipoNotificacionAssembler;
import co.edu.uco.compuconnect.business.business.TipoNotificacionBusiness;
import co.edu.uco.compuconnect.business.domain.TipoNotificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.TipoNotificacionEntity;

public final class TipoNotificacionBusinessImp implements TipoNotificacionBusiness{
	
	private DAOFactory daoFactory;
	
	public TipoNotificacionBusinessImp(final DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoNotificacionDomain> consultar(TipoNotificacionDomain datosFiltroTipoNotificacion) {
		final TipoNotificacionEntity entity = TipoNotificacionAssembler.getInstance().toEntityFromDomain(datosFiltroTipoNotificacion);
		final List<TipoNotificacionEntity> result = daoFactory.getTipoNotificacionDAO().read(entity);
		return TipoNotificacionAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	

}
