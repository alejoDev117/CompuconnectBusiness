package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.DiaSemanalBusiness;
import co.edu.uco.compuconnect.business.domain.DiaSemanalDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class DiaSemanalBusinessImp implements DiaSemanalBusiness{
	
	public DAOFactory daoFactory;
	
	public DiaSemanalBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
				
	}

	@Override
	public List<DiaSemanalDomain> consultar(DiaSemanalDomain datosFiltroDiaSemanal) {
		// TODO Auto-generated method stub
		return null;
	}

}
