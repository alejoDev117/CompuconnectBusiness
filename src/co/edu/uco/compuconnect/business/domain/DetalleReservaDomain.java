package co.edu.uco.compuconnect.business.domain;

import java.time.LocalTime;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class DetalleReservaDomain {
	

	private static final DetalleReservaDomain DEFAULT_OBJECT = new DetalleReservaDomain();
	private UUID identificador;
	private ReservaDomain reserva;
	private DiaSemanalDomain dia;
	private LocalTime horainicio;
	private LocalTime horafin;
	
	
	public DetalleReservaDomain(UUID identificador,ReservaDomain reserva, DiaSemanalDomain dia, LocalTime horainicio,
			LocalTime horafin) {
		super();
		setIdentificador(identificador);
		setReserva(reserva);
		setDia(dia);
		setHorainicio(horainicio);
		setHorafin(horafin);
	}
	
	private DetalleReservaDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setReserva(ReservaDomain.getDefaultObject());
		setDia(DiaSemanalDomain.getDefaultObject());
		setHorainicio(UtilDateTime.getDefaultValueLocaltime());
		setHorafin(UtilDateTime.getDefaultValueLocaltime());
	}
	
	public static final DetalleReservaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final DiaSemanalDomain getDia() {
		return dia;
	}

	private final void setDia(DiaSemanalDomain dia) {
		this.dia = UtilObject.getDefault(dia, DiaSemanalDomain.getDefaultObject());
	}

	public final LocalTime getHorainicio() {
		return horainicio;
	}

	private final void setHorainicio(LocalTime horainicio) {
		this.horainicio = UtilDateTime.getDefaultLocalTime(horainicio);
	}

	public final LocalTime getHorafin() {
		return horafin;
	}

	private final void setHorafin(LocalTime horafin) {
		this.horafin = UtilDateTime.getDefaultLocalTime(horafin);
	}

	public final ReservaDomain getReserva() {
		return reserva;
	}

	public final void setReserva(ReservaDomain reserva) {
		this.reserva = UtilObject.getDefault(reserva, ReservaDomain.getDefaultObject());
	}
	
	
	
	

}
