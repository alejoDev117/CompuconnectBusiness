package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.PeriodoFuncionamientoDiaFestivoAssembler;
import co.edu.uco.compuconnect.business.business.PeriodoFuncionamientoDiaFestivoBusiness;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDiaFestivoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.PeriodoFuncionamientoDiaFestivoEntity;

public class PeriodoFuncionamientoDiaFestivoBusinessImp implements PeriodoFuncionamientoDiaFestivoBusiness{
	
	private DAOFactory daoFactory;
	
	public PeriodoFuncionamientoDiaFestivoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(PeriodoFuncionamientoDiaFestivoDomain datosPeriodoFuncionamientoDiaFestivo) {
		final PeriodoFuncionamientoDiaFestivoEntity entity = PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toEntityFromDomain(datosPeriodoFuncionamientoDiaFestivo);
		daoFactory.getPeriodoFuncionamientoDiaFestivoDAO().create(entity);
	}

	@Override
	public List<PeriodoFuncionamientoDiaFestivoDomain> consultar(
			PeriodoFuncionamientoDiaFestivoDomain datosFiltroPeriodoFuncionamientoDiaFestivo) {
		final PeriodoFuncionamientoDiaFestivoEntity entity = PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toEntityFromDomain(datosFiltroPeriodoFuncionamientoDiaFestivo);
		final List<PeriodoFuncionamientoDiaFestivoEntity> resultEntityList = daoFactory.getPeriodoFuncionamientoDiaFestivoDAO().read(entity);
		
		return PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void eliminar(PeriodoFuncionamientoDiaFestivoDomain datosEliminacionPeriodoFuncionamientoDiaFestivo) {
		final PeriodoFuncionamientoDiaFestivoEntity entity = PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toEntityFromDomain(datosEliminacionPeriodoFuncionamientoDiaFestivo);
		daoFactory.getPeriodoFuncionamientoDiaFestivoDAO().delete(entity);
	}
	
	

}
