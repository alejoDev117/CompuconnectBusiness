package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.ExcepcionAssembler;
import co.edu.uco.compuconnect.business.business.ExcepcionBusiness;
import co.edu.uco.compuconnect.business.business.imp.ExcepcionBusinessImp;
import co.edu.uco.compuconnect.business.facade.ExcepcionFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.ExcepcionFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.ExcepcionDTO;

public final class ExcepcionFacadeImp implements ExcepcionFacade{
	
	private DAOFactory daoFactory;
	private ExcepcionBusiness business;
	
	
	public ExcepcionFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new ExcepcionBusinessImp(daoFactory);
	}


	@Override
	public void generar(ExcepcionDTO dto) {
		try {
			
			final var domain = ExcepcionAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.generar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ExcepcionFacadeImpMessage.GENERAR_EXCEPTION_TECHNICAL_MESSAGE,ExcepcionFacadeImpMessage.GENERAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}


	@Override
	public void modificar(ExcepcionDTO dto) {
		try {
			
			final var domain = ExcepcionAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ExcepcionFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,ExcepcionFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public void eliminar(ExcepcionDTO dto) {
		try {
			
			final var domain = ExcepcionAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(ExcepcionFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,ExcepcionFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	@Override
	public List<ExcepcionDTO> consultar(ExcepcionDTO dto) {
		try {
			final var domain = ExcepcionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return ExcepcionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(ExcepcionFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, ExcepcionFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
