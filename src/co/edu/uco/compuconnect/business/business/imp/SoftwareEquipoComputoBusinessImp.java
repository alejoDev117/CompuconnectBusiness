package co.edu.uco.compuconnect.business.business.imp;

import java.util.List;

import co.edu.uco.compuconnect.business.assembler.concrete.SoftwareEquipoComputoAssembler;
import co.edu.uco.compuconnect.business.business.SoftwareEquipoComputoBusiness;
import co.edu.uco.compuconnect.business.domain.SoftwareEquipoComputoDomain;
import co.edu.uco.compuconnect.data.dao.factory.DAOFactory;
import co.edu.uco.compuconnect.entities.SoftwareEquipoComputoEntity;

public final class SoftwareEquipoComputoBusinessImp implements SoftwareEquipoComputoBusiness{
	
	private DAOFactory daoFactory;
	
	
	public SoftwareEquipoComputoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public void crear(SoftwareEquipoComputoDomain datosCreacionSoftwareEquipoComputo) {
		final SoftwareEquipoComputoEntity entity = SoftwareEquipoComputoAssembler.getInstance().toEntityFromDomain(datosCreacionSoftwareEquipoComputo);
		daoFactory.getSoftwareEquipoComputoDAO().create(entity);
		
	}


	@Override
	public void eliminar(SoftwareEquipoComputoDomain datosEliminacionSoftwareEquipoComputo) {
		final SoftwareEquipoComputoEntity entity = SoftwareEquipoComputoAssembler.getInstance().toEntityFromDomain(datosEliminacionSoftwareEquipoComputo);
		daoFactory.getSoftwareEquipoComputoDAO().delete(entity);
		
	}


	@Override
	public List<SoftwareEquipoComputoDomain> consultar(SoftwareEquipoComputoDomain datosFiltroSoftwareEquipoComputo) {
		final SoftwareEquipoComputoEntity entity = SoftwareEquipoComputoAssembler.getInstance().toEntityFromDomain(datosFiltroSoftwareEquipoComputo);
		final List<SoftwareEquipoComputoEntity> result = daoFactory.getSoftwareEquipoComputoDAO().read(entity);
		return null;
	}
	
	
	

}
