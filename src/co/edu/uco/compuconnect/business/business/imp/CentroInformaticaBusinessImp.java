package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;
import java.util.UUID;

import co.edu.uco.compuconnect.business.assembler.concrete.CentroInformaticaAssembler;
import co.edu.uco.compuconnect.business.business.CentroInformaticaBusiness;
import co.edu.uco.compuconnect.business.domain.CentroInformaticaDomain;
import co.edu.uco.compuconnect.crosscutting.exceptions.CompuconnectBusinessException;
import co.edu.uco.compuconnect.crosscutting.utils.Messages.CentroInformaticaBusinessImpMessage;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.CentroInformaticaEntity;

public final class CentroInformaticaBusinessImp implements CentroInformaticaBusiness{

	private DAOFactory daoFactory;
	
	public CentroInformaticaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public final void crear(final CentroInformaticaDomain datosCentroInformatica) {
		
		UUID identificador;
		CentroInformaticaEntity entityTmp;
		List<CentroInformaticaEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = CentroInformaticaEntity.create().setIdentificador(identificador);
			result = daoFactory.getCentroInformaticaDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		
		daoFactory.getCentroInformaticaDAO().create(CentroInformaticaAssembler.getInstance().toEntityFromDomain(datosCentroInformatica));
		
		
	}

	@Override
	public final  List<CentroInformaticaDomain> consultar(final CentroInformaticaDomain datosFiltroCentroInformatica) {
		final CentroInformaticaEntity entity = CentroInformaticaAssembler.getInstance().toEntityFromDomain(datosFiltroCentroInformatica);
		final List<CentroInformaticaEntity> result = daoFactory.getCentroInformaticaDAO().read(entity);
		return CentroInformaticaAssembler.getInstance().toDomainListFromEntityList(result);
	}

	@Override
	public final void modificar(final CentroInformaticaDomain datosModCentroInformatica) {
		
		CentroInformaticaEntity entityTmpIdentificador;
		List<CentroInformaticaEntity> resultIdentificador;
		entityTmpIdentificador = CentroInformaticaEntity.create().setIdentificador(datosModCentroInformatica.getIdentificador());
		
		resultIdentificador = daoFactory.getCentroInformaticaDAO().read(entityTmpIdentificador);
		
		if(resultIdentificador.isEmpty()) {
			throw CompuconnectBusinessException.create(CentroInformaticaBusinessImpMessage.BUSINESS_RULE_CENTRO_INFORMATICA_ID_NOT_FOUND);
		}
		
		daoFactory.getCentroInformaticaDAO().update(CentroInformaticaAssembler.getInstance().toEntityFromDomain(datosModCentroInformatica));
		
	}

	@Override
	public final void eliminar(final CentroInformaticaDomain identificadorEliminacionCentroInformatica) {
		
		CentroInformaticaEntity entityTmpIdentificador;
		List<CentroInformaticaEntity> resultIdentificador;
		entityTmpIdentificador = CentroInformaticaEntity.create().setIdentificador(identificadorEliminacionCentroInformatica.getIdentificador());
		
		resultIdentificador = daoFactory.getCentroInformaticaDAO().read(entityTmpIdentificador);
		
		if(resultIdentificador.isEmpty()) {
			throw CompuconnectBusinessException.create(CentroInformaticaBusinessImpMessage.BUSINESS_RULE_CENTRO_INFORMATICA_ID_NOT_FOUND);
		}
		daoFactory.getCentroInformaticaDAO().delete(CentroInformaticaAssembler.getInstance().toEntityFromDomain(identificadorEliminacionCentroInformatica));
		
	}
	
	

}
