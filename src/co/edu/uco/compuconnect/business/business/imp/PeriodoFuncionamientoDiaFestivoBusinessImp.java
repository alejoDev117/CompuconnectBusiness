package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.PeriodoFuncionamientoAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.PeriodoFuncionamientoDiaFestivoAssembler;
import co.edu.uco.compuconnect.business.business.PeriodoFuncionamientoBusiness;
import co.edu.uco.compuconnect.business.business.PeriodoFuncionamientoDiaFestivoBusiness;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDiaFestivoDomain;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.data.dao.PeriodoFuncionamientoDiaFestivoDAO;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.PeriodoFuncionamientoDiaFestivoEntity;
import co.edu.uco.compuconnect.entities.PeriodoFuncionamientoEntity;

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
		final List<PeriodoFuncionamientoDiaFestivoEntity> result = daoFactory.getPeriodoFuncionamientoDiaFestivoDAO().read(entity);
		return null;
	}

	@Override
	public void eliminar(PeriodoFuncionamientoDiaFestivoDomain datosEliminacionPeriodoFuncionamientoDiaFestivo) {
		final PeriodoFuncionamientoDiaFestivoEntity entity = PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toEntityFromDomain(datosEliminacionPeriodoFuncionamientoDiaFestivo);
		daoFactory.getPeriodoFuncionamientoDiaFestivoDAO().delete(entity);
		
	}


	
	

}
