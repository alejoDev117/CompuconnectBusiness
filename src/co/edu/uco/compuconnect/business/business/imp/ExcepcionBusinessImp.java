package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.ExcepcionBusiness;
import co.edu.uco.compuconnect.business.domain.ExcepcionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class ExcepcionBusinessImp implements ExcepcionBusiness{
	
	private DAOFactory daoFactory;
	
	public ExcepcionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void generar(ExcepcionDomain datosExcepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(ExcepcionDomain datosModificacionExcepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(ExcepcionDomain datosBorrarExcepcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ExcepcionDomain> consultar(ExcepcionDomain datosFiltroExcepcion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
