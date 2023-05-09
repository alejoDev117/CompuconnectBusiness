package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.SolicitudAssembler;
import co.edu.uco.compuconnect.business.business.SolicitudBusiness;
import co.edu.uco.compuconnect.business.domain.SolicitudDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.SolicitudEntity;

public final  class SolicitudBusinessImp implements SolicitudBusiness{
	
	private DAOFactory daoFactory;
	
	
	public SolicitudBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(SolicitudDomain datosSolicitud) {
		final SolicitudEntity entity = SolicitudAssembler.getInstance().toEntityFromDomain(datosSolicitud);
		daoFactory.getSolicitudDAO().create(entity);
		
	}


	@Override
	public void enviar(SolicitudDomain datosEnvioSolicitud) {
		final SolicitudEntity entity = SolicitudAssembler.getInstance().toEntityFromDomain(datosEnvioSolicitud);
		daoFactory.getSolicitudDAO().update(entity);
		
	}


	@Override
	public List<SolicitudDomain> consultar(SolicitudDomain datosFiltroSolicitud) {
		final SolicitudEntity entity = SolicitudAssembler.getInstance().toEntityFromDomain(datosFiltroSolicitud);
		final List<SolicitudEntity> result = daoFactory.getSolicitudDAO().read(entity);
		return null;
	}
	
	
	

}
