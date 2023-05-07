package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.TipoIdentificacionBusiness;
import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class TipoIdentificacionBusinessImp implements TipoIdentificacionBusiness{
	
	private DAOFactory daoFactory;
	
	public TipoIdentificacionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoIdentificacionDomain> consultar(TipoIdentificacionDomain datosFiltroTipoIdentificacion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
