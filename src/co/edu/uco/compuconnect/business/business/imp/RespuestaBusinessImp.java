package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.RespuestaAssembler;
import co.edu.uco.compuconnect.business.business.RespuestaBusiness;
import co.edu.uco.compuconnect.business.business.RespuestaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.RespuestaEntity;

public final class RespuestaBusinessImp implements RespuestaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public RespuestaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void realizar(RespuestaDomain datosRespuesa) {
		final RespuestaEntity entity = RespuestaAssembler.getInstance().toEntityFromDomain(datosRespuesa);
		daoFactory.getRespuestaDAO().create(entity);
	
	}


	@Override
	public void eliminar(RespuestaDomain datosEliminacionRespuesta) {
		final RespuestaEntity entity = RespuestaAssembler.getInstance().toEntityFromDomain(datosEliminacionRespuesta);
		daoFactory.getRespuestaDAO().delete(entity);
		
	}


	@Override
	public List<RespuestaDomain> consultar(RespuestaDomain datosFiltroRespuesta) {
		final RespuestaEntity entity = RespuestaAssembler.getInstance().toEntityFromDomain(datosFiltroRespuesta);
		final List<RespuestaEntity> result = daoFactory.getRespuestaDAO().read(entity);
		return null;
	}
	
	

}
