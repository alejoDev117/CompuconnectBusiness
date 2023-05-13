package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.FrecuenciaAssembler;
import co.edu.uco.compuconnect.business.business.FrecuenciaBusiness;
import co.edu.uco.compuconnect.business.business.imp.FrecuenciaBusinessImp;
import co.edu.uco.compuconnect.business.facade.FrecuenciaFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.FrecuenciaFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.FrecuenciaDTO;

public final class FrecuenciaFacadeImp implements FrecuenciaFacade{
	
	private final DAOFactory daoFactory;
	private final FrecuenciaBusiness business;
	
	public FrecuenciaFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new FrecuenciaBusinessImp(daoFactory);
	}

	@Override
	public List<FrecuenciaDTO> consultar(FrecuenciaDTO dto) {
		try {
			final var domain = FrecuenciaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return FrecuenciaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(FrecuenciaFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, FrecuenciaFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
