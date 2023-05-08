package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class AgendaReservaDomain {
	
	private static final AgendaReservaDomain DEFAULT_OBJECT = new AgendaReservaDomain();
	private UUID identificador;
	private AgendaDomain agenda;
	private ReservaDomain reserva;
	
	
	public AgendaReservaDomain(UUID identificador, AgendaDomain agenda, ReservaDomain reserva) {
		super();
		setIdentificador(identificador);
		setAgenda(agenda);
		setReserva(reserva);
	}
	
	private AgendaReservaDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setAgenda(AgendaDomain.getDefaultObject());
		setReserva(ReservaDomain.getDefaultObject());
	}
	
	public static final AgendaReservaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final AgendaDomain getAgenda() {
		return agenda;
	}

	private final void setAgenda(final AgendaDomain agenda) {
		this.agenda = UtilObject.getDefault(agenda, AgendaDomain.getDefaultObject());
	}

	public final ReservaDomain getReserva() {
		return reserva;
	}

	private final void setReserva(final ReservaDomain reserva) {
		this.reserva = UtilObject.getDefault(reserva, ReservaDomain.getDefaultObject());
	}
	
	
	
	
	
	
	
	

}
