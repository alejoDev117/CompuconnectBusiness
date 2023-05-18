package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.PeriodoFuncionamientoDiaFestivoAssembler;
import co.edu.uco.compuconnect.business.business.PeriodoFuncionamientoDiaFestivoBusiness;
import co.edu.uco.compuconnect.business.business.imp.PeriodoFuncionamientoDiaFestivoBusinessImp;
import co.edu.uco.compuconnect.business.facade.PeriodoFuncionamientoDiaFestivoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.PeriodoFuncionamientoDiaFestivoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.PeriodoFuncionamientoDiaFestivoDTO;

public final class PeriodoFuncionamientoDiaFestivoFacadeImp implements PeriodoFuncionamientoDiaFestivoFacade{
	
	private DAOFactory daoFactory;
	private PeriodoFuncionamientoDiaFestivoBusiness business;
	
	public PeriodoFuncionamientoDiaFestivoFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new PeriodoFuncionamientoDiaFestivoBusinessImp(daoFactory);
		
	}

	@Override
	public void crear(PeriodoFuncionamientoDiaFestivoDTO dto) {
		try {
			
			final var domain = PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoDiaFestivoFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,PeriodoFuncionamientoDiaFestivoFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public List<PeriodoFuncionamientoDiaFestivoDTO> consultar(PeriodoFuncionamientoDiaFestivoDTO dto) {
		try {
			final var domain = PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoDiaFestivoFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, PeriodoFuncionamientoDiaFestivoFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(PeriodoFuncionamientoDiaFestivoDTO dto) {
		try {
			
			final var domain = PeriodoFuncionamientoDiaFestivoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(PeriodoFuncionamientoDiaFestivoFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,PeriodoFuncionamientoDiaFestivoFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	

}
