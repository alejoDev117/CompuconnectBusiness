package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;
import java.util.UUID;

import co.edu.uco.compuconnect.business.assembler.concrete.AgendaAssembler;
import co.edu.uco.compuconnect.business.business.AgendaBusiness;
import co.edu.uco.compuconnect.business.domain.AgendaDomain;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.AgendaBusinessImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.AgendaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.AgendaEntity;
import co.edu.uco.compuconnect.entities.AgendaReservaEntity;

public final class AgendaBusinessImp implements AgendaBusiness{
	
	private DAOFactory daoFactory;
	
	public AgendaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void crear(AgendaDomain datosAgenda) {
		
		UUID identificador;
		AgendaEntity entityTmpIdentificador;
		AgendaEntity entityTmpPeriodoFuncionamiento;
		AgendaEntity entityTmpCentroInformatica;
		List<AgendaEntity> resultIdentificador;
		List<AgendaEntity> resultPeriodoFuncionamiento;
		List<AgendaEntity> resultCentroInformatica;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmpIdentificador = AgendaEntity.create().setIdentificador(identificador);
			resultIdentificador = daoFactory.getAgendaDAO().read(entityTmpIdentificador);
		}while(!resultIdentificador.isEmpty());
		
		entityTmpPeriodoFuncionamiento = AgendaEntity.create().setPeriodoFuncionamiento(AgendaAssembler.getInstance().toEntityFromDomain(datosAgenda).getPeriodoFuncionamiento());
		resultPeriodoFuncionamiento = daoFactory.getAgendaDAO().read(entityTmpPeriodoFuncionamiento);
		
		entityTmpCentroInformatica = AgendaEntity.create().setCentroInformatica(AgendaAssembler.getInstance().toEntityFromDomain(datosAgenda).getCentroInformatica());
		resultCentroInformatica = daoFactory.getAgendaDAO().read(entityTmpCentroInformatica);
		
		if(!resultPeriodoFuncionamiento.isEmpty() && !resultCentroInformatica.isEmpty()) {
			throw CompuconnectBusinessException.create(AgendaBusinessImpMessage.BUSINESS_RULE_AGENDA_ALREADY_EXIST);
		}
		
		final var domainValidToCreate = new AgendaDomain(identificador, datosAgenda.getPeriodoFuncionamiento(), datosAgenda.getCentroInformatica(), datosAgenda.getNombre());
		
		final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(domainValidToCreate);
		daoFactory.getAgendaDAO().create(entity);
		
	}

	@Override
	public List<AgendaDomain> consultar(AgendaDomain datosFiltroAgenda) {
		final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(datosFiltroAgenda);
		final List<AgendaEntity> result = daoFactory.getAgendaDAO().read(entity);
		return AgendaAssembler.getInstance().toDomainListFromEntityList(result);
	}

	@Override
	public void actualizar(AgendaDomain datosActualizacionAgenda) {
		AgendaEntity entityTmpIdentificador;
		List<AgendaEntity> resultIdentificador;
		entityTmpIdentificador = AgendaEntity.create().setIdentificador(datosActualizacionAgenda.getIdentificador());
		
		resultIdentificador = daoFactory.getAgendaDAO().read(entityTmpIdentificador);
		
		if(resultIdentificador.isEmpty()) {
			throw CompuconnectBusinessException.create(AgendaBusinessImpMessage.BUSINESS_RULE_AGENDA_ID_NOT_FOUND);
		}
		
		
		final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(datosActualizacionAgenda);
		daoFactory.getAgendaDAO().uptade(entity);
		
	}

	@Override
	public void eliminar(AgendaDomain datosEliminacionAgenda) {
		AgendaEntity entityTmpIdentificador;
		AgendaReservaEntity entityTmpReserva;
		List<AgendaEntity> resultIdentificador;
		List<AgendaReservaEntity> resultReserva;
		entityTmpIdentificador = AgendaEntity.create().setIdentificador(datosEliminacionAgenda.getIdentificador());
		
		resultIdentificador = daoFactory.getAgendaDAO().read(entityTmpIdentificador);
		
		if(resultIdentificador.isEmpty()) {
			throw CompuconnectBusinessException.create(AgendaBusinessImpMessage.BUSINESS_RULE_AGENDA_ID_NOT_FOUND);
		}
		
		entityTmpReserva = AgendaReservaEntity.create().setAgenda(AgendaAssembler.getInstance().toEntityFromDomain(datosEliminacionAgenda));
		resultReserva = daoFactory.getAgendaReservaDAO().read(entityTmpReserva);
		
		if(!resultReserva.isEmpty()) {
			throw CompuconnectBusinessException.create(AgendaBusinessImpMessage.BUSINESS_RULE_AGENDA_ELIMINAR_EXCEPTION);
		}	
		
		final AgendaEntity entity = AgendaAssembler.getInstance().toEntityFromDomain(datosEliminacionAgenda);
		daoFactory.getAgendaDAO().delete(entity);
	}
	
	

}
