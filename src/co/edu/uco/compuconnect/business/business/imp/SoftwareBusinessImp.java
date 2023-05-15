package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.SoftwareAssembler;
import co.edu.uco.compuconnect.business.business.SoftwareBusiness;
import co.edu.uco.compuconnect.business.domain.SoftwareDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.SoftwareEntity;

public final class SoftwareBusinessImp implements SoftwareBusiness{
	
	private DAOFactory daoFactory;
	
	
	public SoftwareBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void añadir(SoftwareDomain datosSoftware) {
		final SoftwareEntity entity = SoftwareAssembler.getInstance().toEntityFromDomain(datosSoftware);
		daoFactory.getSoftwareDAO().create(entity);
		
	}


	@Override
	public void eliminar(SoftwareDomain datosBorrarSoftware) {
		final SoftwareEntity entity = SoftwareAssembler.getInstance().toEntityFromDomain(datosBorrarSoftware);
		daoFactory.getSoftwareDAO().delete(entity);
		
	}


	@Override
	public List<SoftwareDomain> consultar(SoftwareDomain datosFiltroSoftware) {
		final SoftwareEntity entity = SoftwareAssembler.getInstance().toEntityFromDomain(datosFiltroSoftware);
		final List<SoftwareEntity> result = daoFactory.getSoftwareDAO().read(entity);
		return SoftwareAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	

}
