package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.DestinatarioNotificacionAssembler;
import co.edu.uco.compuconnect.business.business.DestinatarioNotificacionBusiness;
import co.edu.uco.compuconnect.business.business.DestinatarioNotificacionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.DestinatarioNotificacionEntity;

public final class DestinatarioNotificacionBusinessImp implements DestinatarioNotificacionBusiness{
	
	private DAOFactory daoFactory;
	
	public DestinatarioNotificacionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(DestinatarioNotificacionDomain datosCreacionDestinatarioNotificacion) {
		final DestinatarioNotificacionEntity entity = DestinatarioNotificacionAssembler.getInstance().toEntityFromDomain(datosCreacionDestinatarioNotificacion);
		daoFactory.getDestinatarioNotificacionDAO().create(entity);
	}

	@Override
	public List<DestinatarioNotificacionDomain> consultar(DestinatarioNotificacionDomain datosFiltroDestinatario) {
		final DestinatarioNotificacionEntity entity = DestinatarioNotificacionAssembler.getInstance().toEntityFromDomain(datosFiltroDestinatario);
		final List<DestinatarioNotificacionEntity> result = daoFactory.getDestinatarioNotificacionDAO().read(entity);
		return null;
	}

	@Override
	public void eliminar(DestinatarioNotificacionDomain datosEliminacionDestinatarioNotificacion) {
		final DestinatarioNotificacionEntity entity = DestinatarioNotificacionAssembler.getInstance().toEntityFromDomain(datosEliminacionDestinatarioNotificacion);
		daoFactory.getDestinatarioNotificacionDAO().delete(entity);
		
	}

	

}
