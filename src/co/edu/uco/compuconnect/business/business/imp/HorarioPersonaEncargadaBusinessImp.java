package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.HorarioPersonaEncargadaAssembler;
import co.edu.uco.compuconnect.business.business.HorarioPersonaEncargadaBusiness;
import co.edu.uco.compuconnect.business.domain.HorarioPersonaEncargadaDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.HorarioPersonaEncargadaEntity;

public final class HorarioPersonaEncargadaBusinessImp implements HorarioPersonaEncargadaBusiness{
	
	private DAOFactory daoFactory;
	
	
	public HorarioPersonaEncargadaBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void asignar(HorarioPersonaEncargadaDomain datosHorario) {
		final HorarioPersonaEncargadaEntity entity = HorarioPersonaEncargadaAssembler.getInstance().toEntityFromDomain(datosHorario);
		daoFactory.getHorarioPersonaEncargadaDAO().create(entity);
	}


	@Override
	public void eliminar(HorarioPersonaEncargadaDomain datosEliminacionHorario) {
		final HorarioPersonaEncargadaEntity entity = HorarioPersonaEncargadaAssembler.getInstance().toEntityFromDomain(datosEliminacionHorario);
		daoFactory.getHorarioPersonaEncargadaDAO().delete(entity);
		
	}


	@Override
	public List<HorarioPersonaEncargadaDomain> consultar(HorarioPersonaEncargadaDomain datosFiltroHorario) {
		final HorarioPersonaEncargadaEntity entity = HorarioPersonaEncargadaAssembler.getInstance().toEntityFromDomain(datosFiltroHorario);
		final List<HorarioPersonaEncargadaEntity> result = daoFactory.getHorarioPersonaEncargadaDAO().read(entity);
		return HorarioPersonaEncargadaAssembler.getInstance().toDomainListFromEntityList(result);
	}
	
	
	

}
