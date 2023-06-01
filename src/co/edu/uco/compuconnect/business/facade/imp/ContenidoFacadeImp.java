package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.ContenidoAssembler;
import co.edu.uco.compuconnect.business.business.ContenidoBusiness;
import co.edu.uco.compuconnect.business.business.imp.ContenidoBusinessImp;
import co.edu.uco.compuconnect.business.facade.ContenidoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.ContenidoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.ContenidoDTO;

public final class ContenidoFacadeImp implements ContenidoFacade{
	
	private DAOFactory daoFactory;
	private ContenidoBusiness business;
	
	
	public ContenidoFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new ContenidoBusinessImp(daoFactory);
	}


	@Override
	public void crear(ContenidoDTO dto) {
		try {
			
			final var domain = ContenidoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ContenidoFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,ContenidoFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}


	@Override
	public void eliminar(ContenidoDTO dto) {
		try {
			
			final var domain = ContenidoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ContenidoFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,ContenidoFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public List<ContenidoDTO> consultar(ContenidoDTO dto) {
		try {
			final var domain = ContenidoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return ContenidoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(ContenidoFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, ContenidoFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
