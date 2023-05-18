package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.DetalleReservaAssembler;
import co.edu.uco.compuconnect.business.business.DetalleReservaBusiness;
import co.edu.uco.compuconnect.business.business.imp.DetalleReservaBusinessImp;
import co.edu.uco.compuconnect.business.facade.DetalleReservaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.DetalleReservaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.DetalleReservaDTO;

public final class DetalleReservaFacadeImp implements DetalleReservaFacade{
	
	private DAOFactory daoFactory;
	private DetalleReservaBusiness business;
	
	public DetalleReservaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new DetalleReservaBusinessImp(daoFactory);
	}

	@Override
	public void crear(DetalleReservaDTO dto) {
		try {
			
			final var domain = DetalleReservaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(DetalleReservaFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,DetalleReservaFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificar(DetalleReservaDTO dto) {
		try {
			
			final var domain = DetalleReservaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(DetalleReservaFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,DetalleReservaFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(DetalleReservaDTO dto) {
		try {
			
			final var domain = DetalleReservaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(DetalleReservaFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,DetalleReservaFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<DetalleReservaDTO> consultar(DetalleReservaDTO dto) {
		try {
			final var domain = DetalleReservaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return DetalleReservaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(DetalleReservaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, DetalleReservaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	

}
