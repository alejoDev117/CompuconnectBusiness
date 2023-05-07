package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.DiaFestivoDomain;

public interface DiaFestivoBusiness {
	
	List<DiaFestivoDomain> consultar(DiaFestivoDomain datosFiltroDiaFestivo);
	
	

}
