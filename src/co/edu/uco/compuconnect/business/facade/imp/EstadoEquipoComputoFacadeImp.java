package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;


import co.edu.uco.compuconnect.business.assembler.concrete.EstadoEquipoComputoAssembler;
import co.edu.uco.compuconnect.business.business.EstadoEquipoComputoBusiness;
import co.edu.uco.compuconnect.business.business.imp.EstadoEquipoComputoBusinessImp;
import co.edu.uco.compuconnect.business.facade.EstadoEquipoComputoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.EstadoEquipoComputoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.EstadoEquipoComputoDTO;

public final class EstadoEquipoComputoFacadeImp implements EstadoEquipoComputoFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoEquipoComputoBusiness business;
	
	
	private EstadoEquipoComputoFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new EstadoEquipoComputoBusinessImp(daoFactory);
	}


	@Override
	public List<EstadoEquipoComputoDTO> consultar(EstadoEquipoComputoDTO dto) {
	try {	
		final var domain = EstadoEquipoComputoAssembler.getInstance().toDomainFromDto(dto);
		final var returnDomainList = business.consultar(domain);
		return EstadoEquipoComputoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		
	}catch(final CompuconnectException exception) {
		throw exception;
	}catch(final Exception exception) {
		throw CompuconnectBusinessException.create(EstadoEquipoComputoFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, EstadoEquipoComputoFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
	}finally {
		daoFactory.cerrarConexion();
	}
	}

	
	
}
