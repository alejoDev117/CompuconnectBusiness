package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.MonitorAssembler;
import co.edu.uco.compuconnect.business.business.MonitorBusiness;
import co.edu.uco.compuconnect.business.domain.MonitorDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.MonitorEntity;

public final class MonitorBusinessImp implements MonitorBusiness{
	
	private DAOFactory daoFactory;
	
	
	public MonitorBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void registrar(MonitorDomain datosMonitor) {
		final MonitorEntity entity = MonitorAssembler.getInstance().toEntityFromDomain(datosMonitor);
		daoFactory.getMonitorDAO().create(entity);
		
	}


	@Override
	public void modificar(MonitorDomain datosMotificacionMontor) {
		final MonitorEntity entity = MonitorAssembler.getInstance().toEntityFromDomain(datosMotificacionMontor);
		daoFactory.getMonitorDAO().update(entity);
		
	}


	@Override
	public void eliminar(MonitorDomain datosBorrarMonitor) {
		final MonitorEntity entity = MonitorAssembler.getInstance().toEntityFromDomain(datosBorrarMonitor);
		daoFactory.getMonitorDAO().delete(entity);
		
	}


	@Override
	public List<MonitorDomain> consultar(MonitorDomain datosFiltroMonitor) {
		final MonitorEntity entity = MonitorAssembler.getInstance().toEntityFromDomain(datosFiltroMonitor);
		final List<MonitorEntity> result = daoFactory.getMonitorDAO().read(entity);
		return null;
	}
	
	
	

}
