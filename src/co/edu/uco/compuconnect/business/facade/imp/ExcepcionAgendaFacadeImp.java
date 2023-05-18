package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.ExcepcionAgendaAssembler;
import co.edu.uco.compuconnect.business.business.ExcepcionAgendaBusiness;
import co.edu.uco.compuconnect.business.business.imp.ExcepcionAgendaBusinessImp;
import co.edu.uco.compuconnect.business.facade.ExcepcionAgendaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.ExcepcionAgendaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.ExcepcionAgendaDTO;

public final class ExcepcionAgendaFacadeImp implements ExcepcionAgendaFacade{
	
	private DAOFactory daoFactory;
	private ExcepcionAgendaBusiness business;
	
	
	public ExcepcionAgendaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new ExcepcionAgendaBusinessImp(daoFactory);
	}


	@Override
	public void asignar(ExcepcionAgendaDTO dto) {
		try {
			
			final var domain = ExcepcionAgendaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.asignar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ExcepcionAgendaFacadeImpMessage.ASIGNAR_EXCEPTION_TECHNICAL_MESSAGE,ExcepcionAgendaFacadeImpMessage.ASIGNAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public void eliminar(ExcepcionAgendaDTO dto) {
		try {
			
			final var domain = ExcepcionAgendaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ExcepcionAgendaFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,ExcepcionAgendaFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public List<ExcepcionAgendaDTO> consultar(ExcepcionAgendaDTO dto) {
		try {
			final var domain = ExcepcionAgendaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return ExcepcionAgendaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create( ExcepcionAgendaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, ExcepcionAgendaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
