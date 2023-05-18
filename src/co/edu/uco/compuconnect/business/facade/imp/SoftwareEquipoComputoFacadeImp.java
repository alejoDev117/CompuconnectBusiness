package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.SoftwareEquipoComputoAssembler;
import co.edu.uco.compuconnect.business.business.SoftwareEquipoComputoBusiness;
import co.edu.uco.compuconnect.business.facade.SoftwareEquipoComputoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.SoftwareEquipoComputoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.dto.SoftwareEquipoComputoDTO;

public final class SoftwareEquipoComputoFacadeImp implements SoftwareEquipoComputoFacade{
	
	private DAOFactory daoFactory;
	private SoftwareEquipoComputoBusiness business;
	
	public SoftwareEquipoComputoFacadeImp() {
		
	}

	@Override
	public void crear(SoftwareEquipoComputoDTO dto) {
		try {
			
			final var domain = SoftwareEquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(SoftwareEquipoComputoFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,SoftwareEquipoComputoFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(SoftwareEquipoComputoDTO dto) {
		try {
			
			final var domain = SoftwareEquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(SoftwareEquipoComputoFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,SoftwareEquipoComputoFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<SoftwareEquipoComputoDTO> consultar(SoftwareEquipoComputoDTO dto) {
		try {
			final var domain = SoftwareEquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return SoftwareEquipoComputoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(SoftwareEquipoComputoFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, SoftwareEquipoComputoFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
