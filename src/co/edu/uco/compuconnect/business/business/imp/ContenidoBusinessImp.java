package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.ContenidoBusiness;
import co.edu.uco.compuconnect.business.domain.ContenidoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class ContenidoBusinessImp implements ContenidoBusiness{
	
	private DAOFactory daoFactory;
	
	
	public ContenidoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(ContenidoDomain datosContenido) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(ContenidoDomain datosEliminacionContenido) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ContenidoDomain> consultar(ContenidoDomain datosFiltroContenido) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
