package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.AgendaBusiness;
import co.edu.uco.compuconnect.business.domain.AgendaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class AgendaBusinessImp implements AgendaBusiness{
	
	private DAOFactory daoFactory;
	
	public AgendaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(AgendaDomain datosAgenda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AgendaDomain> consultar(AgendaDomain datosFiltroAgenda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(AgendaDomain datosActualizacionAgenda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(AgendaDomain datosEliminacionAgenda) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
