package co.edu.uco.compuconnect.business.business.imp;

import co.edu.uco.compuconnect.business.business.NotificacionBusiness;
import co.edu.uco.compuconnect.business.domain.NotificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class NotificacionBusinessImp implements NotificacionBusiness{
	
	private DAOFactory daoFactory;
	
	
	public NotificacionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void generar(NotificacionDomain datosNotificacion) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
