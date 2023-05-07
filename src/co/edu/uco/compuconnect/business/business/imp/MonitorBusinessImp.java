package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.MonitorBusiness;
import co.edu.uco.compuconnect.business.domain.MonitorDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class MonitorBusinessImp implements MonitorBusiness{
	
	private DAOFactory daoFactory;
	
	
	public MonitorBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void registrar(MonitorDomain datosMonitor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificar(MonitorDomain datosMotificacionMontor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(MonitorDomain datosBorrarMonitor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<MonitorDomain> consultar(MonitorDomain datosFiltroMonitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
