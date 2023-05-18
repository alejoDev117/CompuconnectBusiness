package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.SolicitudPerfilAssembler;
import co.edu.uco.compuconnect.business.business.SolicitudPerfilBusiness;
import co.edu.uco.compuconnect.business.business.imp.SolicitudPerfilBusinessImp;
import co.edu.uco.compuconnect.business.facade.SolicitudPerfilFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.SolicitudPerfilFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.SolicitudPerfilDTO;

public final class SolicitudPerfilFacadeImp implements SolicitudPerfilFacade{
	
	private DAOFactory daoFactory;
	private SolicitudPerfilBusiness business;
	
	public SolicitudPerfilFacadeImp() {
		this.daoFactory  =DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new SolicitudPerfilBusinessImp(daoFactory);
	}

	@Override
	public void crear(SolicitudPerfilDTO dto) {
		try {
			
			final var domain = SolicitudPerfilAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(SolicitudPerfilFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,SolicitudPerfilFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<SolicitudPerfilDTO> consultar(SolicitudPerfilDTO dto) {
		try {
			final var domain = SolicitudPerfilAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return SolicitudPerfilAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(SolicitudPerfilFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, SolicitudPerfilFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(SolicitudPerfilDTO dto) {
		try {
			
			final var domain = SolicitudPerfilAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(SolicitudPerfilFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,SolicitudPerfilFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
