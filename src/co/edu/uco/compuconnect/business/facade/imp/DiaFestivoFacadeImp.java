package co.edu.uco.compuconnect.business.facade.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.assembler.concrete.DiaFestivoAssembler;
import co.edu.uco.compuconnect.business.business.DiaFestivoBusiness;
import co.edu.uco.compuconnect.business.business.imp.DiaFestivoBusinessImp;
import co.edu.uco.compuconnect.business.facade.DiaFestivoFacade;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaFacadeImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.DiaFestivoFacadeImpMessage;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.data.dao.factory.Factory;
import co.edu.uco.compuconnect.dto.DiaFestivoDTO;

public final class DiaFestivoFacadeImp implements DiaFestivoFacade{

	private final DAOFactory daoFactory;
	private final DiaFestivoBusiness business;
	
	public DiaFestivoFacadeImp() {
		this.daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		this.business = new DiaFestivoBusinessImp(daoFactory);
	}
	
	
	
	
	@Override
	public List<DiaFestivoDTO> consultar(DiaFestivoDTO dto) {
		try {
			final var domain = DiaFestivoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.consultar(domain);
			return DiaFestivoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
			
		}catch(final CompuconnectException exception) {
			throw exception;
		}catch(final Exception exception) {
			throw CompuconnectBusinessException.create(DiaFestivoFacadeImpMessage.CONSULTAR_EXCEPTION_TECHNICAL_MESSAGE, DiaFestivoFacadeImpMessage.CONSULTAR_EXCEPTION_USER_MESSAGE, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}
	
	

}
