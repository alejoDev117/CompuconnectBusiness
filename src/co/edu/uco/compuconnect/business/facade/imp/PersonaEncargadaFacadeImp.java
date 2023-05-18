package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.PersonaEncargadaAssembler;
import co.edu.uco.compuconnect.business.business.PersonaEncargadaBusiness;
import co.edu.uco.compuconnect.business.business.imp.PersonaEncargadaBusinessImp;
import co.edu.uco.compuconnect.business.facade.PersonaEncargadaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.PersonaEncargadaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.PersonaEncargadaDTO;

public final class PersonaEncargadaFacadeImp implements PersonaEncargadaFacade{
	
	private DAOFactory daoFactory;
	private PersonaEncargadaBusiness business;
	
	
	
	public PersonaEncargadaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new PersonaEncargadaBusinessImp(daoFactory);
	}
	
	
	@Override
	public void crear(PersonaEncargadaDTO dto) {
		try {
			
			final var domain = PersonaEncargadaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PersonaEncargadaFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,PersonaEncargadaFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}
	@Override
	public void modificar(PersonaEncargadaDTO dto) {
		try {
			
			final var domain = PersonaEncargadaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PersonaEncargadaFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,PersonaEncargadaFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}
	@Override
	public void eliminar(PersonaEncargadaDTO dto) {
		try {
			
			final var domain = PersonaEncargadaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PersonaEncargadaFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,PersonaEncargadaFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}
	@Override
	public List<PersonaEncargadaDTO> consultar(PersonaEncargadaDTO dto) {
		try {
			final var domain = PersonaEncargadaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return PersonaEncargadaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(PersonaEncargadaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, PersonaEncargadaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
