package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.DiaSemanalAssembler;
import co.edu.uco.compuconnect.business.business.DiaSemanalBusiness;
import co.edu.uco.compuconnect.business.business.imp.DiaSemanalBusinessImp;
import co.edu.uco.compuconnect.business.facade.DiaSemanalFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.DiaSemanalFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.DiaSemanalDTO;

public final class DiaSemanalFacadeImp implements DiaSemanalFacade{
	
	private final DAOFactory daoFactory;
	private final DiaSemanalBusiness business;
	
	public DiaSemanalFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new DiaSemanalBusinessImp(daoFactory);
	}

	@Override
	public List<DiaSemanalDTO> consultar(DiaSemanalDTO dto) {
		try {
			final var domain = DiaSemanalAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return DiaSemanalAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(DiaSemanalFacadeImpMessage.CONSULTAR_EXCEPCION_TECHNICAL_MESSAGE, DiaSemanalFacadeImpMessage.CONSULTAR_EXCEPCION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
