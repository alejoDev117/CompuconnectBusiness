package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.BuzonSolicitudAssembler;
import co.edu.uco.compuconnect.business.business.BuzonSolicitudBusiness;
import co.edu.uco.compuconnect.business.business.imp.BuzonSolicitudBusinessImp;
import co.edu.uco.compuconnect.business.facade.BuzonSolicitudFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.BuzonSolicitudFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.BuzonSolicitudDTO;

public final class BuzonSolicitudFacadeImp implements BuzonSolicitudFacade{
	
	private DAOFactory daoFactory;
	private BuzonSolicitudBusiness business;
	
	
	public BuzonSolicitudFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new BuzonSolicitudBusinessImp(daoFactory);
	}


	@Override
	public void generar(BuzonSolicitudDTO dto) {
		try {
			
			final var domain = BuzonSolicitudAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.generar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(BuzonSolicitudFacadeImpMessage.GENERAR_EXCEPTION_TECHNICAL_MESSAGE,BuzonSolicitudFacadeImpMessage.GENERAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public void actualizar(BuzonSolicitudDTO dto) {
		try {
			
			final var domain = BuzonSolicitudAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.actualizar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(BuzonSolicitudFacadeImpMessage.ACTUALIZAR_EXCEPTION_TECHNICAL_MESSAGE,BuzonSolicitudFacadeImpMessage.ACTUALIZAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public List<BuzonSolicitudDTO> consultar(BuzonSolicitudDTO dto) {
		try {
			final var domain = BuzonSolicitudAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return BuzonSolicitudAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(BuzonSolicitudFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, BuzonSolicitudFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
