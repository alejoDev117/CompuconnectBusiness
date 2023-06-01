package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.TipoIdentificacionAssembler;
import co.edu.uco.compuconnect.business.business.TipoIdentificacionBusiness;
import co.edu.uco.compuconnect.business.business.imp.TipoIdentificacionBusinessImp;
import co.edu.uco.compuconnect.business.facade.TipoIdentificacionFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.TipoIdentificacionFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.TipoIdentificacionDTO;

public final class TipoIdentificacionFacadeImp implements TipoIdentificacionFacade{
	
	private DAOFactory daoFactory;
	private TipoIdentificacionBusiness business;
	
	public TipoIdentificacionFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new TipoIdentificacionBusinessImp(daoFactory);
		
	}

	@Override
	public List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO dto) {
		try {
			final var domain = TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return TipoIdentificacionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(TipoIdentificacionFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, TipoIdentificacionFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
