package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.TipoSolicitudBusiness;
import co.edu.uco.compuconnect.business.domain.TipoSolicitudDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class TipoSolicitudBusinessImp implements TipoSolicitudBusiness{
	
	private DAOFactory daoFactory;
	
	
	public TipoSolicitudBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public List<TipoSolicitudDomain> consultar(TipoSolicitudDomain datosFiltroTipoSolicitud) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
