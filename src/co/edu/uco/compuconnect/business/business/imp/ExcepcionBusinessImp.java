package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.ExcepcionAssembler;
import co.edu.uco.compuconnect.business.business.ExcepcionBusiness;
import co.edu.uco.compuconnect.business.domain.ExcepcionDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.ExcepcionEntity;

public final class ExcepcionBusinessImp implements ExcepcionBusiness{
	
	private DAOFactory daoFactory;
	
	public ExcepcionBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void generar(ExcepcionDomain datosExcepcion) {
		final ExcepcionEntity entity = ExcepcionAssembler.getInstance().toEntityFromDomain(datosExcepcion);
		daoFactory.getExcepcionDAO().create(entity);
		
	}

	@Override
	public void modificar(ExcepcionDomain datosModificacionExcepcion) {
		final ExcepcionEntity entity = ExcepcionAssembler.getInstance().toEntityFromDomain(datosModificacionExcepcion);
		daoFactory.getExcepcionDAO().update(entity);
		
	}

	@Override
	public void eliminar(ExcepcionDomain datosBorrarExcepcion) {
		final ExcepcionEntity entity = ExcepcionAssembler.getInstance().toEntityFromDomain(datosBorrarExcepcion);
		daoFactory.getExcepcionDAO().update(entity);
		
		
	}

	@Override
	public List<ExcepcionDomain> consultar(ExcepcionDomain datosFiltroExcepcion) {
		final ExcepcionEntity entity = ExcepcionAssembler.getInstance().toEntityFromDomain(datosFiltroExcepcion);
		final List<ExcepcionEntity> result = daoFactory.getExcepcionDAO().read(entity);
		return null;
	}
	
	

}
