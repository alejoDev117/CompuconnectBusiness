package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.UsuarioBusiness;
import co.edu.uco.compuconnect.business.domain.UsuarioDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class UsuarioBusinessImp implements UsuarioBusiness{
	
	private DAOFactory daoFactory;
	
	public UsuarioBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(UsuarioDomain datosUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDomain> consultar(UsuarioDomain datosFiltroUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(UsuarioDomain datosEliminacionUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(UsuarioDomain datosModificacionUsuario) {
		// TODO Auto-generated method stub
		
	}
	
	

}
