package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.FrecuenciaAssembler;
import co.edu.uco.compuconnect.business.business.FrecuenciaBusiness;
import co.edu.uco.compuconnect.business.domain.FrecuenciaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.FrecuenciaEntity;

public final class FrecuenciaBusinessImp implements FrecuenciaBusiness{
	
	private DAOFactory daoFactory;
	
	public FrecuenciaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<FrecuenciaDomain> consultar(FrecuenciaDomain datosFiltroFrecuencia) {
		final FrecuenciaEntity entity = FrecuenciaAssembler.getInstance().toEntityFromDomain(datosFiltroFrecuencia);
		final List<FrecuenciaEntity> result = daoFactory.getFrecuenciaDAO().read(entity);
		return FrecuenciaAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	

}
