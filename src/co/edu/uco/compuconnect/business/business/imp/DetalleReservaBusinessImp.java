package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;
import java.util.UUID;

import co.edu.uco.compuconnect.business.assembler.concrete.DetalleReservaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.ReservaAssembler;
import co.edu.uco.compuconnect.business.business.DetalleReservaBusiness;
import co.edu.uco.compuconnect.business.domain.DetalleReservaDomain;
import co.edu.uco.compuconnect.business.domain.ReservaDomain;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.DetalleReservaBusinessImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.ReservaBusinessImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.DetalleReservaEntity;
import co.edu.uco.compuconnect.entities.ReservaEntity;

public final class DetalleReservaBusinessImp implements DetalleReservaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public DetalleReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(List<DetalleReservaDomain> datosDetalleReserva) {
		
		List<DetalleReservaEntity> resultadoConsultaFinal;
		List<ReservaEntity> resultadoReservaDentroDeRango;
		
		if(datosDetalleReserva.isEmpty()) {
			throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA_LIST_IS_EMPTY);
			
		}
		
		ReservaDomain reservaNuevaEntrante = datosDetalleReserva.get(0).getReserva();
		
		try {
			validarRangoHora(datosDetalleReserva);
			ReservaBusinessImp.create().validacionReserva(reservaNuevaEntrante);
		}catch(CompuconnectException exception) {
			throw exception;
		}
		
		resultadoReservaDentroDeRango = daoFactory.getReservaDAO().read(ReservaAssembler.getInstance().toEntityFromDomain(reservaNuevaEntrante));

		if(!resultadoReservaDentroDeRango.isEmpty()) {
			
			final var detallesReserva = DetalleReservaAssembler.getInstance().toEntityListFromDomainList(datosDetalleReserva);
			
			for (ReservaEntity reservaExistente : resultadoReservaDentroDeRango) {
				for (DetalleReservaEntity detalleNuevo : detallesReserva) {
					
					resultadoConsultaFinal = daoFactory.getDetalleReservaDAO().read(detalleNuevo.setReserva(reservaExistente));
				
					if(!resultadoConsultaFinal.isEmpty()) {
						throw CompuconnectBusinessException.create(ReservaBusinessImpMessage.BUSINESS_RULE_RESERVA__ALREADY_EXIST);
					}
				}
			}
		}
		
		
		final var registroReservaValida = new ReservaBusinessImp(daoFactory);
		registroReservaValida.generar(reservaNuevaEntrante);
		registrarDetalleReservaValidos(datosDetalleReserva,registroReservaValida.getIdentificadorValidoReservaNuevaGenerada());
	}


	@Override
	public void modificar(DetalleReservaDomain datosModificacionDetalleReserva) {
		
		DetalleReservaEntity entityTmp;
		List<DetalleReservaEntity> result;
		
		entityTmp = DetalleReservaEntity.create().setIdentificador(datosModificacionDetalleReserva.getIdentificador());
		result = daoFactory.getDetalleReservaDAO().read(entityTmp);
		
		if(result.isEmpty()) {
			throw CompuconnectBusinessException.create(DetalleReservaBusinessImpMessage.BUSINESS_RULE_DETALLE_RESERVA_ID_NOT_FOUND);
		}
		
		if(!UtilDateTime.localTimeIsBefore(datosModificacionDetalleReserva.getHorainicio(), datosModificacionDetalleReserva.getHorafin())) {
			throw CompuconnectBusinessException.create(DetalleReservaBusinessImpMessage.BUSINESS_RULE_DETALLE_RESERVA_TIME_OUT_OF_RANGE);
		}
		
		
		final DetalleReservaEntity entity = DetalleReservaAssembler.getInstance().toEntityFromDomain(datosModificacionDetalleReserva);
		daoFactory.getDetalleReservaDAO().update(entity);
		
	}


	@Override
	public void eliminar(DetalleReservaDomain datosEliminacionDetalleReserva) {
		
		DetalleReservaEntity entityTmp;
		List<DetalleReservaEntity> result;
		
		entityTmp = DetalleReservaEntity.create().setIdentificador(datosEliminacionDetalleReserva.getIdentificador());
		result = daoFactory.getDetalleReservaDAO().read(entityTmp);
		
		if(result.isEmpty()) {
			throw CompuconnectBusinessException.create(DetalleReservaBusinessImpMessage.BUSINESS_RULE_DETALLE_RESERVA_ID_NOT_FOUND);
		}
		
		
		final DetalleReservaEntity entity = DetalleReservaAssembler.getInstance().toEntityFromDomain(datosEliminacionDetalleReserva);
		daoFactory.getDetalleReservaDAO().delete(entity);
		
	}


	@Override
	public List<DetalleReservaDomain> consultar(DetalleReservaDomain datosFiltroDetalleReserva) {
		final DetalleReservaEntity entity = DetalleReservaAssembler.getInstance().toEntityFromDomain(datosFiltroDetalleReserva);
		final List<DetalleReservaEntity> result = daoFactory.getDetalleReservaDAO().read(entity);
		return DetalleReservaAssembler.getInstance().toDomainListFromEntityList(result);
	}

	
	
	
	
	private final void validarRangoHora(List<DetalleReservaDomain> detalles) {
		for (DetalleReservaDomain detalleReservaDomain : detalles) {
			if(!UtilDateTime.localTimeIsBefore(detalleReservaDomain.getHorainicio(), detalleReservaDomain.getHorafin())) {
				throw CompuconnectBusinessException.create(DetalleReservaBusinessImpMessage.BUSINESS_RULE_DETALLE_RESERVA_TIME_OUT_OF_RANGE);
			}
		}
	}
	
	
	
	
	private final void registrarDetalleReservaValidos(List<DetalleReservaDomain> detalles,UUID identificadorReservaValida) {
		
		UUID identificador;
		DetalleReservaEntity entityTmp;
		List<DetalleReservaEntity> result;
		List<DetalleReservaEntity> detalleToEntity = DetalleReservaAssembler.getInstance().toEntityListFromDomainList(detalles);
		
		
		for (DetalleReservaEntity detalleReservaEntity : detalleToEntity) {
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = DetalleReservaEntity.create().setIdentificador(identificador);
			result = daoFactory.getDetalleReservaDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		
		final var entityValidToCreate = DetalleReservaEntity.create().setIdentificador(identificador).
				setReserva(detalleReservaEntity.getReserva().setIdentificador(identificadorReservaValida)).setDia(detalleReservaEntity.getDia()).
				setHorainicio(detalleReservaEntity.getHorainicio()).setHorafin(detalleReservaEntity.getHorafin());
	
		daoFactory.getDetalleReservaDAO().create(entityValidToCreate);
		
		}
	}

}
