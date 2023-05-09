package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.PerfilAssembler;
import co.edu.uco.compuconnect.business.business.PerfilBusiness;
import co.edu.uco.compuconnect.business.business.PerfilDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.PerfilEntity;

public final class PerfilBusinessImp implements PerfilBusiness{
	
	private DAOFactory daoFactory;
	
	
	public PerfilBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(PerfilDomain datosPerfil) {
		final PerfilEntity entity = PerfilAssembler.getInstance().toEntityFromDomain(datosPerfil);
		daoFactory.getPerfilDAO().create(entity);
		
	}


	@Override
	public void actualizar(PerfilDomain datosActualizarPerfil) {
		final PerfilEntity entity = PerfilAssembler.getInstance().toEntityFromDomain(datosActualizarPerfil);
		daoFactory.getPerfilDAO().update(entity);
		
	}


	@Override
	public void eliminar(PerfilDomain datosBorrarPerfil) {
		final PerfilEntity entity = PerfilAssembler.getInstance().toEntityFromDomain(datosBorrarPerfil);
		daoFactory.getPerfilDAO().delete(entity);
		
	}


	@Override
	public List<PerfilDomain> consultar(PerfilDomain datosFiltroPerfil) {
		final PerfilEntity entity = PerfilAssembler.getInstance().toEntityFromDomain(datosFiltroPerfil);
		final List<PerfilEntity> result = daoFactory.getPerfilDAO().read(entity);
		return null;
	}
	
	

}
