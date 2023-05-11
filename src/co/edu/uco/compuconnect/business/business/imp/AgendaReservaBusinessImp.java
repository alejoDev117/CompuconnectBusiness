package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.AgendaReservaAssembler;
import co.edu.uco.compuconnect.business.business.AgendaReservaBusiness;
import co.edu.uco.compuconnect.business.domain.AgendaReservaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.AgendaReservaEntity;

public class AgendaReservaBusinessImp implements AgendaReservaBusiness{
	
	private DAOFactory daoFactory;
	
	public AgendaReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(AgendaReservaDomain datosAgendaReserva) {
		final AgendaReservaEntity entity = AgendaReservaAssembler.getInstance().toEntityFromDomain(datosAgendaReserva);
		daoFactory.getAgendaReservaDAO().create(entity);
		
	}

	@Override
	public List<AgendaReservaDomain> consultar(AgendaReservaDomain datosFiltroAgendaReserva) {
		final AgendaReservaEntity entity = AgendaReservaAssembler.getInstance().toEntityFromDomain(datosFiltroAgendaReserva);
		final List<AgendaReservaEntity> resultEntityList = daoFactory.getAgendaReservaDAO().read(entity);
		return AgendaReservaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void eliminar(AgendaReservaDomain datosEliminacionAgendaReserva) {
		final AgendaReservaEntity entity = AgendaReservaAssembler.getInstance().toEntityFromDomain(datosEliminacionAgendaReserva);
		daoFactory.getAgendaReservaDAO().delete(entity);
		
	}

	
	
}
