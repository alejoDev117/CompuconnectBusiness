package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.TipoUsuarioBusiness;
import co.edu.uco.compuconnect.business.domain.TipoUsuarioDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final  class TipoUsuarioBusinessImp implements TipoUsuarioBusiness{
	
	private DAOFactory daoFactory;
	
	public TipoUsuarioBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoUsuarioDomain> consultar(TipoUsuarioDomain datosFiltroTipoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
