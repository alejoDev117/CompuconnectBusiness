package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.AgendaReservaBusiness;
import co.edu.uco.compuconnect.business.domain.AgendaReservaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public class AgendaReservaBusinessImp implements AgendaReservaBusiness{
	
	private DAOFactory daoFactory;
	
	public AgendaReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(AgendaReservaDomain datosAgendaReserva) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AgendaReservaDomain> consultar(AgendaReservaDomain datosFiltroAgendaReserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(AgendaReservaDomain datosEliminacionAgendaReserva) {
		// TODO Auto-generated method stub
		
	}

	
	
}
