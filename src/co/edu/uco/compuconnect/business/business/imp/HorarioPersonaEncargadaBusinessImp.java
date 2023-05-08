package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.business.HorarioPersonaEncargadaBusiness;
import co.edu.uco.compuconnect.business.domain.HorarioPersonaEncargadaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;

public final class HorarioPersonaEncargadaBusinessImp implements HorarioPersonaEncargadaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public HorarioPersonaEncargadaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void asignar(HorarioPersonaEncargadaDomain datosHorario) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(HorarioPersonaEncargadaDomain datosEliminacionHorario) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<HorarioPersonaEncargadaDomain> consultar(HorarioPersonaEncargadaDomain datosFiltroHorario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
