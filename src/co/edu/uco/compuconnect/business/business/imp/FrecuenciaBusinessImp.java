package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.FrecuenciaBusiness;
import co.edu.uco.compuconnect.business.domain.FrecuenciaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class FrecuenciaBusinessImp implements FrecuenciaBusiness{
	
	private DAOFactory daoFactory;
	
	public FrecuenciaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<FrecuenciaDomain> consultar(FrecuenciaDomain datosFiltroFrecuencia) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
