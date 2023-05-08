package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.SolicitudBusiness;
import co.edu.uco.compuconnect.business.business.SolicitudPerfilBusiness;
import co.edu.uco.compuconnect.business.domain.SolicitudPerfilDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public class SolicitudPerfilBusinessImp implements SolicitudPerfilBusiness{
	
	private DAOFactory daoFactory;
	
	public SolicitudPerfilBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(SolicitudPerfilDomain datosSolicitudPerfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SolicitudPerfilDomain> consultar(SolicitudPerfilDomain datosFiltroSolicitudPerfil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(SolicitudPerfilDomain datosEliminacionSolicitudPerfil) {
		// TODO Auto-generated method stub
		
	}
	

}
