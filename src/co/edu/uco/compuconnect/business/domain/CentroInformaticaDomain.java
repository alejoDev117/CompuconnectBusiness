package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;


import co.edu.uco.compuconnect.crosscutting.utils.UtilBoolean;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class CentroInformaticaDomain {
	
	private static final CentroInformaticaDomain DEFAULT_OBJECT = new CentroInformaticaDomain();
	private UUID identificador;
	private String nombre;
	private String ubicacion;
	private boolean poseeVideoBeam;

	
	
	
	
	
	public CentroInformaticaDomain(UUID identificador, String nombre, String ubicacion, boolean poseeVideoBeam) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setUbicacion(ubicacion);
		setPoseeVideoBeam(poseeVideoBeam);
		
	
	}




	private  CentroInformaticaDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setNombre(UtilText.getUtilText().getDefaultValue());
		setUbicacion(UtilText.getUtilText().getDefaultValue());
		setPoseeVideoBeam(UtilBoolean.getDefaultValue());
		
	}
	
	public static final CentroInformaticaDomain getDefaultObject() {
		
		return DEFAULT_OBJECT;
	
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}
	
	public final String getNombre() {
		return nombre;
	}
	
	private final  void  setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		
	}
	
	public final String getUbicacion() {
		return ubicacion;
	}
	private final  void  setUbicacion(final String ubicacion) {
		this.ubicacion = UtilText.getUtilText().applyTrim(ubicacion);
		
	}
	
	
	public final boolean isPoseeVideoBeam() {
		return poseeVideoBeam;
	}
	
	
	private final  void  setPoseeVideoBeam(boolean poseeVideoBeam) {
		this.poseeVideoBeam = UtilBoolean.getDefault(poseeVideoBeam);
		
		
	}
	



}
