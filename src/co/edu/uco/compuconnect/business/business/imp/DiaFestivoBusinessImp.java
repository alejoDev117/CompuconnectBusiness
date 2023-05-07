package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.DiaFestivoBusiness;
import co.edu.uco.compuconnect.business.domain.DiaFestivoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class DiaFestivoBusinessImp implements DiaFestivoBusiness{
	
	public DAOFactory daoFactory;
	
	public DiaFestivoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<DiaFestivoDomain> consultar(DiaFestivoDomain datosFiltroDiaFestivo) {
		// TODO Auto-generated method stub
		return null;
	}

}
