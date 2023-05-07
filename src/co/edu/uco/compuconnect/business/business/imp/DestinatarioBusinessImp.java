package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.DestinatarioBusiness;
import co.edu.uco.compuconnect.business.domain.DestinatarioDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class DestinatarioBusinessImp implements DestinatarioBusiness{
	
	private DAOFactory daoFactory;
	
	public DestinatarioBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrar(DestinatarioDomain datosRegistroDestinatario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(DestinatarioDomain datosModificacionDestintario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DestinatarioDomain> consultar(DestinatarioDomain datosFiltroDestinatario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(DestinatarioDomain datosEliminacionDestinatario) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
