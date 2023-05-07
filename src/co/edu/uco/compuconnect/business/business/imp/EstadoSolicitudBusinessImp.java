package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.EstadoSolicitudBusiness;
import co.edu.uco.compuconnect.business.domain.EstadoSolicitudDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class EstadoSolicitudBusinessImp implements EstadoSolicitudBusiness{
	
	private DAOFactory daoFactory;
	
	public EstadoSolicitudBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoSolicitudDomain> consultar(EstadoSolicitudDomain datosFiltroFuncionamiento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
