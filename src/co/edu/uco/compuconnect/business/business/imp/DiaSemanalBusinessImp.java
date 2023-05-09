package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.DiaSemanalAssembler;
import co.edu.uco.compuconnect.business.business.DiaSemanalBusiness;
import co.edu.uco.compuconnect.business.domain.DiaSemanalDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.DiaSemanalEntity;

public final class DiaSemanalBusinessImp implements DiaSemanalBusiness{
	
	public DAOFactory daoFactory;
	
	public DiaSemanalBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
				
	}

	@Override
	public List<DiaSemanalDomain> consultar(DiaSemanalDomain datosFiltroDiaSemanal) {
		final DiaSemanalEntity entity = DiaSemanalAssembler.getInstance().toEntityFromDomain(datosFiltroDiaSemanal);
		final List<DiaSemanalEntity> result = daoFactory.getDiaSemanalDAO().read(entity);
		return null;
	}

}
