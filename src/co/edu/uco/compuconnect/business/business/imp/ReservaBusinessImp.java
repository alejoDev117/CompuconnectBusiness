package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.ReservaAssembler;
import co.edu.uco.compuconnect.business.business.ReservaBusiness;
import co.edu.uco.compuconnect.business.domain.ReservaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.ReservaEntity;

public final class ReservaBusinessImp implements ReservaBusiness{
	
	private DAOFactory daoFactory;
	
	public ReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void generar(ReservaDomain datosReserva) {
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(datosReserva);
		daoFactory.getReservaDAO().create(entity);
		
	}

	@Override
	public void modificar(ReservaDomain datosModReserva) {
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(datosModReserva);
		daoFactory.getReservaDAO().update(entity);
		
	}

	@Override
	public void cancelar(ReservaDomain datosEliminacionReserva) {
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(datosEliminacionReserva);
		daoFactory.getReservaDAO().delete(entity);
		
	}

	@Override
	public List<ReservaDomain> consultar(ReservaDomain datosFiltroReserva) {
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(datosFiltroReserva);
		final List<ReservaEntity> result = daoFactory.getReservaDAO().read(entity);
		return ReservaAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	
	

}
