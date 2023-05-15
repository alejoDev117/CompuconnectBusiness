package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.DetalleReservaAssembler;
import co.edu.uco.compuconnect.business.business.DetalleReservaBusiness;
import co.edu.uco.compuconnect.business.domain.DetalleReservaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.DetalleReservaEntity;

public final class DetalleReservaBusinessImp implements DetalleReservaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public DetalleReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(DetalleReservaDomain datosDetalleReserva) {
		final DetalleReservaEntity entity = DetalleReservaAssembler.getInstance().toEntityFromDomain(datosDetalleReserva);
		daoFactory.getDetalleReservaDAO().create(entity);
		
	}


	@Override
	public void modificar(DetalleReservaDomain datosModificacionDetalleReserva) {
		final DetalleReservaEntity entity = DetalleReservaAssembler.getInstance().toEntityFromDomain(datosModificacionDetalleReserva);
		daoFactory.getDetalleReservaDAO().update(entity);
		
	}


	@Override
	public void eliminar(DetalleReservaDomain datosEliminacionDetalleReserva) {
		final DetalleReservaEntity entity = DetalleReservaAssembler.getInstance().toEntityFromDomain(datosEliminacionDetalleReserva);
		daoFactory.getDetalleReservaDAO().delete(entity);
		
	}


	@Override
	public List<DetalleReservaDomain> consultar(DetalleReservaDomain datosFiltroDetalleReserva) {
		final DetalleReservaEntity entity = DetalleReservaAssembler.getInstance().toEntityFromDomain(datosFiltroDetalleReserva);
		final List<DetalleReservaEntity> result = daoFactory.getDetalleReservaDAO().read(entity);
		return DetalleReservaAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	

}
