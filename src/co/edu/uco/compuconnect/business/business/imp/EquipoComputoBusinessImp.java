package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.EquipoComputoBusiness;
import co.edu.uco.compuconnect.business.domain.EquipoComputoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class EquipoComputoBusinessImp implements EquipoComputoBusiness{
	
	private DAOFactory daoFactory;
	
	public EquipoComputoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrar(EquipoComputoDomain datosEquipoComputo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(EquipoComputoDomain datosMotificacionEquipoComputo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EquipoComputoDomain> consultar(EquipoComputoDomain datosFiltroEquipoComputo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(EquipoComputoDomain datosBorrarEquipoComputo) {
		// TODO Auto-generated method stub
		
	}
	
	

}
