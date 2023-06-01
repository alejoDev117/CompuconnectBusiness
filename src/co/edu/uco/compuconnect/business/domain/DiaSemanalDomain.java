package co.edu.uco.compuconnect.business.domain;



import java.util.UUID;


import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class DiaSemanalDomain {
	
	private static final DiaSemanalDomain DEFAULT_OBJECT = new DiaSemanalDomain();
	private UUID identificador;
	private String nombre;
	
	
	public DiaSemanalDomain(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
	}
	
	private  DiaSemanalDomain() { 
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setNombre(UtilText.getUtilText().getDefaultValue());
	}
	
	
	
	public static final DiaSemanalDomain getDefaultObject() {
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
		this.nombre = UtilText.getUtilText().applyTrim(nombre) ;
	
	}
	
}

