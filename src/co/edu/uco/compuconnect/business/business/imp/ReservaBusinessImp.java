package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import java.util.UUID;

import co.edu.uco.compuconnect.business.assembler.concrete.ReservaAssembler;
import co.edu.uco.compuconnect.business.business.ReservaBusiness;
import co.edu.uco.compuconnect.business.domain.AgendaDomain;
import co.edu.uco.compuconnect.business.domain.FrecuenciaDomain;
import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.business.domain.ReservaDomain;
import co.edu.uco.compuconnect.business.domain.TipoReservaDomain;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.ReservaBusinessImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.ReservaEntity;

public final class ReservaBusinessImp implements ReservaBusiness{
	
	private DAOFactory daoFactory;
	private UUID identificadorValidoReservaNuevaGenerada;
	
	public ReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	private ReservaBusinessImp() {
	}
	
	protected static final  ReservaBusinessImp create() {
		return new ReservaBusinessImp();
	}

	@Override
	public void generar(ReservaDomain datosReserva) {
		
		UUID identificador;
		ReservaEntity entityTmpIdentificador;
		List<ReservaEntity> resultadoReservasIdentificadorEnUso;
		
		
		try {
			validacionReserva(datosReserva);
		}catch(CompuconnectException exception) {
			throw exception;
		}
		
		
		do {
				identificador = UtilUUID.generateNewUUID();
				entityTmpIdentificador = ReservaEntity.create().setIdentificador(identificador);
				resultadoReservasIdentificadorEnUso = daoFactory.getReservaDAO().read(entityTmpIdentificador);
		}while(!resultadoReservasIdentificadorEnUso.isEmpty());
		
			identificadorValidoReservaNuevaGenerada = identificador;
			
			final var domainToCreate = new ReservaDomain(identificador,
					datosReserva.getAgenda(), datosReserva.getAutor(), 
					datosReserva.getTipoReserva(), datosReserva.getFechaInicio(),datosReserva.getFechaFin(), 
					datosReserva.getFrecuencia(), 
					datosReserva.getDescripcion(), 
					datosReserva.getHoraCreacion());
			
			
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getReservaDAO().create(entity); 
		
	 }
	

	@Override
	public void modificar(ReservaDomain datosModReserva) {
		
		ReservaEntity entityTmp;
		List<ReservaEntity> result;
		
		entityTmp = ReservaEntity.create().setIdentificador(datosModReserva.getIdentificador());
		result  = daoFactory.getReservaDAO().read(entityTmp);
		
		if(result.isEmpty()) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_ID_NOT_FOUND);
		}
		
		if(UtilDateTime.dateIsAfter(datosModReserva.getFechaInicio(), datosModReserva.getFechaFin())) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_DATE_RANGE_INVALID);
		}
		
		
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(datosModReserva);
		daoFactory.getReservaDAO().update(entity);
		
	}

	@Override
	public void cancelar(ReservaDomain datosEliminacionReserva) {
		
		ReservaEntity entityTmp;
		List<ReservaEntity> result;
		
		entityTmp = ReservaEntity.create().setIdentificador(datosEliminacionReserva.getIdentificador());
		result  = daoFactory.getReservaDAO().read(entityTmp);
		
		if(result.isEmpty()) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_ID_NOT_FOUND);
		}
		
		
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(datosEliminacionReserva);
		daoFactory.getReservaDAO().delete(entity);
		
	}

	@Override
	public List<ReservaDomain> consultar(ReservaDomain datosFiltroReserva) {
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(datosFiltroReserva);
		final List<ReservaEntity> result = daoFactory.getReservaDAO().read(entity);
		return ReservaAssembler.getInstance().toDomainListFromEntityList(result);
	}

	
	
	
	protected void validacionReserva(ReservaDomain reserva) {
		try {
			validarRangoFecha(reserva);
			validarRangoFechaAgenda(reserva);
			validarTipoReserva(reserva.getTipoReserva());
			validarFrecuencia(reserva.getFrecuencia());
		}catch(CompuconnectException exception) {
			throw exception;
		}catch(Exception exception) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_AGENDA_VALIDATION_TECHNICAL_MESSAGE,ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_AGENDA_VALIDATION_USER_MESSAGE,exception);
		}
	}
	

	private final void validarTipoReserva(TipoReservaDomain tipo) {
		if(UtilUUID.isDefault(tipo.getIdentificador())){
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_TIPO_RESERVA_INVALID);
		}
	}
	
	
	private final void validarFrecuencia(FrecuenciaDomain frecuencia) {
		if(UtilUUID.isDefault(frecuencia.getIdentificador())) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_FRECUENCIA_INVALID);
		}
	}
	
	 
	
	private final void validarRangoFecha(ReservaDomain reserva) {
		if(UtilDateTime.dateIsAfter(reserva.getFechaInicio(), reserva.getFechaFin())) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_DATE_RANGE_INVALID);
		}
	}
	
	
	
	
	
	private final void validarRangoFechaAgenda(ReservaDomain reserva) {
		
		if(agendaIdentificadorEsPorDefecto(reserva.getAgenda()) || 
				fechasPeriodoFuncionamientoEsPorDefecto(reserva.getAgenda().getPeriodoFuncionamiento())) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_AGENDA_ID_DEFAULT);
		}
		
		if(UtilDateTime.dateIsBefore(reserva.getFechaInicio(), reserva.getAgenda().getPeriodoFuncionamiento().getFechaInicio()) || 
					UtilDateTime.dateIsAfter(reserva.getFechaFin(), reserva.getAgenda().getPeriodoFuncionamiento().getFechaFin())) {
				throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_DATE_AGENDA_DATE_RANGE);
			}
	}
	
	
	
	private final boolean fechasPeriodoFuncionamientoEsPorDefecto(PeriodoFuncionamientoDomain periodoFuncionamiento) {
		return periodoFuncionamiento.getFechaInicio().equals(UtilDateTime.getDefaultValueDate()) ||
				periodoFuncionamiento.getFechaFin().equals(UtilDateTime.getDefaultValueDate());
	}
	
	private final boolean agendaIdentificadorEsPorDefecto(AgendaDomain agenda) {
		return UtilUUID.isDefault(agenda.getIdentificador());
	}

	protected final UUID getIdentificadorValidoReservaNuevaGenerada() {
		return identificadorValidoReservaNuevaGenerada;
	}
	
	
}
