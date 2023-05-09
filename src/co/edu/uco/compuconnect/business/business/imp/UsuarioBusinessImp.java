package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.UsuarioAssembler;
import co.edu.uco.compuconnect.business.business.UsuarioBusiness;
import co.edu.uco.compuconnect.business.domain.UsuarioDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.UsuarioEntity;

public final class UsuarioBusinessImp implements UsuarioBusiness{
	
	private DAOFactory daoFactory;
	
	public UsuarioBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(UsuarioDomain datosUsuario) {
		final UsuarioEntity entity = UsuarioAssembler.getInstance().toEntityFromDomain(datosUsuario);
		daoFactory.getUsuarioDAO().create(entity);
		
	}

	@Override
	public List<UsuarioDomain> consultar(UsuarioDomain datosFiltroUsuario) {
		final UsuarioEntity entity = UsuarioAssembler.getInstance().toEntityFromDomain(datosFiltroUsuario);
		final List<UsuarioEntity> result = daoFactory.getUsuarioDAO().read(entity);
		return null;
	}

	@Override
	public void eliminar(UsuarioDomain datosEliminacionUsuario) {
		final UsuarioEntity entity = UsuarioAssembler.getInstance().toEntityFromDomain(datosEliminacionUsuario);
		daoFactory.getUsuarioDAO().delete(entity);
		
	}

	@Override
	public void modificar(UsuarioDomain datosModificacionUsuario) {
		final UsuarioEntity entity = UsuarioAssembler.getInstance().toEntityFromDomain(datosModificacionUsuario);
		daoFactory.getUsuarioDAO().update(entity);
		
	}
	
	

}
