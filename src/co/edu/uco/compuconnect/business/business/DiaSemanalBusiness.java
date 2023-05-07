package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.DiaSemanalDomain;

public interface DiaSemanalBusiness {

	List<DiaSemanalDomain> consultar(DiaSemanalDomain datosFiltroDiaSemanal);
}
