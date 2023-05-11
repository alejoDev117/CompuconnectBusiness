package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.SolicitudPerfilAssembler;
import co.edu.uco.compuconnect.business.business.SolicitudBusiness;
import co.edu.uco.compuconnect.business.business.SolicitudPerfilBusiness;
import co.edu.uco.compuconnect.business.domain.SolicitudPerfilDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.SolicitudPerfilEntity;

public class SolicitudPerfilBusinessImp implements SolicitudPerfilBusiness{
	
	private DAOFactory daoFactory;
	
	public SolicitudPerfilBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(SolicitudPerfilDomain datosSolicitudPerfil) {
		final SolicitudPerfilEntity entity = SolicitudPerfilAssembler.getInstance().toEntityFromDomain(datosSolicitudPerfil);
		daoFactory.getSolicitudPerfilDAO().create(entity);
	}

	@Override
	public List<SolicitudPerfilDomain> consultar(SolicitudPerfilDomain datosFiltroSolicitudPerfil) {
		final SolicitudPerfilEntity entity = SolicitudPerfilAssembler.getInstance().toEntityFromDomain(datosFiltroSolicitudPerfil); 
		final List<SolicitudPerfilEntity> resultEntityList = daoFactory.getSolicitudPerfilDAO().read(entity);
		
		return SolicitudPerfilAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void eliminar(SolicitudPerfilDomain datosEliminacionSolicitudPerfil) {
		final SolicitudPerfilEntity entity = SolicitudPerfilAssembler.getInstance().toEntityFromDomain(datosEliminacionSolicitudPerfil); 
		daoFactory.getSolicitudPerfilDAO().delete(entity);
		
	}
	

}
