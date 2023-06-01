package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.TipoReservaAssembler;
import co.edu.uco.compuconnect.business.business.TipoReservaBusiness;
import co.edu.uco.compuconnect.business.business.imp.TipoReservaBusinessImp;
import co.edu.uco.compuconnect.business.facade.TipoReservaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.TipoReservaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.TipoReservaDTO;

public final class TipoReservaFacadeImp implements TipoReservaFacade{
	
	private final DAOFactory daoFactory;
	private final TipoReservaBusiness business;
	
	public TipoReservaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new TipoReservaBusinessImp(daoFactory);
	}

	@Override
	public List<TipoReservaDTO> consultar(TipoReservaDTO dto) {
		try {
			final var domain = TipoReservaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return TipoReservaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(TipoReservaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, TipoReservaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
