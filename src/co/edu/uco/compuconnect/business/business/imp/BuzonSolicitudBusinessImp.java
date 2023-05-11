package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.BuzonSolicitudAssembler;
import co.edu.uco.compuconnect.business.business.BuzonSolicitudBusiness;
import co.edu.uco.compuconnect.business.domain.BuzonSolicitudDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.BuzonSolicitudEntity;

public final class BuzonSolicitudBusinessImp implements BuzonSolicitudBusiness{
	
	private DAOFactory daoFactory;
	
	public BuzonSolicitudBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void generar(BuzonSolicitudDomain datosBuzonSolicitud) {
		final BuzonSolicitudEntity entity = BuzonSolicitudAssembler.getInstance().toEntityFromDomain(datosBuzonSolicitud);
		daoFactory.getBuzonSolicitudDAO().create(entity);
		
	}

	@Override
	public void actualizar(BuzonSolicitudDomain datosActualizacionBuzonSolicitud) {
		final BuzonSolicitudEntity entity = BuzonSolicitudAssembler.getInstance().toEntityFromDomain(datosActualizacionBuzonSolicitud);
		daoFactory.getBuzonSolicitudDAO().update(entity);
		
	}

	@Override
	public List<BuzonSolicitudDomain> consultar(BuzonSolicitudDomain datosFiltroBuzonSolicitud) {
		final BuzonSolicitudEntity entity = BuzonSolicitudAssembler.getInstance().toEntityFromDomain(datosFiltroBuzonSolicitud);
		final List<BuzonSolicitudEntity> result = daoFactory.getBuzonSolicitudDAO().read(entity);
		return BuzonSolicitudAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	

}
