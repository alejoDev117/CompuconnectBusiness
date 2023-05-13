package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.EstadoPeriodoFuncionamientoAssembler;
import co.edu.uco.compuconnect.business.business.EstadoPeriodoFuncionamientoBusiness;
import co.edu.uco.compuconnect.business.business.imp.EstadoPeriodoFuncionamientoBusinessImp;
import co.edu.uco.compuconnect.business.facade.EstadoPeriodoFuncionamientoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.EstadoPeriodoFuncionamientoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.EstadoPeriodoFuncionamientoDTO;

public final class EstadoPeriodoFuncionamientoFacadeImp implements EstadoPeriodoFuncionamientoFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoPeriodoFuncionamientoBusiness business;
	
	public EstadoPeriodoFuncionamientoFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new EstadoPeriodoFuncionamientoBusinessImp(daoFactory);
	}

	@Override
	public List<EstadoPeriodoFuncionamientoDTO> consultar(EstadoPeriodoFuncionamientoDTO dto) {
		try {
			final var domain = EstadoPeriodoFuncionamientoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return EstadoPeriodoFuncionamientoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(EstadoPeriodoFuncionamientoFacadeImpMessage.CONSULTAR_EXCEPCION_TECHNICAL_MESSAGE, EstadoPeriodoFuncionamientoFacadeImpMessage.CONSULTAR_EXCEPCION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
