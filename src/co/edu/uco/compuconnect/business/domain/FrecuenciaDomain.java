package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class FrecuenciaDomain {
	
	private static final FrecuenciaDomain DEFAULT_OBJECT = new FrecuenciaDomain();
	private UUID identificador;
	private String nombre;
	private String descripcion;
	
	
	public FrecuenciaDomain(UUID identificador, String nombre, String descripcion) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	private FrecuenciaDomain() { 
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.getDefaultValue());
	}
	
	
	
	
	
	public static final FrecuenciaDomain getDefaultObject() {
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
	
	private final void setNombre(final String nombre) {
		this.nombre = UtilText.applyTrim(nombre) ;
	
	}
	
	public final String getDescripcion() {
		return descripcion;
	}
	
	private final void setDescripcion(final String descripcion) {
		this.descripcion = UtilText.applyTrim(descripcion);
	
	}
	
	

}
