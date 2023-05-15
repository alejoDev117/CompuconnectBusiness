package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.TipoIdentificacionAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.TipoNotificacionAssembler;
import co.edu.uco.compuconnect.business.business.TipoNotificacionBusiness;
import co.edu.uco.compuconnect.business.business.imp.TipoNotificacionBusinessImp;
import co.edu.uco.compuconnect.business.facade.TipoNotificacionFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.TipoIdentificacionFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.TipoNotificacionFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.TipoNotificacionDTO;

public final class TipoNotificacionFacadeImp implements TipoNotificacionFacade{
	
	private DAOFactory daoFactory;
	private TipoNotificacionBusiness business;
	
	
	public TipoNotificacionFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new TipoNotificacionBusinessImp(daoFactory);
	}


	@Override
	public List<TipoNotificacionDTO> consultar(TipoNotificacionDTO dto) {
		try {
			final var domain = TipoNotificacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return TipoNotificacionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(TipoNotificacionFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, TipoNotificacionFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
