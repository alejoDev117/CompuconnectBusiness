package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.DestinatarioNotificacionAssembler;
import co.edu.uco.compuconnect.business.business.DestinatarioNotificacionBusiness;
import co.edu.uco.compuconnect.business.business.imp.DestinatarioNotificacionBusinessImp;
import co.edu.uco.compuconnect.business.facade.DestinatarioNotificacionFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.DestinatarioNotificacionFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.DestinatarioNotificacionDTO;

public final class DestinatarioNotificacionFacadeImp implements DestinatarioNotificacionFacade{
	
	private DAOFactory daoFactory;
	private DestinatarioNotificacionBusiness business;
	
	public DestinatarioNotificacionFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new DestinatarioNotificacionBusinessImp(daoFactory);
	}

	@Override
	public void crear(DestinatarioNotificacionDTO dto) {
		try {
			
			final var domain = DestinatarioNotificacionAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(DestinatarioNotificacionFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,DestinatarioNotificacionFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<DestinatarioNotificacionDTO> consultar(DestinatarioNotificacionDTO dto) {
		try {
			final var domain = DestinatarioNotificacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return DestinatarioNotificacionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(DestinatarioNotificacionFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, DestinatarioNotificacionFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(DestinatarioNotificacionDTO dto) {
		try {
			
			final var domain = DestinatarioNotificacionAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(DestinatarioNotificacionFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,DestinatarioNotificacionFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
