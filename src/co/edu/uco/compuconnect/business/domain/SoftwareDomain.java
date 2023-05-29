package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class SoftwareDomain {
	
	private static final SoftwareDomain DEFAULT_OBJECT = new SoftwareDomain();
	private UUID identificador;
	private String nombre;
	private String version;
	
	
	public SoftwareDomain(UUID identificador, String nombre, String version) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setVersion(version);
	}

	

	private SoftwareDomain() {
		super();	
		setIdentificador(UtilUUID.getDefaultUuid());
		setNombre(UtilText.getUtilText().getDefaultValue());
		setVersion(UtilText.getUtilText().getDefaultValue());
		}
	
	public static final SoftwareDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	

	

	public final UUID getIdentidicador() {
		return identificador;
	}

	

	private final void setIdentificador(final UUID identidicador) {
		this.identificador = UtilUUID.getDefault(identidicador);
	
	}

	

	public final String getNombre() {
		return nombre;
	}

	

	private final void setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		
	}


	
	public final String getVersion() {
		return version;
	}


	
	private final void setVersion(final String version) {
		this.version = UtilText.getUtilText().applyTrim(version);
	
	}
	

	
	
}
