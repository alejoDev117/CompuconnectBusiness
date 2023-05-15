package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.UsuarioAssembler;
import co.edu.uco.compuconnect.business.business.UsuarioBusiness;
import co.edu.uco.compuconnect.business.business.imp.UsuarioBusinessImp;
import co.edu.uco.compuconnect.business.facade.UsuarioFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.UsuarioFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.UsuarioDTO;

public final class UsuarioFacadeImp implements UsuarioFacade{
	
	private DAOFactory daoFactory;
	private UsuarioBusiness business;
	
	public UsuarioFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new UsuarioBusinessImp(daoFactory);
	}

	@Override
	public void crear(UsuarioDTO dto) {
		try {
			
			final var domain = UsuarioAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(UsuarioFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,UsuarioFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		
	}

	@Override
	public List<UsuarioDTO> consultar(UsuarioDTO dto) {
		try {
			final var domain = UsuarioAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return UsuarioAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(UsuarioFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, UsuarioFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(UsuarioDTO dto) {
		try {
			
			final var domain = UsuarioAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(UsuarioFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,UsuarioFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		
	}

	@Override
	public void modificar(UsuarioDTO dto) {
		try {
			
			final var domain = UsuarioAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(UsuarioFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,UsuarioFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		
	}
	
	

}
