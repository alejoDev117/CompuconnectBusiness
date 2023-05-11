package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.PeriodoFuncionamientoAssembler;
import co.edu.uco.compuconnect.business.business.PeriodoFuncionamientoBusiness;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.PeriodoFuncionamientoEntity;

public class PeriodoFuncionamientoDiaFestivoBusinessImp implements PeriodoFuncionamientoBusiness{
	
	private DAOFactory daoFactory;
	
	public PeriodoFuncionamientoDiaFestivoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(PeriodoFuncionamientoDomain datosPeriodoFuncionamiento) {
		final PeriodoFuncionamientoEntity entity = PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(datosPeriodoFuncionamiento);
		daoFactory.getPeriodoFuncionamientoDAO().create(entity);
		
	}

	@Override
	public void modificar(PeriodoFuncionamientoDomain datosModificacionPeriodoFuncionamiento) {
		final PeriodoFuncionamientoEntity entity = PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(datosModificacionPeriodoFuncionamiento);
		daoFactory.getPeriodoFuncionamientoDAO().update(entity);
		
	}

	@Override
	public void eliminar(PeriodoFuncionamientoDomain datosEliminacionPeriodoFuncionamiento) {
		final PeriodoFuncionamientoEntity entity = PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(datosEliminacionPeriodoFuncionamiento);
		daoFactory.getPeriodoFuncionamientoDAO().delete(entity);
		
	}

	@Override
	public List<PeriodoFuncionamientoDomain> consultar(PeriodoFuncionamientoDomain datosFiltroPeriodoFuncionamiento) {
		final PeriodoFuncionamientoEntity entity = PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(datosFiltroPeriodoFuncionamiento);
		final List<PeriodoFuncionamientoEntity> resultEntityList = daoFactory.getPeriodoFuncionamientoDAO().read(entity);
		
		return PeriodoFuncionamientoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}
	
	

}
