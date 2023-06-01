package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.MonitorAssembler;
import co.edu.uco.compuconnect.business.business.MonitorBusiness;
import co.edu.uco.compuconnect.business.business.imp.MonitorBusinessImp;
import co.edu.uco.compuconnect.business.facade.MonitorFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.MonitorFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.MonitorDTO;

public final class MonitorFacadeImp implements MonitorFacade{
	
	private DAOFactory daoFactory;
	private MonitorBusiness business;
	
	public MonitorFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new MonitorBusinessImp(daoFactory);
	}

	@Override
	public void registrar(MonitorDTO dto) {
		try {
			
			final var domain = MonitorAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.registrar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(MonitorFacadeImpMessage.REGISTRAR_EXCEPTION_TECHNICAL_MESSAGE,MonitorFacadeImpMessage.REGISTRAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificar(MonitorDTO dto) {
		try {
			
			final var domain = MonitorAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(MonitorFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,MonitorFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(MonitorDTO dto) {
		try {
			
			final var domain = MonitorAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(MonitorFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,MonitorFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<MonitorDTO> consultar(MonitorDTO dto) {
		try {
			final var domain = MonitorAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return MonitorAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(MonitorFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, MonitorFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
