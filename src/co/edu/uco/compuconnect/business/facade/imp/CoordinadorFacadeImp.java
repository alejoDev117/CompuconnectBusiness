package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.CoordinadorAssembler;
import co.edu.uco.compuconnect.business.business.CoordinadorBusiness;
import co.edu.uco.compuconnect.business.business.imp.CoordinadorBusinessImp;
import co.edu.uco.compuconnect.business.facade.CoordinadorFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CoordinadorFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.CoordinadorDTO;

public final class CoordinadorFacadeImp implements CoordinadorFacade {
	
	private DAOFactory daoFactory;
	private CoordinadorBusiness business;
	
	public CoordinadorFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new CoordinadorBusinessImp(daoFactory);
	}

	@Override
	public void registrar(CoordinadorDTO dto) {
		try {
			
			final var domain = CoordinadorAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.registrar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(CoordinadorFacadeImpMessage.REGISTRAR_EXCEPTION_TECHNICAL_MESSAGE,CoordinadorFacadeImpMessage.REGISTRAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public void modificar(CoordinadorDTO dto) {
		try {
			
			final var domain = CoordinadorAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(CoordinadorFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,CoordinadorFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<CoordinadorDTO> consultar(CoordinadorDTO dto) {
		try {
			final var domain = CoordinadorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return CoordinadorAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(CoordinadorFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, CoordinadorFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(CoordinadorDTO dto) {
		try {
			
			final var domain = CoordinadorAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(CoordinadorFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,CoordinadorFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
