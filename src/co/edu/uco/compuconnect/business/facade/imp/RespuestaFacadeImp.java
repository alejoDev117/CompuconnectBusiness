package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.RespuestaAssembler;
import co.edu.uco.compuconnect.business.business.RespuestaBusiness;
import co.edu.uco.compuconnect.business.business.imp.RespuestaBusinessImp;
import co.edu.uco.compuconnect.business.facade.RespuestaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.RespuestaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.RespuestaDTO;

public final class RespuestaFacadeImp implements RespuestaFacade{
	
	private DAOFactory daoFactory;
	private RespuestaBusiness business;
	
	public  RespuestaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new RespuestaBusinessImp(daoFactory);
	}

	@Override
	public void realizar(RespuestaDTO dto) {
		try {
			
			final var domain = RespuestaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.realizar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(RespuestaFacadeImpMessage.REALIZAR_EXCEPTION_TECHNICAL_MESSAGE,RespuestaFacadeImpMessage.REALIZAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(RespuestaDTO dto) {
		try {
			
			final var domain = RespuestaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(RespuestaFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,RespuestaFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<RespuestaDTO> consultar(RespuestaDTO dto) {
		try {
			final var domain = RespuestaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return RespuestaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(RespuestaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, RespuestaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
