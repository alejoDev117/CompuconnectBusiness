package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.SoftwareEquipoComputoDomain;

public interface SoftwareEquipoComputoBusiness {

	void crear(SoftwareEquipoComputoDomain datosCreacionSoftwareEquipoComputo);
	
	void eliminar(SoftwareEquipoComputoDomain datosEliminacionSoftwareEquipoComputo);
	
	List<SoftwareEquipoComputoDomain> consultar(SoftwareEquipoComputoDomain datosFiltroSoftwareEquipoComputo);
	
}
