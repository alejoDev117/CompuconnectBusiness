package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.PeriodoFuncionamientoAssembler;
import co.edu.uco.compuconnect.business.business.PeriodoFuncionamientoBusiness;
import co.edu.uco.compuconnect.business.business.imp.PeriodoFuncionamientoBusinessImp;
import co.edu.uco.compuconnect.business.facade.PeriodoFuncionamientoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.PeriodoFuncionamientoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.PeriodoFuncionamientoDTO;

public final class PeriodoFuncionamientoFacadeImp implements PeriodoFuncionamientoFacade{
	
	private DAOFactory daoFactory;
	private PeriodoFuncionamientoBusiness business;
	
	public PeriodoFuncionamientoFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new PeriodoFuncionamientoBusinessImp(daoFactory);
	}

	@Override
	public void crear(PeriodoFuncionamientoDTO dto) {
		try {
			
			final var domain = PeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,PeriodoFuncionamientoFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificar(PeriodoFuncionamientoDTO dto) {
	try {
			
			final var domain = PeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.modificar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoFacadeImpMessage.MODIFICAR_EXCEPTION_TECHNICAL_MESSAGE,PeriodoFuncionamientoFacadeImpMessage.MODIFICAR_EXCEPCTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(PeriodoFuncionamientoDTO dto) {
	try {
			
			final var domain = PeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,PeriodoFuncionamientoFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<PeriodoFuncionamientoDTO> consultar(PeriodoFuncionamientoDTO dto) {
		try {
			final var domain = PeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return PeriodoFuncionamientoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, PeriodoFuncionamientoFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	
	

}
