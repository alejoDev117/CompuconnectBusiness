package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.HorarioPersonaEncargadaAssembler;
import co.edu.uco.compuconnect.business.business.HorarioPersonaEncargadaBusiness;
import co.edu.uco.compuconnect.business.business.imp.HorarioPersonaEncargadaBusinessImp;
import co.edu.uco.compuconnect.business.facade.HorarioPersonaEncargadaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.HorarioPersonaEncargadaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.HorarioPersonaEncargadaDTO;

public final class HorarioPersonaEncargadaFacadeImp implements HorarioPersonaEncargadaFacade{
	
	private DAOFactory daoFactory;
	private HorarioPersonaEncargadaBusiness business;
	
	public HorarioPersonaEncargadaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new HorarioPersonaEncargadaBusinessImp(daoFactory);
	}

	@Override
	public void asignar(HorarioPersonaEncargadaDTO dto) {
		try {
			
			final var domain = HorarioPersonaEncargadaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.asignar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(HorarioPersonaEncargadaFacadeImpMessage.ASIGNAR_EXCEPTION_TECHNICAL_MESSAGE,HorarioPersonaEncargadaFacadeImpMessage.ASIGNAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(HorarioPersonaEncargadaDTO dto) {
		try {
			
			final var domain = HorarioPersonaEncargadaAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(HorarioPersonaEncargadaFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,HorarioPersonaEncargadaFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<HorarioPersonaEncargadaDTO> consultar(HorarioPersonaEncargadaDTO dto) {
		try {
			final var domain = HorarioPersonaEncargadaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return HorarioPersonaEncargadaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(HorarioPersonaEncargadaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, HorarioPersonaEncargadaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
