package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.ExcepcionAgendaBusiness;
import co.edu.uco.compuconnect.business.domain.ExcepcionAgendaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class ExcepcionAgendaBusinessImp implements ExcepcionAgendaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public ExcepcionAgendaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void asignar(ExcepcionAgendaDomain datosAsignarExcepcionAgenda) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(ExcepcionAgendaDomain datosBorrarExcepcionAgenda) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ExcepcionAgendaDomain> consultar(ExcepcionAgendaDomain datosFiltroExcepcionAgenda) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
