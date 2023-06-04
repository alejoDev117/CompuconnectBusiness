package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;
import java.util.UUID;

import co.edu.uco.compuconnect.business.assembler.concrete.ReservaAssembler;
import co.edu.uco.compuconnect.business.business.ReservaBusiness;
import co.edu.uco.compuconnect.business.domain.ReservaDomain;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.ReservaBusinessImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.DetalleReservaEntity;
import co.edu.uco.compuconnect.entities.ReservaEntity;

public final class ReservaBusinessImp implements ReservaBusiness{
	
	private DAOFactory daoFactory;
	
	public ReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void generar(ReservaDomain datosReserva) {
		
		UUID identificador;
		ReservaEntity entityTmpIdentificador;
		ReservaEntity entityTmpRangoFechas;
		List<ReservaEntity> resultIdentificador;
		List<ReservaEntity> resultRangoFechas;
		List<DetalleReservaEntity> resultDetalleReservaEntrante;
		List<DetalleReservaEntity> resultDetalleReservaBase;
		
		/*do {
			identificador = UtilUUID.generateNewUUID();
			entityTmpIdentificador = ReservaEntity.create().setIdentificador(identificador);
			resultIdentificador = daoFactory.getReservaDAO().read(entityTmpIdentificador);
		}while(!resultIdentificador.isEmpty());
		
		
	/*	if(UtilDateTime.dateIsAfter(datosReserva.getFechaInicio(), datosReserva.getFechaFin())) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_DATE_RANGE_INVALID);
		}

		
	   if(UtilDateTime.dateIsBefore(datosReserva.getFechaInicio(), datosReserva.getAgenda().getPeriodoFuncionamiento().getFechaInicio()) || 
				UtilDateTime.dateIsAfter(datosReserva.getFechaFin(), datosReserva.getAgenda().getPeriodoFuncionamiento().getFechaFin())) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_DATE_AGENDA_DATE_RANGE);
		}
	
		if(UtilUUID.isDefault(datosReserva.getTipoReserva().getIdentificador()) && !UtilText.getUtilText().isEmpty(datosReserva.getTipoReserva().getNombre())) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_TIPO_RESERVA_INVALID);			
		}
		if(UtilUUID.isDefault(datosReserva.getFrecuencia().getIdentificador()) && !UtilText.getUtilText().isEmpty(datosReserva.getFrecuencia().getNombre())) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_FRECUENCIA_INVALID);			
		}
		
		*/
		entityTmpRangoFechas = ReservaEntity.create().setAgenda(ReservaAssembler.getInstance().toEntityFromDomain(datosReserva).getAgenda()).
				setFechaInicio(ReservaAssembler.getInstance().toEntityFromDomain(datosReserva).getFechaInicio()).
				setFechaFin(ReservaAssembler.getInstance().toEntityFromDomain(datosReserva).getFechaFin());
		resultRangoFechas = daoFactory.getReservaDAO().read(entityTmpRangoFechas);
		
		if(!resultRangoFechas.isEmpty()) {
			resultDetalleReservaEntrante = daoFactory.getDetalleReservaDAO().read(DetalleReservaEntity.create().setReserva(entityTmpRangoFechas));
			for (ReservaEntity entityTmp : resultRangoFechas) {
				resultDetalleReservaBase = daoFactory.getDetalleReservaDAO().read(DetalleReservaEntity.create().setReserva(entityTmp));
				//refactorizar muchisisismo mañana por favor men :)
			}
		}
		
		final ReservaEntity entity = ReservaAssembler.getInstance().toEntityFromDomain(datosReserva);
		daoFactory.getReservaDAO().create(entity);
		
	}

	@Override
	public void modificar(ReservaDomain datosModReserva) {
		
		ReservaEntity entityTmp;
		List<ReservaEntity> result;
		
		entityTmp = ReservaEntity.create().setIdentificador(datosModReserva.getIdentificador());
		result  = daoFactory.getReservaDAO().read(entityTmp);
		
		if(result.isEmpty()) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_CENTRO_INFORMATICA_ID_NOT_FOUND);
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
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_CENTRO_INFORMATICA_ID_NOT_FOUND);
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
	
	
	

}
