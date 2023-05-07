package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.BuzonSolicitudBusiness;
import co.edu.uco.compuconnect.business.business.BuzonSolicitudDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class BuzonSolicitudBusinessImp implements BuzonSolicitudBusiness{
	
	private DAOFactory daoFactory;
	
	public BuzonSolicitudBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void generar(BuzonSolicitudDomain datosBuzonSolicitud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(BuzonSolicitudDomain datosActualizacionBuzonSolicitud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BuzonSolicitudDomain> consultar(BuzonSolicitudDomain datosFiltroBuzonSolicitud) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
