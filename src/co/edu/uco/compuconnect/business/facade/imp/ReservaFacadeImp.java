package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.DetalleReservaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.ReservaAssembler;
import co.edu.uco.compuconnect.business.business.ReservaBusiness;
import co.edu.uco.compuconnect.business.business.imp.ReservaBusinessImp;
import co.edu.uco.compuconnect.business.facade.ReservaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.ReservaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.DetalleReservaDTO;
import co.edu.uco.compuconnect.dto.ReservaDTO;

public final class ReservaFacadeImp implements ReservaFacade{
	private DAOFactory daoFactory;
	private ReservaBusiness business;
	
	public ReservaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new ReservaBusinessImp(daoFactory);
	}

	@Override
	public void generar(ReservaDTO dto) {
		try {
			
			final var domain = ReservaAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.iniciarTransaccion();
			business.generar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ReservaFacadeImpMessage.GENERAR_EXCEPTION_TECHNICAL_MESSAGE,ReservaFacadeImpMessage.GENERAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		
	}

	@Override
	public void modificar(ReservaDTO dto) {
		try {
			
			final var domain = ReservaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ReservaFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,ReservaFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public void cancelar(ReservaDTO dto) {
		try {
			
			final var domain = ReservaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.cancelar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ReservaFacadeImpMessage.CANCELAR_EXCEPTION_TECHNICAL_MESSAGE,ReservaFacadeImpMessage.CANCELAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public List<ReservaDTO> consultar(ReservaDTO dto) {
		try {
			final var domain = ReservaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return ReservaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(ReservaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, ReservaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
