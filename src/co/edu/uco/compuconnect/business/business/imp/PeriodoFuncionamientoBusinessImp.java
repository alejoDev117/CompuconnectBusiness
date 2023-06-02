package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import java.util.UUID;

import co.edu.uco.compuconnect.business.assembler.concrete.PeriodoFuncionamientoAssembler;
import co.edu.uco.compuconnect.business.business.PeriodoFuncionamientoBusiness;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.PeriodoFuncionamientoBusinessImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.PeriodoFuncionamientoEntity;


public final class PeriodoFuncionamientoBusinessImp implements PeriodoFuncionamientoBusiness{
	
	private DAOFactory  daoFactory;
	
	public PeriodoFuncionamientoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(PeriodoFuncionamientoDomain datosPeriodoFuncionamiento) {
		
		UUID identificador;
		PeriodoFuncionamientoEntity entityTmp;
		List<PeriodoFuncionamientoEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = PeriodoFuncionamientoEntity.create().setIdentificador(identificador);
			result = daoFactory.getPeriodoFuncionamientoDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		
		if(!UtilDateTime.dateIsBefore(datosPeriodoFuncionamiento.getFechaInicio(), datosPeriodoFuncionamiento.getFechaFin())) {
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoBusinessImpMessage.BUSINESS_RULE_PERIODO_FUNCIONAMIENTO_DATE_RANGE_INVALID);
		}
		
		final var domainToCreate = new PeriodoFuncionamientoDomain(identificador, datosPeriodoFuncionamiento.getNombre(), 
				datosPeriodoFuncionamiento.getFechaInicio(), 
				datosPeriodoFuncionamiento.getFechaFin(), 
				datosPeriodoFuncionamiento.getDiaFestivo(), 
				datosPeriodoFuncionamiento.getEstado());
		final PeriodoFuncionamientoEntity entity =PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getPeriodoFuncionamientoDAO().create(entity);;
		
	}

	@Override
	public void modificar(PeriodoFuncionamientoDomain datosModificacionPeriodoFuncionamiento) {
		
		PeriodoFuncionamientoEntity entityTmp;
		List<PeriodoFuncionamientoEntity> result;
		
		entityTmp = PeriodoFuncionamientoEntity.create().setIdentificador(datosModificacionPeriodoFuncionamiento.getIdentificador());
		
		result = daoFactory.getPeriodoFuncionamientoDAO().read(entityTmp);
		
		if(result.isEmpty()) {
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoBusinessImpMessage.BUSINESS_RULE_PERIODO_FUNCIONAMIENTO_ID_NOT_FOUND);
		}
		
		
		final PeriodoFuncionamientoEntity entity = PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(datosModificacionPeriodoFuncionamiento);
		daoFactory.getPeriodoFuncionamientoDAO().update(entity);
		
	}

	@Override
	public void eliminar(PeriodoFuncionamientoDomain datosEliminacionPeriodoFuncionamiento) {
		
		PeriodoFuncionamientoEntity entityTmp;
		List<PeriodoFuncionamientoEntity> result;
		
		entityTmp = PeriodoFuncionamientoEntity.create().setIdentificador(datosEliminacionPeriodoFuncionamiento.getIdentificador());
		
		result = daoFactory.getPeriodoFuncionamientoDAO().read(entityTmp);
		
		if(result.isEmpty()) {
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoBusinessImpMessage.BUSINESS_RULE_PERIODO_FUNCIONAMIENTO_ID_NOT_FOUND);
		}
		
		if(datosEliminacionPeriodoFuncionamiento.getEstado().getNombre().equals("activo")) {
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoBusinessImpMessage.BUSINESS_RULE_PERIODO_FUNCIONAMIENTO_MODIFY_INVALID);
		}
		
		
		final PeriodoFuncionamientoEntity entity = PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(datosEliminacionPeriodoFuncionamiento);
		daoFactory.getPeriodoFuncionamientoDAO().update(entity);
		
	}

	@Override
	public List<PeriodoFuncionamientoDomain> consultar(PeriodoFuncionamientoDomain datosFiltroPeriodoFuncionamiento) {
		final PeriodoFuncionamientoEntity entity = PeriodoFuncionamientoAssembler.getInstance().toEntityFromDomain(datosFiltroPeriodoFuncionamiento);
		final List<PeriodoFuncionamientoEntity> result =daoFactory.getPeriodoFuncionamientoDAO().read(entity);
		return PeriodoFuncionamientoAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	

}
