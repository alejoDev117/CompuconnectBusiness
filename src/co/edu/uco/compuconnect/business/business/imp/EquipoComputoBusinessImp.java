package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.EquipoComputoAssembler;
import co.edu.uco.compuconnect.business.business.EquipoComputoBusiness;
import co.edu.uco.compuconnect.business.domain.EquipoComputoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.EquipoComputoEntity;

public final class EquipoComputoBusinessImp implements EquipoComputoBusiness{
	
	private DAOFactory daoFactory;
	
	public EquipoComputoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrar(EquipoComputoDomain datosEquipoComputo) {
		final EquipoComputoEntity entity = EquipoComputoAssembler.getInstance().toEntityFromDomain(datosEquipoComputo);
		daoFactory.getEquipoComputoDAO().create(entity);
		
	}

	@Override
	public void modificar(EquipoComputoDomain datosMotificacionEquipoComputo) {
		final EquipoComputoEntity entity = EquipoComputoAssembler.getInstance().toEntityFromDomain(datosMotificacionEquipoComputo);
		daoFactory.getEquipoComputoDAO().update(entity);
		
		
	}

	@Override
	public List<EquipoComputoDomain> consultar(EquipoComputoDomain datosFiltroEquipoComputo) {
		final EquipoComputoEntity entity = EquipoComputoAssembler.getInstance().toEntityFromDomain(datosFiltroEquipoComputo);
		final List<EquipoComputoEntity> result = daoFactory.getEquipoComputoDAO().read(entity);
		return null;
	}

	@Override
	public void eliminar(EquipoComputoDomain datosBorrarEquipoComputo) {
		final EquipoComputoEntity entity = EquipoComputoAssembler.getInstance().toEntityFromDomain(datosBorrarEquipoComputo);
		daoFactory.getEquipoComputoDAO().delete(entity);
		
	}
	
	

}
