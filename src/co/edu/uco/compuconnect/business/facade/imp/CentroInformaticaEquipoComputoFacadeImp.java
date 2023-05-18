package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaEquipoComputoAssembler;
import co.edu.uco.compuconnect.business.business.CentroInformaticaEquipoComputoBusiness;
import co.edu.uco.compuconnect.business.business.imp.CentroInformaticaEquipoComputoBusinessImp;
import co.edu.uco.compuconnect.business.facade.CentroInformaticaEquipoComputoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaEquipoComputoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.CentroInformaticaEquipoComputoDTO;

public final class CentroInformaticaEquipoComputoFacadeImp implements CentroInformaticaEquipoComputoFacade{
	
	private DAOFactory daoFactory;
	private CentroInformaticaEquipoComputoBusiness business;
	
	public CentroInformaticaEquipoComputoFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new CentroInformaticaEquipoComputoBusinessImp(daoFactory);
	}

	@Override
	public void crear(CentroInformaticaEquipoComputoDTO dto) {
		try {
			
			final var domain = CentroInformaticaEquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.crear(domain);;
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(CentroInformaticaEquipoComputoFacadeImpMessage.CREAR_EXCEPTION_TECHNICAL_MESSAGE,CentroInformaticaEquipoComputoFacadeImpMessage.CREAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<CentroInformaticaEquipoComputoDTO> consultar(CentroInformaticaEquipoComputoDTO dto) {
		try {
			final var domain = CentroInformaticaEquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return CentroInformaticaEquipoComputoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(CentroInformaticaEquipoComputoFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, CentroInformaticaEquipoComputoFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void eliminar(CentroInformaticaEquipoComputoDTO dto) {
		try {
			
			final var domain = CentroInformaticaEquipoComputoAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.eliminar(domain);;
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(CentroInformaticaEquipoComputoFacadeImpMessage.ELIMINAR_EXCEPTION_TECHNICAL_MESSAGE,CentroInformaticaEquipoComputoFacadeImpMessage.ELIMINAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	
	

}
