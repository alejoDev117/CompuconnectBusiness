package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;



import co.edu.uco.compuconnect.business.assembler.concrete.TipoUsuarioAssembler;
import co.edu.uco.compuconnect.business.business.TipoUsuarioBusiness;
import co.edu.uco.compuconnect.business.business.imp.TipoUsuarioBusinessImp;
import co.edu.uco.compuconnect.business.facade.TipoUsuarioFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.TipoUsuarioFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.TipoUsuarioDTO;

public final class TipoUsuarioFacadeImp implements TipoUsuarioFacade{
	
	private final DAOFactory daoFactory;
	private final TipoUsuarioBusiness business;
	
	public TipoUsuarioFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new TipoUsuarioBusinessImp(daoFactory);
	}

	@Override
	public List<TipoUsuarioDTO> consultar(TipoUsuarioDTO dto) {
		try {
			final var domain = TipoUsuarioAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return TipoUsuarioAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(TipoUsuarioFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, TipoUsuarioFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
