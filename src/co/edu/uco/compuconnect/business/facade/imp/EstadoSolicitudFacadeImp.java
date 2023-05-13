package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.EstadoNotificacionAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.EstadoSolicitudAssembler;
import co.edu.uco.compuconnect.business.business.EstadoSolicitudBusiness;
import co.edu.uco.compuconnect.business.business.imp.EstadoSolicitudBusinessImp;
import co.edu.uco.compuconnect.business.domain.EstadoSolicitudDomain;
import co.edu.uco.compuconnect.business.facade.EstadoSolicitudFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.EstadoNotificacionFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.EstadoSolicitudFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.EstadoSolicitudDTO;

public final class EstadoSolicitudFacadeImp implements EstadoSolicitudFacade{
	
	private DAOFactory daoFactory;
	private EstadoSolicitudBusiness business;
	
	
	public EstadoSolicitudFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new EstadoSolicitudBusinessImp(daoFactory);
		
	}


	@Override
	public List<EstadoSolicitudDTO> consultar(EstadoSolicitudDTO dto) {
		try {
			final var domain = EstadoSolicitudAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return EstadoSolicitudAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(EstadoSolicitudFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, EstadoSolicitudFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}



}
