package co.edu.uco.compuconnect.business.domain;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class AgendaDomain {
	
	private static final AgendaDomain DEFAULT_OBJECT = new AgendaDomain();
	private UUID identificador;
	private PeriodoFuncionamientoDomain periodoFuncionamiento;
	private CentroInformaticaDomain centroInformatica;
	private String nombre;
	
	
	


	public AgendaDomain(UUID identificador, PeriodoFuncionamientoDomain periodoFuncionamiento,
			CentroInformaticaDomain centroInformatica, String nombre) {
		super();
		setIdentificador(identificador);
		setPeriodoFuncionamiento(periodoFuncionamiento);
		setCentroInformatica(centroInformatica);
		setNombre(nombre);
	}

	private AgendaDomain() {
		super();	
		setIdentificador(UtilUUID.getDefaultUuid());
		setPeriodoFuncionamiento(PeriodoFuncionamientoDomain.getDefaultObject());
		setCentroInformatica(CentroInformaticaDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		
		
	}
	
	
	
	public static final AgendaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public UUID getIdentificador() {
		return identificador;
	}
	
	
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
		
	}
	
	
	public PeriodoFuncionamientoDomain getPeriodoFuncionamiento() {
		return periodoFuncionamiento;
	}
	
	private final void setPeriodoFuncionamiento(final PeriodoFuncionamientoDomain centroInformatica) {
		this.periodoFuncionamiento = UtilObject.getDefault(periodoFuncionamiento, PeriodoFuncionamientoDomain.getDefaultObject());
		
	}
	
	
	public CentroInformaticaDomain getCentroInformatica() {
		return centroInformatica;
	}
	
	private final void setCentroInformatica(final CentroInformaticaDomain centroInformatica) {
		this.centroInformatica = UtilObject.getDefault(centroInformatica, CentroInformaticaDomain.getDefaultObject());
	
	}
	
	
	public String getNombre() {
		return nombre;
	}
	private final void setNombre(final String nombre) {
		this.nombre = UtilText.applyTrim(nombre) ;
		
	}



}
