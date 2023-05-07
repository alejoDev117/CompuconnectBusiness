package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.TipoNotificacionBusiness;
import co.edu.uco.compuconnect.business.domain.TipoNotificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class TipoNotificacionBusinessImp implements TipoNotificacionBusiness{
	
	private DAOFactory daoFactory;
	
	TipoNotificacionBusinessImp(final DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoNotificacionDomain> consultar(TipoNotificacionDomain datosFiltroTipoNotificacion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
