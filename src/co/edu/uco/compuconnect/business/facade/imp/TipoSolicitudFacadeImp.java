package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.TipoSolicitudAssembler;
import co.edu.uco.compuconnect.business.business.TipoSolicitudBusiness;
import co.edu.uco.compuconnect.business.business.imp.TipoSolicitudBusinessImp;
import co.edu.uco.compuconnect.business.domain.TipoSolicitudDomain;
import co.edu.uco.compuconnect.business.facade.TipoSolicitudFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.TipoSolicitudFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.TipoSolicitudDTO;

public final class TipoSolicitudFacadeImp implements TipoSolicitudFacade{
	
	private DAOFactory daoFactory;
	private TipoSolicitudBusiness business;
	
	public TipoSolicitudFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new TipoSolicitudBusinessImp(daoFactory);
	}

	@Override
	public List<TipoSolicitudDTO> consultar(TipoSolicitudDTO dto) {
		try {
			final var domain = TipoSolicitudAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return TipoSolicitudAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(TipoSolicitudFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, TipoSolicitudFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}


	
	

}
