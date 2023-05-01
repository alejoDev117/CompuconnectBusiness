package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class EquipoComputoDomain {
	
	private static final EquipoComputoDomain DEFAULT_OBJECT = new EquipoComputoDomain();
	private UUID identificador;
	private String nombre;
	private EstadoEquipoComputoDomain estado;
	
	public EquipoComputoDomain(final UUID identificador,final String nombre,final EstadoEquipoComputoDomain estado) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setEstado(estado);
	
	}
	
	
	private EquipoComputoDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setNombre(UtilText.getDefaultValue());
		setEstado(EstadoEquipoComputoDomain.getDefaultObject());

	}
	
	
	
	
	
	
	
	public static final EquipoComputoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}


	public UUID getIdentificador() {
		return identificador;
	}
	
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	private final void setNombre(final String nombre) {
		this.nombre = UtilText.applyTrim(nombre) ;

	}
	
	
	public EstadoEquipoComputoDomain getEstado() {
		return estado;
	}
	
	
	private final void setEstado(final EstadoEquipoComputoDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoEquipoComputoDomain.getDefaultObject());
	
	}
	
	

}
