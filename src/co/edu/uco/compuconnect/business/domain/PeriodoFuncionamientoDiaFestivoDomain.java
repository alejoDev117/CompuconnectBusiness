package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class PeriodoFuncionamientoDiaFestivoDomain {

	
	private static final PeriodoFuncionamientoDiaFestivoDomain DEFAULT_OBJECT = new PeriodoFuncionamientoDiaFestivoDomain();
	private UUID identificador;
	private PeriodoFuncionamientoDomain periodoFuncionamiento;
	private DiaFestivoDomain diaFestivo;
	
	
	public PeriodoFuncionamientoDiaFestivoDomain(UUID identificador, PeriodoFuncionamientoDomain periodoFuncionamiento,
			DiaFestivoDomain diaFestivo) {
		super();
		setIdentificador(identificador);
		setPeriodoFuncionamiento(periodoFuncionamiento);
		setDiaFestivo(diaFestivo);
	}


	private PeriodoFuncionamientoDiaFestivoDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setPeriodoFuncionamiento(PeriodoFuncionamientoDomain.getDefaultObject());
		setDiaFestivo(DiaFestivoDomain.getDefaultObject());
	}
	
	
	
	

	public static final PeriodoFuncionamientoDiaFestivoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}


	public final UUID getIdentificador() {
		return identificador;
	}


	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);

	}


	public final PeriodoFuncionamientoDomain getPeriodoFuncionamiento() {
		return periodoFuncionamiento;
	}


	private final void setPeriodoFuncionamiento(PeriodoFuncionamientoDomain periodoFuncionamiento) {
		this.periodoFuncionamiento = UtilObject.getDefault(periodoFuncionamiento, PeriodoFuncionamientoDomain.getDefaultObject());

	}


	public final DiaFestivoDomain getDiaFestivo() {
		return diaFestivo;
	}


	private final void setDiaFestivo(DiaFestivoDomain diaFestivo) {
		this.diaFestivo = UtilObject.getDefault(diaFestivo, DiaFestivoDomain.getDefaultObject());
		
	}



	
	
	
	
}
