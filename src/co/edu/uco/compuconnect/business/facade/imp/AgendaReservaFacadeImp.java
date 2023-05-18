package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.AgendaReservaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.business.AgendaReservaBusiness;
import co.edu.uco.compuconnect.business.business.imp.AgendaReservaBusinessImp;
import co.edu.uco.compuconnect.business.facade.AgendaReservaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.AgendaReservaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.AgendaReservaDAO;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.AgendaReservaDTO;

public final class AgendaReservaFacadeImp implements AgendaReservaFacade{
	
	private DAOFactory daoFactory;
	private AgendaReservaBusiness business;
	
	public AgendaReservaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new AgendaReservaBusinessImp(daoFactory);
	}

	@Override
	public void crear(AgendaReservaDTO dto) {
		try {
			
			final var domain = AgendaReservaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(AgendaReservaFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,AgendaReservaFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public List<AgendaReservaDTO> consultar(AgendaReservaDTO dto) {
		try {
			final var domain = AgendaReservaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return AgendaReservaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(AgendaReservaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, AgendaReservaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(AgendaReservaDTO dto) {
		try {
			
			final var domain = AgendaReservaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(AgendaReservaFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,AgendaReservaFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	



	

}
