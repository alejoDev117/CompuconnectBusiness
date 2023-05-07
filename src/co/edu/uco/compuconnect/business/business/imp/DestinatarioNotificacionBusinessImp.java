package co.edu.uco.compuconnect.business.business.imp;

import co.edu.uco.compuconnect.business.business.DestinatarioNotificacionBusiness;
import co.edu.uco.compuconnect.business.business.DestinatarioNotificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class DestinatarioNotificacionBusinessImp implements DestinatarioNotificacionBusiness{
	
	private DAOFactory daoFactory;
	
	public DestinatarioNotificacionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void enviar(DestinatarioNotificacionDomain datosEnvioDestinatarioNotificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generar(DestinatarioNotificacionDomain datosCreacionDestinatarioNotificacion) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
