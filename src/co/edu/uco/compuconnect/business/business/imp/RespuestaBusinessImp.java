package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.RespuestaBusiness;
import co.edu.uco.compuconnect.business.domain.RespuestaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class RespuestaBusinessImp implements RespuestaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public RespuestaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void realizar(RespuestaDomain datosRespuesa) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(RespuestaDomain datosEliminacionRespuesta) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<RespuestaDomain> consultar(RespuestaDomain datosFiltroRespuesta) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
