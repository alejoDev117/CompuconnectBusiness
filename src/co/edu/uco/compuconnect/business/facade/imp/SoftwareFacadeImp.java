package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.SoftwareAssembler;
import co.edu.uco.compuconnect.business.business.SoftwareBusiness;
import co.edu.uco.compuconnect.business.business.imp.SoftwareBusinessImp;
import co.edu.uco.compuconnect.business.facade.SoftwareFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.SoftwareFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.SoftwareDTO;

public final class SoftwareFacadeImp implements SoftwareFacade{
	
	private DAOFactory daoFactory;
	private SoftwareBusiness business;
	
	
	public SoftwareFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new SoftwareBusinessImp(daoFactory);
	}


	@Override
	public void añadir(SoftwareDTO dto) {
		try {
			
			final var domain = SoftwareAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.añadir(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(SoftwareFacadeImpMessage.AÑADIR_EXCECPTION_TECHNICAL_MESSAGE,SoftwareFacadeImpMessage.AÑADIR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		
	}


	@Override
	public void eliminar(SoftwareDTO dto) {
		try {
			
			final var domain = SoftwareAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(SoftwareFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,SoftwareFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}


	@Override
	public List<SoftwareDTO> consultar(SoftwareDTO dto) {
		try {
			final var domain = SoftwareAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return SoftwareAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(SoftwareFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, SoftwareFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
