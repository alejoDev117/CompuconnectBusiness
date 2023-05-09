package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.TipoUsuarioAssembler;
import co.edu.uco.compuconnect.business.business.TipoUsuarioBusiness;
import co.edu.uco.compuconnect.business.domain.TipoUsuarioDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.TipoUsuarioEntity;

public final  class TipoUsuarioBusinessImp implements TipoUsuarioBusiness{
	
	private DAOFactory daoFactory;
	
	public TipoUsuarioBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoUsuarioDomain> consultar(TipoUsuarioDomain datosFiltroTipoUsuario) {
		final TipoUsuarioEntity entity = TipoUsuarioAssembler.getInstance().toEntityFromDomain(datosFiltroTipoUsuario);
		final List<TipoUsuarioEntity> result = daoFactory.getTipoUsuarioDAO().read(entity);
		return null;
	}
	
	

}
