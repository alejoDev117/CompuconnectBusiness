package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.TipoReservaBusiness;
import co.edu.uco.compuconnect.business.domain.TipoReservaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class TipoReservaBusinessImp implements TipoReservaBusiness{
	
	private DAOFactory daoFactory;
	
	public TipoReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoReservaDomain> consultar(TipoReservaDomain datosFiltroTipoReserva) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
