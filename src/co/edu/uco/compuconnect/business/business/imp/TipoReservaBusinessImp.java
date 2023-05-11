package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.TipoReservaAssembler;
import co.edu.uco.compuconnect.business.business.TipoReservaBusiness;
import co.edu.uco.compuconnect.business.domain.TipoReservaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.TipoReservaEntity;

public final class TipoReservaBusinessImp implements TipoReservaBusiness{
	
	private DAOFactory daoFactory;
	
	public TipoReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoReservaDomain> consultar(TipoReservaDomain datosFiltroTipoReserva) {
		final TipoReservaEntity entity = TipoReservaAssembler.getInstance().toEntityFromDomain(datosFiltroTipoReserva);
		final List<TipoReservaEntity> result = daoFactory.getTipoReservaDAO().read(entity);
		return TipoReservaAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	

}
