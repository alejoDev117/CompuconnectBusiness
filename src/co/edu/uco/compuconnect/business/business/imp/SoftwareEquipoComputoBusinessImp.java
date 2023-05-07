package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.SoftwareEquipoComputoBusiness;
import co.edu.uco.compuconnect.business.domain.SoftwareEquipoComputoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class SoftwareEquipoComputoBusinessImp implements SoftwareEquipoComputoBusiness{
	
	private DAOFactory daoFactory;
	
	
	public SoftwareEquipoComputoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(SoftwareEquipoComputoDomain datosCreacionSoftwareEquipoComputo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(SoftwareEquipoComputoDomain datosEliminacionSoftwareEquipoComputo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<SoftwareEquipoComputoDomain> consultar(SoftwareEquipoComputoDomain datosFiltroSoftwareEquipoComputo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
