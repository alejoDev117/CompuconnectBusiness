package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.PerfilBusiness;
import co.edu.uco.compuconnect.business.domain.PerfilDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class PerfilBusinessImp implements PerfilBusiness{
	
	private DAOFactory daoFactory;
	
	
	public PerfilBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(PerfilDomain datosPerfil) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actualizar(PerfilDomain datosActualizarPerfil) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(PerfilDomain datosBorrarPerfil) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<PerfilDomain> consultar(PerfilDomain datosFiltroPerfil) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
