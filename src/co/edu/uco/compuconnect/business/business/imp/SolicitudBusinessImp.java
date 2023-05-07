package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.SolicitudBusiness;
import co.edu.uco.compuconnect.business.domain.SolicitudDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final  class SolicitudBusinessImp implements SolicitudBusiness{
	
	private DAOFactory daoFactory;
	
	
	public SolicitudBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(SolicitudDomain datosSolicitud) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enviar(SolicitudDomain datosEnvioSolicitud) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<SolicitudDomain> consultar(SolicitudDomain datosFiltroSolicitud) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
