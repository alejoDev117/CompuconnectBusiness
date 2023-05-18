package co.edu.uco.compuconnect.business.facade.imp;

import co.edu.uco.compuconnect.business.assembler.concrete.NotificacionAssembler;
import co.edu.uco.compuconnect.business.business.NotificacionBusiness;
import co.edu.uco.compuconnect.business.business.imp.NotificacionBusinessImp;
import co.edu.uco.compuconnect.business.facade.NotificacionFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.NotificacionFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.NotificacionDTO;

public final class NotificacionFacadeImp implements NotificacionFacade{
	
	private DAOFactory daoFactory;
	private NotificacionBusiness business;
	
	public NotificacionFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new NotificacionBusinessImp(daoFactory);
	}

	@Override
	public void generar(NotificacionDTO dto) {
		try {
			
			final var domain = NotificacionAssembler.getInstance().toDomainFromDto(dto);
			
			daoFactory.iniciarTransaccion();
			business.generar(domain);
			daoFactory.confirmarTransaccion();
		}catch(final CompuconnectException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch(final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			throw CompuconnectBusinessException.create(NotificacionFacadeImpMessage.GENERAR_EXCEPTION_TECHNICAL_MESSAGE,NotificacionFacadeImpMessage.GENERAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}
	
	

}
