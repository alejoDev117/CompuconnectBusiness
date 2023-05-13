package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.business.CentroInformaticaBusiness;
import co.edu.uco.compuconnect.business.business.imp.CentroInformaticaBusinessImp;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaDomain;
import co.edu.uco.compuconnect.business.facade.CentroInformaticaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.CentroInformaticaDTO;
import co.edu.uco.compuconnect.entities.CentroInformaticaEntity;

public final class CentroInformaticaFacadeImp implements CentroInformaticaFacade{

	
	private final DAOFactory daoFactory;
	private final CentroInformaticaBusiness business;
	
	
	public CentroInformaticaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new CentroInformaticaBusinessImp(daoFactory);
	}
	
	
	
	@Override
	public void create(CentroInformaticaDTO dto) {
		try {
			
			final var domain = CentroInformaticaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(CentroInformaticaFacadeImpMessage.CREATE_EXCEPTION_TECHNICAL_MESSAGE,CentroInformaticaFacadeImpMessage.CREATE_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		
	}

	@Override
	public List<CentroInformaticaDTO> read(CentroInformaticaDTO dto) {
		try {
			final var domain = CentroInformaticaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return CentroInformaticaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(CentroInformaticaFacadeImpMessage.READ_EXCEPTION_TECHNICAL_MESSAGE, CentroInformaticaFacadeImpMessage.CREATE_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void update(CentroInformaticaDTO dto) {
		try {
			
			final var domain = CentroInformaticaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(CentroInformaticaFacadeImpMessage.UPDATE_EXCEPTION_TECHNICAL_MESSAGE,CentroInformaticaFacadeImpMessage.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void delete(CentroInformaticaDTO dto) {
		try {
			
			final var domain = CentroInformaticaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(CentroInformaticaFacadeImpMessage.DELETE_EXCEPTION_TECHNICAL_MESSAGE,CentroInformaticaFacadeImpMessage.DELETE_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	
	
	

	
	

	
}
