package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class ReservaPerfilDomain {

	private static final ReservaPerfilDomain DEFAULT_OBJECT = new ReservaPerfilDomain();
	private UUID identificador;
	private ReservaDomain reserva;
	private PerfilDomain perfil;
	
	
	public ReservaPerfilDomain(UUID identificador, ReservaDomain reserva, PerfilDomain perfil) {
		super();
		setIdentificador(identificador);
		setReserva(reserva);
		setPerfil(perfil);
	}
	
	private ReservaPerfilDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setReserva(ReservaDomain.getDefaultObject());
		setPerfil(PerfilDomain.getDefaultObject());
	}
	
	public static final ReservaPerfilDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}
	public final ReservaDomain getReserva() {
		return reserva;
	}
	private final void setReserva(ReservaDomain reserva) {
		this.reserva = UtilObject.getDefault(reserva, ReservaDomain.getDefaultObject());
	}
	public final PerfilDomain getPerfil() {
		return perfil;
	}
	private final void setPerfil(PerfilDomain perfil) {
		this.perfil = UtilObject.getDefault(perfil, PerfilDomain.getDefaultObject());
	}
	
	
}
