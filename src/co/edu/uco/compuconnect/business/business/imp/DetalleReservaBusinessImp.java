package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;
import java.util.UUID;

import co.edu.uco.compuconnect.business.assembler.concrete.DetalleReservaAssembler;
import co.edu.uco.compuconnect.business.business.DetalleReservaBusiness;
import co.edu.uco.compuconnect.business.domain.DetalleReservaDomain;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.DetalleReservaBusinessImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.DetalleReservaEntity;

public final class DetalleReservaBusinessImp implements DetalleReservaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public DetalleReservaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(DetalleReservaDomain datosDetalleReserva) {
		
		UUID identificador;
		DetalleReservaEntity entityTmp;
		List<DetalleReservaEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = DetalleReservaEntity.create().setIdentificador(identificador);
			result = daoFactory.getDetalleReservaDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		
		if(!UtilDateTime.localTimeIsBefore(datosDetalleReserva.getHorainicio(), datosDetalleReserva.getHorafin())) {
			throw CompuconnectBusinessException.create(DetalleReservaBusinessImpMessage.BUSINESS_RULE_DETALLE_RESERVA_TIME_OUT_OF_RANGE);
		}
		
		final var domainToCreate = new DetalleReservaDomain(identificador, 
				datosDetalleReserva.getDia(), 
				datosDetalleReserva.getHorainicio(), 
				datosDetalleReserva.getHorafin());
		
		final DetalleReservaEntity entity = DetalleReservaAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getDetalleReservaDAO().create(entity);
		
	}


	@Override
	public void modificar(DetalleReservaDomain datosModificacionDetalleReserva) {
		
		DetalleReservaEntity entityTmp;
		List<DetalleReservaEntity> result;
		
		entityTmp = DetalleReservaEntity.create().setIdentificador(datosModificacionDetalleReserva.getIdentificador());
		result = daoFactory.getDetalleReservaDAO().read(entityTmp);
		
		if(result.isEmpty()) {
			throw CompuconnectBusinessException.create(DetalleReservaBusinessImpMessage.BUSINESS_RULE_CENTRO_INFORMATICA_ID_NOT_FOUND);
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
			throw CompuconnectBusinessException.create(DetalleReservaBusinessImpMessage.BUSINESS_RULE_CENTRO_INFORMATICA_ID_NOT_FOUND);
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
	
	

}
