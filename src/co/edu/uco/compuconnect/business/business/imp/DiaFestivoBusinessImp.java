package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.DiaFestivoAssembler;
import co.edu.uco.compuconnect.business.business.DiaFestivoBusiness;
import co.edu.uco.compuconnect.business.domain.DiaFestivoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.DiaFestivoEntity;

public final class DiaFestivoBusinessImp implements DiaFestivoBusiness{
	
	public DAOFactory daoFactory;
	
	public DiaFestivoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<DiaFestivoDomain> consultar(DiaFestivoDomain datosFiltroDiaFestivo) {
		final DiaFestivoEntity entity = DiaFestivoAssembler.getInstance().toEntityFromDomain(datosFiltroDiaFestivo);
		final List<DiaFestivoEntity> result = daoFactory.getDiaFestivoDAO().read(entity);
		return DiaFestivoAssembler.getInstance().toDomainListFromEntityList(result);
	}

}
