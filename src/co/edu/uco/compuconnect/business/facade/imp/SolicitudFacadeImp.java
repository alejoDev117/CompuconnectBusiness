package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.SolicitudAssembler;
import co.edu.uco.compuconnect.business.business.SolicitudBusiness;
import co.edu.uco.compuconnect.business.business.imp.SolicitudBusinessImp;
import co.edu.uco.compuconnect.business.facade.SolicitudFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.SolicitudFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.SolicitudDTO;

public final class SolicitudFacadeImp implements SolicitudFacade{
	
	private DAOFactory daoFactory;
	private SolicitudBusiness business;
	
	public SolicitudFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new SolicitudBusinessImp(daoFactory);
	}

	@Override
	public void crear(SolicitudDTO dto) {
		try {
			
			final var domain = SolicitudAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(SolicitudFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,SolicitudFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public void enviar(SolicitudDTO dto) {
		try {
			
			final var domain = SolicitudAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.enviar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(SolicitudFacadeImpMessage.ENVIAR_EXCEPTION_TECHNICAL_MESSAGE,SolicitudFacadeImpMessage.ENVIAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<SolicitudDTO> consultar(SolicitudDTO dto) {
		try {
			final var domain = SolicitudAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return SolicitudAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(SolicitudFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, SolicitudFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
