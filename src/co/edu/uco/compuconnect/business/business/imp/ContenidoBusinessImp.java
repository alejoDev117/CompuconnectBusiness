package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.ContenidoAssembler;
import co.edu.uco.compuconnect.business.business.ContenidoBusiness;
import co.edu.uco.compuconnect.business.domain.ContenidoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.ContenidoEntity;

public final class ContenidoBusinessImp implements ContenidoBusiness{
	
	private DAOFactory daoFactory;
	
	
	public ContenidoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(ContenidoDomain datosContenido) {
		final ContenidoEntity entity = ContenidoAssembler.getInstance().toEntityFromDomain(datosContenido);
		daoFactory.getContenidoDAO().create(entity);
		
	}


	@Override
	public void eliminar(ContenidoDomain datosEliminacionContenido) {
		final ContenidoEntity entity = ContenidoAssembler.getInstance().toEntityFromDomain(datosEliminacionContenido);
		daoFactory.getContenidoDAO().delete(entity);
		
	}


	@Override
	public List<ContenidoDomain> consultar(ContenidoDomain datosFiltroContenido) {
		final ContenidoEntity entity = ContenidoAssembler.getInstance().toEntityFromDomain(datosFiltroContenido);
		final List<ContenidoEntity> result = daoFactory.getContenidoDAO().read(entity);
		return ContenidoAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	
	

}
