package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.PerfilAssembler;
import co.edu.uco.compuconnect.business.business.PerfilBusiness;
import co.edu.uco.compuconnect.business.business.imp.PerfilBusinessImp;
import co.edu.uco.compuconnect.business.facade.PerfilFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.PerfilFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.PerfilDTO;

public final class PerfilFacadeImp implements PerfilFacade{
	
	private DAOFactory daoFactory;
	private PerfilBusiness business;
	
	public PerfilFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new PerfilBusinessImp(daoFactory);
	}

	@Override
	public void crear(PerfilDTO dto) {
		try {
			
			final var domain = PerfilAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PerfilFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,PerfilFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void actualizar(PerfilDTO dto) {
		try {
			
			final var domain = PerfilAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.actualizar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PerfilFacadeImpMessage.ACTUALIZAR_EXCEPTION_TECHNICAL_MESSAGE,PerfilFacadeImpMessage.ACTUALIZAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(PerfilDTO dto) {
		try {
			
			final var domain = PerfilAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PerfilFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,PerfilFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<PerfilDTO> consultar(PerfilDTO dto) {
		try {
			final var domain = PerfilAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return PerfilAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(PerfilFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, PerfilFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
