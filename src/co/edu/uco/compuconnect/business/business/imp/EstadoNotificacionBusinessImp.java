package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.EstadoNotificacionBusiness;
import co.edu.uco.compuconnect.business.domain.EstadoNotificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class EstadoNotificacionBusinessImp implements EstadoNotificacionBusiness{

	private DAOFactory daoFactory;
	
	public EstadoNotificacionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoNotificacionDomain> consultar(EstadoNotificacionDomain datosFiltroEstadoNotificacion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
