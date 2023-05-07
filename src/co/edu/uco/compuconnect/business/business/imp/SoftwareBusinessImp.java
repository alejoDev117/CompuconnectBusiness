package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.SoftwareBusiness;
import co.edu.uco.compuconnect.business.domain.SoftwareDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class SoftwareBusinessImp implements SoftwareBusiness{
	
	private DAOFactory daoFactory;
	
	
	public SoftwareBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void añadir(SoftwareDomain datosSoftware) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(SoftwareDomain datosBorrarSoftware) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<SoftwareDomain> consultar(SoftwareDomain datosFiltroSoftware) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
