package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.CoordinadorBusiness;
import co.edu.uco.compuconnect.business.domain.CoordinadorDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class CoordinadorBusinessImp implements CoordinadorBusiness{
	
	private DAOFactory daoFactory;
	
	public CoordinadorBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrar(CoordinadorDomain datosCoordinador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(CoordinadorDomain datosActualizacionCoordinador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CoordinadorDomain> consultar(CoordinadorDomain datosFiltroCoordiandor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(CoordinadorDomain datosEliminacionCoordinador) {
		// TODO Auto-generated method stub
		
	}
	
	

}
