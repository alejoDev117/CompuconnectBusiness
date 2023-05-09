package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.ExcepcionAgendaAssembler;
import co.edu.uco.compuconnect.business.business.ExcepcionAgendaBusiness;
import co.edu.uco.compuconnect.business.domain.ExcepcionAgendaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.ExcepcionAgendaEntity;

public final class ExcepcionAgendaBusinessImp implements ExcepcionAgendaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public ExcepcionAgendaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void asignar(ExcepcionAgendaDomain datosAsignarExcepcionAgenda) {
		final ExcepcionAgendaEntity entity = ExcepcionAgendaAssembler.getInstance().toEntityFromDomain(datosAsignarExcepcionAgenda);
		daoFactory.getExcepcionAgendaDAO().create(entity);
		
	}


	@Override
	public void eliminar(ExcepcionAgendaDomain datosBorrarExcepcionAgenda) {
		final ExcepcionAgendaEntity entity = ExcepcionAgendaAssembler.getInstance().toEntityFromDomain(datosBorrarExcepcionAgenda);
		daoFactory.getExcepcionAgendaDAO().delete(entity);
		
		
	}


	@Override
	public List<ExcepcionAgendaDomain> consultar(ExcepcionAgendaDomain datosFiltroExcepcionAgenda) {
		final ExcepcionAgendaEntity entity = ExcepcionAgendaAssembler.getInstance().toEntityFromDomain(datosFiltroExcepcionAgenda);
		final List<ExcepcionAgendaEntity> result = daoFactory.getExcepcionAgendaDAO().read(entity);
		return null;
	}
	
	

}
