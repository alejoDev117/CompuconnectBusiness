package co.edu.uco.compuconnect.business.business.imp;

import co.edu.uco.compuconnect.business.assembler.concrete.NotificacionAssembler;
import co.edu.uco.compuconnect.business.business.NotificacionBusiness;
import co.edu.uco.compuconnect.business.business.NotificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.NotificacionEntity;

public final class NotificacionBusinessImp implements NotificacionBusiness{
	
	private DAOFactory daoFactory;
	
	
	public NotificacionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void generar(NotificacionDomain datosNotificacion) {
		final NotificacionEntity entity = NotificacionAssembler.getInstance().toEntityFromDomain(datosNotificacion);
		daoFactory.getNotificacionDAO().create(entity);
		
	}
	
	
	

}
