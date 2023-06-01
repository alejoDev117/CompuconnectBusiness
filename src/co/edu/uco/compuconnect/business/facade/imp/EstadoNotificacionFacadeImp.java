package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.EstadoNotificacionAssembler;
import co.edu.uco.compuconnect.business.business.EstadoNotificacionBusiness;
import co.edu.uco.compuconnect.business.business.imp.EstadoNotificacionBusinessImp;
import co.edu.uco.compuconnect.business.facade.EstadoNotificacionFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.EstadoNotificacionFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.EstadoNotificacionDTO;

public final class EstadoNotificacionFacadeImp implements EstadoNotificacionFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoNotificacionBusiness business;
	
	
	public EstadoNotificacionFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new EstadoNotificacionBusinessImp(daoFactory);
	}


	@Override
	public List<EstadoNotificacionDTO> consultar(EstadoNotificacionDTO dto) {
		try {	
			final var domain = EstadoNotificacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return EstadoNotificacionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(EstadoNotificacionFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, EstadoNotificacionFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		}
	
	
	}
	

