package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.TipoIdentificacionAssembler;
import co.edu.uco.compuconnect.business.business.TipoIdentificacionBusiness;
import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.TipoIdentificacionEntity;

public final class TipoIdentificacionBusinessImp implements TipoIdentificacionBusiness{
	
	private DAOFactory daoFactory;
	
	public TipoIdentificacionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoIdentificacionDomain> consultar(TipoIdentificacionDomain datosFiltroTipoIdentificacion) {
		final TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(datosFiltroTipoIdentificacion);
		final List<TipoIdentificacionEntity> result = daoFactory.getTipoIdentificacionDAO().read(entity);
		return TipoIdentificacionAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	
}
