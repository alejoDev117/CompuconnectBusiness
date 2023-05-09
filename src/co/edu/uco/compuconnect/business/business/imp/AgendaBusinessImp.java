package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.AgendaAssembler;
import co.edu.uco.compuconnect.business.business.AgendaBusiness;
import co.edu.uco.compuconnect.business.domain.AgendaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.AgendaEntity;

public final class AgendaBusinessImp implements AgendaBusiness{
	
	private DAOFactory daoFactory;
	
	public AgendaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(AgendaDomain datosAgenda) {
		final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(datosAgenda);
		daoFactory.getAgendaDAO().create(entity);
		
	}

	@Override
	public List<AgendaDomain> consultar(AgendaDomain datosFiltroAgenda) {
		final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(datosFiltroAgenda);
		final List<AgendaEntity> result = daoFactory.getAgendaDAO().read(entity);
		return null;
	}

	@Override
	public void actualizar(AgendaDomain datosActualizacionAgenda) {
		final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(datosActualizacionAgenda);
		daoFactory.getAgendaDAO().uptade(entity);
		
	}

	@Override
	public void eliminar(AgendaDomain datosEliminacionAgenda) {
		final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(datosEliminacionAgenda);
		daoFactory.getAgendaDAO().delete(entity);
	}
	
	

}
