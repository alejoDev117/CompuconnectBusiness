package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class PerfilDomain {
	
	private static final PerfilDomain DEFAULT_OBJECT = new PerfilDomain();
	private UUID identificador;
	private UsuarioDomain usuario;
	
	public PerfilDomain(UUID identificador, UsuarioDomain usuario) {
		super();
		setIdentificador(identificador);
		setUsuario(usuario);
	}
	
	private PerfilDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setUsuario(UsuarioDomain.getDeafaulObject());
	}
	
	public static final PerfilDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}
	public final UsuarioDomain getUsuario() {
		return usuario;
	}
	private final void setUsuario(UsuarioDomain usuario) {
		this.usuario = UtilObject.getDefault(usuario, UsuarioDomain.getDeafaulObject());
	}
	
	

}
