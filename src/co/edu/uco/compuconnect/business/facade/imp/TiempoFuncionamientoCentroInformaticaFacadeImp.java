package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.TiempoFuncionamientoCentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.business.TiempoFuncionamientoCentroInformaticaBusiness;
import co.edu.uco.compuconnect.business.business.imp.TiempoFuncionamientoCentroInformaticaBusinessImp;
import co.edu.uco.compuconnect.business.facade.TiempoFuncionamientoCentroInformaticaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.TiempoFuncionamientoCentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.TiempoFuncionamientoCentroInformaticaDTO;

public final class TiempoFuncionamientoCentroInformaticaFacadeImp implements TiempoFuncionamientoCentroInformaticaFacade{
	
	private DAOFactory daoFactory;
	private TiempoFuncionamientoCentroInformaticaBusiness business;
	
	public TiempoFuncionamientoCentroInformaticaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new TiempoFuncionamientoCentroInformaticaBusinessImp(daoFactory);
	}

	@Override
	public void crear(TiempoFuncionamientoCentroInformaticaDTO dto) {
		try {
			
			final var domain = TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(TiempoFuncionamientoCentroInformaticaFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE ,TiempoFuncionamientoCentroInformaticaFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(TiempoFuncionamientoCentroInformaticaDTO dto) {
		try {
			
			final var domain = TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(TiempoFuncionamientoCentroInformaticaFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE ,TiempoFuncionamientoCentroInformaticaFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<TiempoFuncionamientoCentroInformaticaDTO> consultar(TiempoFuncionamientoCentroInformaticaDTO dto) {
		try {
			final var domain = TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return TiempoFuncionamientoCentroInformaticaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(TiempoFuncionamientoCentroInformaticaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, TiempoFuncionamientoCentroInformaticaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
