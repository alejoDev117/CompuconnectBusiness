package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.ReservaPerfilAssembler;
import co.edu.uco.compuconnect.business.business.ReservaPerfilBusiness;
import co.edu.uco.compuconnect.business.business.imp.ReservaPerfilBusinessImp;
import co.edu.uco.compuconnect.business.facade.ReservaPerfilFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.ReservaPerfilFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.ReservaPerfilDTO;

public final class ReservaPerfilFacadeImp implements ReservaPerfilFacade{
	
	private DAOFactory daoFactory;
	private ReservaPerfilBusiness business;
	
	
	public ReservaPerfilFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new ReservaPerfilBusinessImp(daoFactory);
	}


	@Override
	public void crear(ReservaPerfilDTO dto) {
		try {
			
			final var domain = ReservaPerfilAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(	ReservaPerfilFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,ReservaPerfilFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}


	@Override
	public List<ReservaPerfilDTO> consultar(ReservaPerfilDTO dto) {
		try {
			final var domain = ReservaPerfilAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return ReservaPerfilAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(ReservaPerfilFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, ReservaPerfilFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public void eliminar(ReservaPerfilDTO dto) {
		try {
			
			final var domain = ReservaPerfilAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ReservaPerfilFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,ReservaPerfilFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	
	
	
}
