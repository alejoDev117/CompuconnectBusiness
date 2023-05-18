package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.DestinatarioAssembler;
import co.edu.uco.compuconnect.business.business.DestinatarioBusiness;
import co.edu.uco.compuconnect.business.business.imp.DestinatarioBusinessImp;
import co.edu.uco.compuconnect.business.facade.DestinatarioFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.DestinatarioFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.DestinatarioDTO;

public final class DestinatarioFacadeImp implements DestinatarioFacade{
	
	private DAOFactory daoFactory;
	private DestinatarioBusiness business;
	
	
	public DestinatarioFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new DestinatarioBusinessImp(daoFactory);
	}


	@Override
	public void registrar(DestinatarioDTO dto) {
		try {
			
			final var domain = DestinatarioAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.registrar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(DestinatarioFacadeImpMessage.REGISTRAR_EXCEPTION_TECHNICAL_MESSAGE,DestinatarioFacadeImpMessage.REGISTRAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public void modificar(DestinatarioDTO dto) {
		try {
			
			final var domain = DestinatarioAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(DestinatarioFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,DestinatarioFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public List<DestinatarioDTO> consultar(DestinatarioDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void eliminar(DestinatarioDTO dto) {
		try {
			
			final var domain = DestinatarioAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(DestinatarioFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,DestinatarioFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
