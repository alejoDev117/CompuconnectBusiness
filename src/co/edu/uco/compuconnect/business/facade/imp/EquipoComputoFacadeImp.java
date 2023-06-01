package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.EquipoComputoAssembler;
import co.edu.uco.compuconnect.business.business.EquipoComputoBusiness;
import co.edu.uco.compuconnect.business.business.imp.EquipoComputoBusinessImp;
import co.edu.uco.compuconnect.business.facade.EquipoComputoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.EquipoComputoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.EquipoComputoDTO;

public final class EquipoComputoFacadeImp implements EquipoComputoFacade{
	
	private DAOFactory daoFactory;
	private EquipoComputoBusiness business;
	
	public EquipoComputoFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new EquipoComputoBusinessImp(daoFactory);
	}

	@Override
	public void registrar(EquipoComputoDTO dto) {
		try {
			
			final var domain = EquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.registrar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(EquipoComputoFacadeImpMessage.REGISTRAR_EXCEPTION_TECHNICAL_MESSAGE,EquipoComputoFacadeImpMessage.REGISTRAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public void modificar(EquipoComputoDTO dto) {
		try {
			
			final var domain = EquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(EquipoComputoFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,EquipoComputoFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<EquipoComputoDTO> consultar(EquipoComputoDTO dto) {
		try {
			final var domain = EquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return EquipoComputoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(EquipoComputoFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, EquipoComputoFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(EquipoComputoDTO dto) {
		try {
			
			final var domain = EquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(EquipoComputoFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,EquipoComputoFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
